import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.junit.Test;
import model.AlmacenVersiones;
import view.AddToBDDPanel;
import view.ButtonEditor;
import view.ButtonRenderer;
import view.EditFrame;
import view.GlobalAnalyzePanel;
import view.GlobalDataBasePanel;
import view.MainFrame;
import view.ManualSearchPanel;
import view.SubAnalyzePanel;

public class TestView {

	@Test
	public void testAddToBDDPanel() {
		try {
			GlobalAnalyzePanel father = new GlobalAnalyzePanel(new MainFrame());
			AddToBDDPanel test = new AddToBDDPanel(father);
			father.setActualAnalizedCard(new AlmacenVersiones("https://www.cardmarket.com/en/Magic/Cards/Nexus-of-Fate", "Nexus of Fate"));
			father.setActualVersionToShow(0);
			test.getCartaField().setText("TestCard");
			test.getCantidadField().setText("4");
			test.getMinusButton().doClick();
			test.getPlusButton().doClick();
			test.getDoneButton().doClick();
			test.getCantidadField().setText("-4");
			test.getPlusButton().doClick();
			assertNotEquals(null, test.getCn());		
		} catch (IOException e) { e.printStackTrace(); }
	}

	@Test
	public void testSETSAddToBDDPanel() {
		try {
			// Aquí solo se van a llamar a métodos "set" para comprobar que se pueden
			// cambiar los elementos de la interfaz.
			GlobalAnalyzePanel father = new GlobalAnalyzePanel(new MainFrame());
			AddToBDDPanel test = new AddToBDDPanel(father);
			father.setActualAnalizedCard(new AlmacenVersiones("https://www.cardmarket.com/en/Magic/Cards/Nexus-of-Fate", "Nexus of Fate"));
			father.setActualVersionToShow(0);
			// Pruebas simples de cambio de instancia de botones
			test.setMinusButton(new JButton());
			test.setPlusButton(new JButton());
			test.setDoneButton(new JButton());
			// Pruebas simples de cambio de instancia de campos de texto
			test.setCartaField(new JTextField("-", 27));
			test.setCantidadField(new JTextField("0", 20));
		} catch (IOException e) { e.printStackTrace(); }	
	}
	
	@Test
	public void testEditFrame() {
		GlobalDataBasePanel father = new GlobalDataBasePanel(new MainFrame());
		EditFrame test = new EditFrame();
		List<String> x = new ArrayList<>();
		x.add("Nexus of Fate");
		x.add("Buy a Box Promos");
		x.add("MYTHIC");
		x.add(new Date().toString());
		x.add("1");
		x.add("10");
		x.add("15");
		test.start(x, father);
		test.getDoneButton().doClick();
		test.closeWindow(father);
		assertNotEquals(null, test.getCn());
	}
	
	@Test
	public void testSETSEditFrame() {
		// Aquí solo se van a llamar a métodos "set" para comprobar que se pueden
		// cambiar los elementos de la interfaz.
		GlobalDataBasePanel father = new GlobalDataBasePanel(new MainFrame());
		EditFrame test = new EditFrame();
		List<String> x = new ArrayList<>();
		x.add("Nexus of Fate");
		x.add("Buy a Box Promos");
		x.add("MYTHIC");
		x.add(new Date().toString());
		x.add("1");
		x.add("10");
		x.add("15");
		test.start(x, father);
		test.setEditPanel(new JPanel());
		test.setCantNorm(new JTextField());
		test.setCantReserv(new JTextField());
		test.setCantEnUso(new JTextField());
		test.setDoneButton(new JButton());
		Integer[] values = null;
		test.setInitialValues(values);
	}
	
