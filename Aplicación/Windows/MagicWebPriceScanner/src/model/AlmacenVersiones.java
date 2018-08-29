package model;

import java.io.IOException;
import java.util.ArrayList;

import controller.ReadVersionsFromWeb;

public class AlmacenVersiones {
	private String nombreCarta;
	private String generalUrl;
	private int numVersiones = 0;
	private ArrayList<Almacen> versiones = new ArrayList<>();

	public AlmacenVersiones(){}
	public AlmacenVersiones(String url, String name) throws IOException{ 
		setNombreCarta(name);
		setGeneralUrl(url);
		ReadVersionsFromWeb.readVersionsFW(this);
	}
	public Almacen getVersiones(int index) { return versiones.get(index); }
	public String getGeneralUrl() { return generalUrl; }
	public String getNombreCarta() { return nombreCarta; }
	public int getNumVersiones() { return numVersiones; }
	public int getSizeVersiones() { return versiones.size(); }
	public void setVersiones(Almacen version, int index) { this.versiones.set(index, version); }
	public void setGeneralUrl(String generalUrl) { this.generalUrl = generalUrl; }
	public void setNumVersiones(int numVersiones) { this.numVersiones = numVersiones; }
	public void setNombreCarta(String nombreCarta) { this.nombreCarta = nombreCarta; }
	public void addVersion(Almacen item) { this.versiones.add(item); }
}
