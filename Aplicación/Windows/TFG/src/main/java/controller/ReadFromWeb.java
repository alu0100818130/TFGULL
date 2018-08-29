package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import model.Almacen;

public class ReadFromWeb {
	
	private static final Logger LOGGER = Logger.getLogger("controller.ReadFromWeb");
	private static final String REGEXPRARITY = "\\'(Rare|Mythic|Uncommon|Common)\\'";
	private static final String REGEXPMINPRICE = "(From|De)(<([\\+\\w\\d\\s\\=\\\"\\\\\\/\\_\\:\\;\\'\\(\\)\\.\\-\\%\\,\\p{L}])*>){0,3}\\d+(\\,\\d{1,2})?";
	private static final String REGEXPTENDPRICE = "(Tendencia\\sde\\sprecio|Price\\sTrend)(<([\\+\\w\\d\\s\\=\\\"\\\\\\/\\_\\:\\;\\'\\(\\)\\.\\-\\%\\,\\p{L}])*>){0,3}\\d+(\\,\\d{1,2})?";
	private static final String REGEXPFOILPRICE = "?foilMode=1";
    
	private ReadFromWeb() { throw new IllegalStateException("Utility class"); }
    public static void readFromWeb(Almacen actualCard) throws IOException {
        String version = actualCard.getUrl().replaceAll("https://www.cardmarket.com/(es|en)/Magic/Products/Singles/",  "");
        version = version.replaceAll("\\/.*", "");
        version = version.replaceAll("[\\+]", " ");
        actualCard.setExpansion(version.replaceAll("%3A", ""));
    	URL url = new URL(actualCard.getUrl());
        InputStream is =  url.openStream();
        try( BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            final Pattern minPattern = Pattern.compile(REGEXPMINPRICE);
            final Pattern tendPattern = Pattern.compile(REGEXPTENDPRICE); 
            final Pattern rarityPattern = Pattern.compile(REGEXPRARITY);
            boolean encontrado = false;
            boolean encontrado2 = false;
			boolean encontrado3 = false;
			line = new String(br.readLine().getBytes("ISO-8859-1"), "UTF-8");
            while (line != null && (!encontrado && !encontrado2 && !encontrado3)) {
                Matcher matcher = minPattern.matcher(line); 
                Matcher matcher2 = tendPattern.matcher(line); 
                Matcher matcher3 = rarityPattern.matcher(line); 
                if(matcher.find()) { 
                	actualCard.setMinimoPrecio(getPriceValue(matcher.group())); 
                	encontrado = true;
                }
                if(matcher2.find()) { 
                	actualCard.setTendenciaPrecio(getPriceValue(matcher2.group()));  
                	encontrado2 = true;
                }
                if(matcher3.find()) {
                	actualCard.setRarity(getRarityValue(matcher3.group(0))); 
                	encontrado3 = true;
                }
                if((line = br.readLine()) != null) {
                	line = new String(line.getBytes("ISO-8859-1"), "UTF-8");
                }
            }
            setFoilPrice(actualCard);
        }
        catch (MalformedURLException e) {
        	LOGGER.log(Level.INFO, "Error en el URL");
            JOptionPane.showMessageDialog(null,"Error en el URL");
            throw new MalformedURLException("URL is malformed!!");
        }
        catch (IOException e) {
        	LOGGER.log(Level.INFO, "Error en la conexión a Internet");
            JOptionPane.showMessageDialog(null,"Error en la conexión a Internet");
            throw new IOException();
        }
    }
    
    public static void setFoilPrice(Almacen actualCard) throws IOException {
    	URL url = new URL(actualCard.getUrl() + REGEXPFOILPRICE);
        InputStream is =  url.openStream();
        try( BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
        	final Pattern minPattern = Pattern.compile(REGEXPMINPRICE);
        	boolean encontrado = false;
        	String line = new String(br.readLine().getBytes("ISO-8859-1"), "UTF-8");
        	while (line != null && !encontrado){
        		Matcher matcher = minPattern.matcher(line); 
                if(matcher.find()) { 
                	actualCard.setFoilPrecio(getPriceValue(matcher.group())); 
                	encontrado = true;
                }
                if((line = br.readLine()) != null) {
                	line = new String(line.getBytes("ISO-8859-1"), "UTF-8");
                }
        	}
        }
    }
    
    public static double getPriceValue(String stringToAnalize) {
    	String val = stringToAnalize.replaceAll("[(De|From)|(Tendencia\\sde\\sprecio|Price\\sTrend)|Foils\\s(de|from)](<([\\+\\w\\d\\s\\=\\\"\\\\\\/\\_\\:\\;\\'\\(\\)\\.\\-\\%\\,\\p{L}])*>){0,3}", "");   	
    	val = val.replaceAll(",", ".");
    	return Double.parseDouble(val);
    }
    
    public static String getRarityValue(String rawRarity) {
    	return rawRarity.replaceAll("\\'", "");
    }
}