	@Test
	public void testSubAnalizePanel() {
		try {
			GlobalAnalyzePanel father = new GlobalAnalyzePanel(new MainFrame());
			father.setActualAnalizedCard(new AlmacenVersiones("https://www.cardmarket.com/en/Magic/Cards/Nexus-of-Fate", "Nexus of Fate"));
			father.setActualVersionToShow(0);
			SubAnalyzePanel test = new SubAnalyzePanel(father);
			test.replaceUI(new AlmacenVersiones("https://www.cardmarket.com/en/Magic/Cards/Nexus-of-Fate", "Nexus of Fate"), father);
			test.openFileChooser().ifPresent( (File file) -> test.lee(file, father) );
		} catch (IOException | NoSuchFieldException e) { 
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testSETSSubAnalizePanel() {
		// Aquí solo se van a llamar a métodos "set" para comprobar que se pueden
		// cambiar los elementos de la interfaz.
		try {
			GlobalAnalyzePanel father = new GlobalAnalyzePanel(new MainFrame());
			father.setActualAnalizedCard(new AlmacenVersiones("https://www.cardmarket.com/en/Magic/Cards/Nexus-of-Fate", "Nexus of Fate"));
			father.setActualVersionToShow(0);
			SubAnalyzePanel test = new SubAnalyzePanel(father);
			assertTrue(test.returnState());
			test.setNombreCarta(new JTextField());
			test.setPhotoPanel(new JPanel());
			test.setNamePanel(new JPanel());
			test.setVersionPanel(new JPanel());
			assertFalse(test.isFound());
		} catch (IOException e) { 
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testButtonEditor() {
		String[] columnas = { "NAME", "EDITION", "RARITY", "CNT", "RESERV", "ONUSE", "LASTREV", "MINPR", "TENDPR", "FOILPR", "EDIT", "DELETE" };
		String[][] table = { {"TEST"}, {"TEST"}, {"COMMON"}, {"3"}, {"NO"}, {"NO"}, {new Date().toString()}, {"1"}, {"10"}, {"15"}, {"EDIT"}, {"DELETE"}};
		GlobalDataBasePanel father = new GlobalDataBasePanel(new MainFrame());
		JTable tableTest = new JTable(table, columnas);
		ButtonEditor bttnEd = new ButtonEditor(new JCheckBox(), true, tableTest, father);
		ButtonRenderer bttnRnd = new ButtonRenderer();
		bttnEd.setEdit(false);
		bttnEd.setPushed(true);
        tableTest.getColumn("EDIT").setCellRenderer(new ButtonRenderer());
        tableTest.getColumn("EDIT").setCellEditor(bttnEd);
		assertNotNull(tableTest.getColumn("EDIT").getCellEditor().getTableCellEditorComponent(tableTest, "EDIT", true, 0, 9));
		assertNotNull(tableTest.getColumn("EDIT").getCellEditor().getTableCellEditorComponent(tableTest, "EDIT", false, 0, 9));
		assertNotNull(bttnEd.getTableX());
		assertNotNull(bttnRnd.getTableCellRendererComponent(tableTest, "EDIT", true, true, 0, 9));
		assertNotNull(bttnRnd.getTableCellRendererComponent(tableTest, "EDIT", false, true, 0, 9));
		assertEquals(father, bttnEd.getFather());
		assertEquals(0, bttnEd.getRowX(), 0);
		assertFalse(bttnEd.isEdit());
		assertTrue(tableTest.getColumn("EDIT").getCellEditor().stopCellEditing());
	}
	
	@Test
	public void testMainFrame() {
		MainFrame x = new MainFrame();
		x.start();
		// Único "set" no cubierto por pruebas.
		x.setPestanas(new JTabbedPane());
	}
	
	@Test
	public void testManualSearchPanel() {
		ManualSearchPanel test = new ManualSearchPanel(new GlobalAnalyzePanel(new MainFrame()));
		test.getSearchField().setText("Nexus of Fate");
		test.getSearchButton().doClick();
	}
	
	@Test
	public void testSETSManualSearchPanel() {
		// Aquí solo se van a llamar a métodos "set" para comprobar que se pueden
		// cambiar los elementos de la interfaz.
		ManualSearchPanel test = new ManualSearchPanel(new GlobalAnalyzePanel(new MainFrame()));
		test.setSearchField(new JTextField());
		test.setSearchPanel(new JPanel());
		test.setTextPanel(new JPanel());
		test.setSearchButton(new JButton());
	}
}
