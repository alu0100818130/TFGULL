import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;

import model.Almacen;
import model.AlmacenVersiones;

public class TestModel {

	@Test
	public void testVoidAlmacenVersiones() {
		AlmacenVersiones card = new AlmacenVersiones();
		assertEquals(null, card.getNombreCarta());
		assertEquals(null, card.getGeneralUrl());
		assertEquals(0, card.getNumVersiones());
	}

	@Test
	public void testAlmacenVersiones() {
		try {
			AlmacenVersiones card = new AlmacenVersiones("https://www.cardmarket.com/en/Magic/Cards/Nexus-of-Fate", "Nexus of Fate");
			assertEquals("Nexus of Fate", card.getNombreCarta());
		} catch (IOException e) { 
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testAlmacen() {
		Almacen versionToTest = new Almacen();
		versionToTest.setUrl("https://www.cardmarket.com/en/Magic/Products/Singles/Buy+a+Box+Promos/Nexus-of-Fate");
		versionToTest.setExpansion("Buy a Box Promos");
		versionToTest.setMinimoPrecio(1);
		versionToTest.setTendenciaPrecio(10);
		versionToTest.setFoilPrecio(15);
		assertEquals("https://www.cardmarket.com/en/Magic/Products/Singles/Buy+a+Box+Promos/Nexus-of-Fate", versionToTest.getUrl());
		assertEquals("Buy a Box Promos", versionToTest.getExpansion());
		assertEquals(1, versionToTest.getMinimoPrecio(), 0);
		assertEquals(10, versionToTest.getTendenciaPrecio(), 0);
		assertEquals(15, versionToTest.getFoilPrecio(), 0);
	}
	
	@Test
	public void testChangeAlmacenVersiones() {
		try {
			AlmacenVersiones card = new AlmacenVersiones("https://www.cardmarket.com/en/Magic/Cards/Nexus-of-Fate", "Nexus of Fate");
			Almacen versionToTest = new Almacen();
			versionToTest.setUrl("https://www.cardmarket.com/en/Magic/Products/Singles/Buy+a+Box+Promos/Nexus-of-Fate");
			versionToTest.setExpansion("Buy a Box Promos");
			versionToTest.setMinimoPrecio(1);
			versionToTest.setTendenciaPrecio(10);
			versionToTest.setFoilPrecio(15);
			card.setVersiones(versionToTest, 0);
			assertEquals(10, card.getVersiones(0).getTendenciaPrecio(), 0);
			assertEquals("Buy a Box Promos", card.getVersiones(0).getExpansion());
		} catch (IOException e) { 
			e.printStackTrace();
			fail();
		}
	}
}
