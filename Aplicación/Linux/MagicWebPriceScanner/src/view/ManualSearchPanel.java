package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ImageFromWeb;
import model.AlmacenVersiones;

@SuppressWarnings("serial")
public class ManualSearchPanel extends JPanel{
	private JTextField searchField = new JTextField("", 27);
	private JPanel searchPanel = new JPanel();
	private JPanel textPanel = new JPanel();
	private JButton searchButton = new JButton("Buscar");
	public ManualSearchPanel(GlobalAnalyzePanel father) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setMaximumSize(new Dimension(500, 400));
		setMinimumSize(new Dimension(500, 400));
		setBorder(BorderFactory.createLineBorder(Color.black));
		getSearchPanel().setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		getSearchPanel().setMaximumSize(new Dimension(600, 40));
		getSearchPanel().setMinimumSize(new Dimension(600, 40));
		getTextPanel().setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		getTextPanel().setMaximumSize(new Dimension(600, 40));
		getTextPanel().setMinimumSize(new Dimension(600, 40));
		/** ---------------------------------------------------------------- **/
		getSearchPanel().add(getSearchField());
		getSearchPanel().add(getSearchButton());
		getTextPanel().add(new JLabel("Buscar carta por su nombre:"));
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(getTextPanel());
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(getSearchPanel());
		add(Box.createRigidArea(new Dimension(0, 10)));
		setController(father);
	}
	public void setController(final GlobalAnalyzePanel father) {
		getSearchButton().addActionListener(searchB -> throwSearching(father));
		getSearchField().addActionListener(searchF -> throwSearching(father));
	}
	public void throwSearching(GlobalAnalyzePanel father) {
		if(!getSearchField().getText().equals("")) {
			try{
				String nuevaCarta = getSearchField().getText();
				String nombreCarta2 = nuevaCarta.replaceAll(" ", "-");
				String urlGeneral = "https://www.cardmarket.com/es/Magic/Cards/" + nombreCarta2;
				String line = new String(urlGeneral.getBytes("ISO-8859-1"), "UTF-8");
				line = line.replaceAll("\\,", "%2C");
				line = line.replaceAll("\\'", "%27");
				AlmacenVersiones x = new AlmacenVersiones(line, nuevaCarta);
				if(x.getNombreCarta().equals("-")) {
					Path currentRelativePath = Paths.get("");
					String s = currentRelativePath.toAbsolutePath().toString();
					Image img = ImageIO.read(new File(s + "/src/view/Card.png"));
					father.setIcon(new ImageIcon(img));
				}
				else {
					ImageFromWeb.getImageFW(x, father);
				}
				father.setActualAnalizedCard(x);
				father.setsAP(new SubAnalyzePanel(father));
				father.setgDP(new GlobalDataPanel(father));
				Component[] componentList = father.getComponents();
				for(Component c : componentList){
				    if(c instanceof SubAnalyzePanel || c instanceof GlobalDataPanel){ father.remove(c); }
				}
				father.add(father.getsAP(), BorderLayout.WEST);
				father.add(father.getgDP(), BorderLayout.CENTER);
				father.getMainFrame().toFront();
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Error: No se ha encontrado la carta con dicho nombre");
			}
		}
		father.getMainFrame().toFront();
	}
	
	/** Métodos GETTER y SETTER **/
	public JTextField getSearchField(){ return searchField; }
	public JPanel getSearchPanel(){ return searchPanel; }
	public JButton getSearchButton(){ return searchButton; }
	public JPanel getTextPanel(){ return textPanel; }
	public void setSearchField(JTextField searchField){ this.searchField = searchField; }
	public void setSearchPanel(JPanel searchPanel){ this.searchPanel = searchPanel; }
	public void setSearchButton(JButton searchButton){ this.searchButton = searchButton; }
	public void setTextPanel(JPanel textPanel){ this.textPanel = textPanel; }
}
