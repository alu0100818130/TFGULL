package dao;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    private Connection conn = null;
    // ---------- CREAR LA BDD EN DERBY -------------
    public Connection crearBD(){
    	Operaciones op = new Operaciones();
    	try{
    		//Obtenemos el driver de para mysql
    		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    		//Obtenemos la conexion
    		Path currentRelativePath = Paths.get("");
    		String s = currentRelativePath.toAbsolutePath().toString();
    		conn = DriverManager.getConnection("jdbc:derby:" + s +"\\DB\\Derby.DB;create=true");
    		JOptionPane.showMessageDialog(null,"Creada con éxito la BDD");
    		String creartabla = "CREATE TABLE Cartas(NAME varchar(50), EDITION varchar(50), RARITY varchar(50), CNT varchar(50), RESERV varchar(2), ONUSE varchar(2), LASTREV varchar(50), MINPR varchar(50), TENDPR varchar(50), FOILPR varchar(50), PRIMARY KEY (NAME, EDITION, RARITY, RESERV, ONUSE))";
    		String firstInsert = " INSERT INTO Cartas ( NAME, EDITION, RARITY, CNT, RESERV, ONUSE, LASTREV, MINPR, TENDPR, FOILPR ) VALUES ( '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' ) ";
    		op.executeCmm(creartabla, conn);
    		op.executeCmm(firstInsert, conn);
    	} catch (SQLException | ClassNotFoundException e) {
    		JOptionPane.showMessageDialog(null,"Alguna instancia de la BDD continúa abierta");
    	}
    	return conn;
    }
    // ---------- ACCEDER A LA BDD EN DERBY -------------
    public Connection accederBD(boolean mss){
    	try{
	        //Obtenemos el driver de para mysql
	        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	        //Obtenemos la conexion
    		Path currentRelativePath = Paths.get("");
    		String s = currentRelativePath.toAbsolutePath().toString();
	        conn = DriverManager.getConnection("jdbc:derby:" + s + "\\DB\\Derby.DB");
	        if (mss){ JOptionPane.showMessageDialog(null,"Base de Datos reconocida"); }
    	}catch(SQLException | ClassNotFoundException e){
    		JOptionPane.showMessageDialog(null,"No se ha encontrado una BDD \nSe procede a su creación");
    		crearBD();
    	}
       return conn;
    }
    // ---------- CERRAR LA BDD DE DERBY -------------
    public void cerracon (){
    	try { conn.close(); } 
    	catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
