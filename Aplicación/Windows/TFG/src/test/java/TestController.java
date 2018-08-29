import static org.junit.Assert.*;
import org.junit.Test;
import java.io.IOException;
import controller.ImageFromWeb;
import controller.ShellExec;
import model.AlmacenVersiones;
import view.GlobalAnalyzePanel;
import view.MainFrame;

public class TestController {
	
	@Test
	public void testgetImageFW() {
		AlmacenVersiones actualCard;
		try {
			actualCard = new AlmacenVersiones("https://www.cardmarket.com/en/Magic/Cards/Nexus-of-Fate", "Nexus of Fate");
			ImageFromWeb.getImageFW(actualCard, new GlobalAnalyzePanel(new MainFrame()));
		} catch (IOException e) { 
			e.printStackTrace();
			fail("Se ha detectado mal la imagen de la carta");
		}
	}
	
	@Test
	public void testReadVersionsFromWeb() {
		AlmacenVersiones actualCard;
		try {
			actualCard = new AlmacenVersiones("https://www.cardmarket.com/en/Magic/Cards/Nexus-of-Fate", "Nexus of Fate");
			assertEquals(1, actualCard.getNumVersiones());
		} catch (IOException e) { 
			e.printStackTrace();
			fail("Se ha detectado mal el número de versiones");
		}
	}
	
	@Test
	public void testReadFromWeb() {
		AlmacenVersiones actualCard;
		try {
			actualCard = new AlmacenVersiones("https://www.cardmarket.com/en/Magic/Cards/Nexus-of-Fate", "Nexus of Fate");
			assertEquals("Buy a Box Promos", actualCard.getVersiones(0).getExpansion());
		} catch (IOException e) { 
			e.printStackTrace();
			fail("Se ha detectado mal las versiones versiones");
		}
	}
	
	@Test
	public void testEncriptar() {
		String text = ShellExec.encriptar("EncryptTest");
		assertEquals("emdOrI/TO8vf1RoACqjsgg==", text);
	}

	@Test
	public void testDesencriptar() {
		String text = ShellExec.desencriptar("HG4e3GYkNJc2EM6vci3jsw==");
		assertEquals("DesencryptTest", text);
	}		
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testExecuteFile() {
		// Faltan los ficheros para que la conexión se realize por completo.
		// Se espera una excepción.
		ShellExec test = new ShellExec();
		test.executeFile("/Image.jpg");
	}
}