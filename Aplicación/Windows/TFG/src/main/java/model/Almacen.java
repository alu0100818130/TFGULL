package model;

import java.io.IOException;

import controller.ReadFromWeb;

public class Almacen {
	private String url;		// URL donde est� la informaci�n de la carta
	private String expansion;
	private double tendenciaPrecio;
	private double minimoPrecio;
	private double foilPrecio;
	private String rarity;
	// Posible variable para edici�n de la carta
	
	public Almacen(){}
	public Almacen(String url) throws IOException{ 
		setUrl(url);
		ReadFromWeb.readFromWeb(this);
	}
	public void setUrl(String url){ this.url = url; }
	public void setTendenciaPrecio(double tendenciaPrecio){ this.tendenciaPrecio = tendenciaPrecio; }
	public void setMinimoPrecio(double minimoPrecio){ this.minimoPrecio = minimoPrecio; }
	public void setFoilPrecio(double foilPrecio){ this.foilPrecio = foilPrecio; }
	public void setExpansion(String expansion){ this.expansion = expansion; }
	public String getUrl(){ return url; }
	public double getTendenciaPrecio(){ return tendenciaPrecio; }
	public double getMinimoPrecio(){ return minimoPrecio; }
	public double getFoilPrecio(){ return foilPrecio; }
	public String getExpansion(){ return expansion; }
	public String getRarity() { return rarity; }
	public void setRarity(String rarity) { this.rarity = rarity; }
}
