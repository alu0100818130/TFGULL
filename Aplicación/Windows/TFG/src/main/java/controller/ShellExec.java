package controller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;


public class ShellExec{

	private static final Logger LOGGER = Logger.getLogger("controller.ShellExecuter");
	private static final String USERNAME = "usuario"; 	// username for remote host
    private static final String UTF8 = "utf-8"; 
	private static String secretKey = "ENCkey"; 	//llave para encriptar datos
	private static int port=22;
    
	public String executeFile(String urlIMG){
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		String psw = "";
		try (BufferedReader b = new BufferedReader(new FileReader(s + "\\client.sign"))) {
		    psw = b.readLine();
		} catch (Exception e1) { LOGGER.log(Level.INFO, "Error al leer el fichero client.sign"); }
		
		String host = "";
		try (BufferedReader b = new BufferedReader(new FileReader(s + "\\adr.config"))) {
		    host = b.readLine();
		} catch (Exception e1) { LOGGER.log(Level.INFO, "Error al leer el fichero adr.config"); }
		List<String> result = new ArrayList<>();
		try{
			JSch jsch = new JSch();
			Session session = jsch.getSession(USERNAME, host, port);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(desencriptar(psw));
			session.connect();
         
			/** IMAGEN **/
         
			Channel channel= session.openChannel("sftp");
			channel.connect();
         
			ChannelSftp channelSftp = (ChannelSftp)channel; 
			channelSftp.cd("/home/usuario/Programa/ocropy/");
         
			channelSftp.put(urlIMG, "a.jpg");
			channelSftp.disconnect();

			/*************/
         
			ChannelExec channelExec = (ChannelExec)session.openChannel("exec");
			InputStream in = channelExec.getInputStream();
         
			channelExec.setCommand("cd Programa/ocropy && bash Analizaimagen.sh a.jpg");
			channelExec.connect();

			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null){ result.add(line); }

			channelExec.disconnect();
			session.disconnect();
		}
		catch(Exception e) { JOptionPane.showMessageDialog(null,"Error en la conexión al servidor"); }
		return result.get(0);
	}
	
	// Encriptado MD5
	public static String encriptar(String texto) {
        String base64EncryptedString = "";
 
        try {
 
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(getSecretKey().getBytes(UTF8));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
 
            SecretKey key = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
 
            byte[] plainTextBytes = texto.getBytes(UTF8);
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);
 
        } catch (Exception ex) { LOGGER.log(Level.INFO, "Error al encriptar"); }
        return base64EncryptedString;
	}
	
	//Desencriptado MD5
	public static String desencriptar(String textoEncriptado) {
	    String base64EncryptedString = "";
	
	    try {
	        byte[] message = Base64.decodeBase64(textoEncriptado.getBytes(UTF8));
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        byte[] digestOfPassword = md.digest(getSecretKey().getBytes(UTF8));
	        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
	        SecretKey key = new SecretKeySpec(keyBytes, "AES");
	
	        Cipher decipher = Cipher.getInstance("AES");
	        decipher.init(Cipher.DECRYPT_MODE, key);
	
	        byte[] plainText = decipher.doFinal(message);
	
	        base64EncryptedString = new String(plainText, "UTF-8");
	
	    } catch (Exception ex) { LOGGER.log(Level.INFO, "Error al desencriptar"); }
	    return base64EncryptedString;
	}

	public static String getSecretKey(){ return secretKey; }
	public static void setSecretKey(String secretKey){ ShellExec.secretKey = secretKey; }
}