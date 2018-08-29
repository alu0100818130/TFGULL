package controller;
import model.AlmacenVersiones;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.Normalizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import model.Almacen;

public class ReadVersionsFromWeb {
	
	private static final Logger LOGGER = Logger.getLogger("controller.ReadVersionsFromWeb");
	private static final String REGEXPNUMVERSIONS = "\\d+\\sversions";
	private static final String ISO = "ISO-8859-1";
	private static final String UTF8 = "UTF-8";
	private static final String REGEXPM = "\\p{M}";
	
	private ReadVersionsFromWeb() { throw new IllegalStateException("Utility class"); }
	public static void readVersionsFW(AlmacenVersiones actualCard) throws IOException {
        try {
        	String replaceURL = actualCard.getGeneralUrl();
        	replaceURL = replaceURL.replaceAll("\\/es\\/", "\\/en\\/");
        	actualCard.setGeneralUrl(replaceURL);
        	searchVersions(actualCard);
            tryVersions(actualCard);
        }
        catch (MalformedURLException e) {
        	String replaceURL = actualCard.getGeneralUrl();
        	replaceURL = replaceURL.replaceAll("\\/en\\/", "\\/es\\/");
        	actualCard.setGeneralUrl(replaceURL);
        	searchVersions(actualCard);
        }
        catch (IOException e) {
            LOGGER.log(Level.INFO, "Error en la conexión a Internet");
            JOptionPane.showMessageDialog(null,"Error en la conexión a Internet");
            throw new IOException();
        }
        catch (Exception ex) {
        	JOptionPane.showMessageDialog(null,"No se ha encontrado la carta a buscar");
        	actualCard.setNombreCarta("-");
        }
	}
	
	public static void searchVersions(AlmacenVersiones actualCard) throws IOException {
        Document doc = Jsoup.connect(actualCard.getGeneralUrl() + "/Versions").get();
        String line = doc.toString();  
        if(line!= null) {
        	line = new String(line.getBytes(ISO), UTF8);
        	line = Normalizer.normalize(line, Normalizer.Form.NFD);
        	line = line.replaceAll(REGEXPM, "");
        	line = line.replaceAll("\\s\\s+", "");
        	if(!line.contains("no existe") && !line.contains("not exist")) {
        		getVersions(actualCard,line);
        	}
        	else { throw new MalformedURLException("No se ha podido leer el contenido web"); }
        }
	}
	
	public static void tryVersions(AlmacenVersiones actualCard) throws MalformedURLException {
        if(actualCard.getSizeVersiones() == 0) { throw new MalformedURLException("Error: Probando otro idioma"); }
	}
	
	public static void getVersions(AlmacenVersiones actualCard, String line) throws IOException {
        final Pattern numVersionsPattern = Pattern.compile(REGEXPNUMVERSIONS); 
        Matcher matcher;
        boolean encontrado = false;
    	while (!encontrado) {
        	matcher = numVersionsPattern.matcher(line);              	
            if(matcher.find()) { 
            	actualCard.setNumVersiones(getNumVersionValue(matcher.group()));
            	getArrayVersiones(line, actualCard);
            	encontrado = true;
            }
            if(line != null) {
            	line = new String(line.getBytes(ISO), UTF8);
            	line = Normalizer.normalize(line, Normalizer.Form.NFD);
            	line = line.replaceAll(REGEXPM, "");
            }
        }
	}
	
    public static int getNumVersionValue(String stringToAnalize) {
    	String val = stringToAnalize.replaceAll("\\sversions", "");  
    	return Integer.parseInt(val);
    }
    
    public static void getArrayVersiones(String stringVersiones, AlmacenVersiones actualCard) throws IOException {
    	String nameField = actualCard.getNombreCarta();
    	nameField = nameField.replaceAll(" ", "-");
    	String regExpHrefFilter = "href\\=\\\"\\/(es|en)\\/Magic\\/Products\\/Singles\\/([\\+\\w\\d\\s\\=\\\"\\\\\\_\\:\\;\\'\\(\\)\\.\\-\\%\\,\\p{L}])*\\/" + nameField;
    	String versionToProcess;
    	final Pattern hrefFilterPattern = Pattern.compile(regExpHrefFilter);
    	Matcher hrefFilterMatcher = hrefFilterPattern.matcher(stringVersiones);
    	for(int i = 0; i < actualCard.getNumVersiones(); i++) {
	    	if(hrefFilterMatcher.find()) {
	    		versionToProcess = hrefFilterMatcher.group();
	    		versionToProcess = versionToProcess.replaceAll("href=", "");
	    		versionToProcess = versionToProcess.replaceAll("\"", "");
	    		actualCard.addVersion(new Almacen("https://www.cardmarket.com" + versionToProcess));
	    	}
    	}
    }
}