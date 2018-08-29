package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Operaciones {
	private static final Logger LOGGER = Logger.getLogger("dao.Operaciones");
	private static final String WHERE = " WHERE ";
	private static final String EDITION = " AND EDITION = ";
	private static final String RARITY = " AND RARITY = ";
	private static final String RESERV = " AND RESERV = ";
	private static final String ONUSE = " AND ONUSE = ";
	
	// --------- CONSULTAS SELECT -----------
    public Object [][] select(String fields, String where, Connection con){     
    	String[] colname = fields.split(",");

    	//Consultas SQL
    	String q = "SELECT " + fields + " FROM Cartas";
    	String q2 = "SELECT count(*) as total FROM Cartas";
    	if(where!=null){
    		q += WHERE + where;
    		q2 += WHERE + where;
    	}
    	int registros = getCountConsult(q2, con, "total");
    	//Se crea una matriz con tantas filas y columnas que necesite
    	Object[][] data = new String[registros][fields.split(",").length + 2];
    	//Realizamos la consulta sql y llenamos los datos en la matriz "Object"
    	try{
    		ResultSet res = pSToRs(q, con);
    		int i = 0;
    		while(res.next()){
	    		for(int j = 0; j <= fields.split(",").length - 1;j++){
	    			data[i][j] = res.getString(colname[j].trim());
	    		}
	    		if(i > 0) {
	    			data[i][fields.split(",").length] = "Edit";
	    			data[i][fields.split(",").length + 1] = "Delete";
	    		}
	    		else {
	    			data[i][fields.split(",").length] = "-";
	    			data[i][fields.split(",").length + 1] = "-";
	    		}
	    		i++;
    		}
    		res.close();
        } catch(SQLException e) { 
        	LOGGER.log(Level.INFO, "Error al leer de la base de datos");
        }
    	return data;
    }
    public String countFromDB(String where, Connection con){
    	String q2 = "SELECT CNT FROM Cartas";
    	if(where!=null){ q2 += WHERE + where; }
    	try {
    		PreparedStatement pstmt = con.prepareStatement(q2);
    		return returnedValue(pstmt);
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "No se ha encontrado dicha carta en la base de datos"); OPCIONAL
		}
    	return "0";
    }
    public String returnedValue(PreparedStatement pstmt) {
		try (ResultSet x = pstmt.executeQuery()) {
			x.next();
			return x.getString(1);
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "No se ha encontrado dicho valor en la base de datos"); OPCIONAL
		}
		return "0";
    }
    
	// --------- CONSULTAS INSERT -----------
    public boolean insert(String fields, String values, Connection con){
        boolean res = false;
        String[] valuesx = values.split(",");
        String consultCantidadWhere = "SELECT count(*) as total FROM Cartas WHERE NAME = " + valuesx[0] + EDITION + valuesx[1] + RARITY + valuesx[2] + RESERV + valuesx[4] + ONUSE + valuesx[5]; 
        String consultUpdateWhere = "UPDATE Cartas SET CNT = " + valuesx[3] + " WHERE NAME = " + valuesx[0] + EDITION + valuesx[1] + RARITY + valuesx[2] + RESERV + valuesx[4] + ONUSE + valuesx[5]; 
		if(getCountConsult(consultCantidadWhere, con, "total") == 1) {
			if(valuesx[3].equals("'0'")) {
				String x2 = "NAME = " + valuesx[0] + EDITION + valuesx[1] + RARITY + valuesx[2] + RESERV + valuesx[4] + ONUSE + valuesx[5];
				delete(x2, con); 
				res = true;
				JOptionPane.showMessageDialog(null, "Actualizado correctamente");
			}
			else {
				executeCmm(consultUpdateWhere, con);
				res = true;
			}
		}
		else {
			if(!valuesx[3].equals("'0'")) {
			    String q = " INSERT INTO Cartas ( " + fields + " ) VALUES ( " + values + " ) ";
			    executeCmm(q, con);
			    res = true;   
			}
		}
        return res;
    }     
    // --------- CONSULTAS DELETE --------------
    public void delete(String where, Connection con) {
    	String d = "DELETE FROM Cartas" + WHERE + where;
		executeCmm(d, con);
    }
    // --------- OBTENER LAS CARTAS ------------
    public Object[][] getCartas(Connection con){
    	Object[][] res = this.select("NAME, EDITION, RARITY, CNT, RESERV, ONUSE, LASTREV, MINPR, TENDPR, FOILPR", null, con);
        Object[][] nullVector = null;
    	if(res.length > 0) { return res; }
        else { return nullVector; }
    } 
    public ResultSet pSToRs(String consult, Connection con) {
    	try {
    		PreparedStatement pstm = con.prepareStatement(consult);
    		return pstm.executeQuery();
    	}
    	catch (SQLException ex) { JOptionPane.showMessageDialog(null, "Error en la ejecucion de consulta"); }
    	return null;
    }
    public void executeCmm(String consult, Connection con) {
		try (PreparedStatement pstm = con.prepareStatement(consult)) {		
	        pstm.execute();
		} catch (SQLException ex) { JOptionPane.showMessageDialog(null, ex.getLocalizedMessage()); }
    }
    public int getCountConsult(String consult, Connection con, String wtg) {
		try {
			ResultSet res = pSToRs(consult, con);
			res.next();
	    	return res.getInt(wtg);
		} catch (SQLException ex) { 
			JOptionPane.showMessageDialog(null, "Error en la extracción de información de una consulta");
		}
		return -1;
    }
}
