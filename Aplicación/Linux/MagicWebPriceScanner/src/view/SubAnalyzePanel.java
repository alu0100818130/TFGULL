package view;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.ShellExec;
import model.AlmacenVersiones;

@SuppressWarnings("serial")
public class SubAnalyzePanel extends JPanel{
	private static final Logger LOGGER = Logger.getLogger("view.SubAnalizePanel");
	private boolean error = false;
	private boolean found = false;
	private JLabel text;
	private JTextField nombreCarta = new JTextField("-", 27);
	private JComboBox<String> versionList;
	private JPanel photoPanel = new JPanel();
	private JPanel namePanel = new JPanel();
	private JPanel versionPanel = new JPanel();
	public SubAnalyzePanel(GlobalAnalyzePanel father) {
		/** ----------------------------------------------------- **/
		setMaximumSize(new Dimension(350, 600));
		setMinimumSize(new Dimension(350, 600));
	    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		getPhotoPanel().setLayout(new BoxLayout(getPhotoPanel(), BoxLayout.PAGE_AXIS));
		getNamePanel().setLayout(new BoxLayout(getNamePanel(), BoxLayout.PAGE_AXIS));
		getVersionPanel().setLayout(new BoxLayout(getVersionPanel(), BoxLayout.PAGE_AXIS));
		/** ----------------------------------------------------- **/
		ArrayList<String> versions = new ArrayList<>();
		getNombreCarta().setEnabled(false);
		if(father.getActualAnalizedCard() != null) {
			if(father.getActualAnalizedCard().getNombreCarta().length() < 27) {
				getNombreCarta().setColumns(27 - father.getActualAnalizedCard().getNombreCarta().length());
			}
			else { getNombreCarta().setColumns(0); }
			getNombreCarta().setText(father.getActualAnalizedCard().getNombreCarta());
			int y = 2;
			for(int i = 0; i < father.getActualAnalizedCard().getNumVersiones(); i++) {
				if(versions.contains(father.getActualAnalizedCard().getVersiones(i).getExpansion())) {
					versions.add(father.getActualAnalizedCard().getVersiones(i).getExpansion() + " " + y);
					y++;
				}
				else { 
					y = 2;
					versions.add(father.getActualAnalizedCard().getVersiones(i).getExpansion()); 
				}
			}
		}
		// --------------------------------------------------------------------------
		JComboBox<String> x = new JComboBox<>();
		for(int i = 0; i < versions.size(); i++) { x.addItem(versions.get(i)); }
		setVersionList(x);
	    setText(new JLabel());
		getText().setSize(312, 445);
		Icon icono = new ImageIcon(father.getIcon().getImage().getScaledInstance(312, 445, Image.SCALE_DEFAULT));
		getText().setIcon(icono);
		getPhotoPanel().add(getText());
		getPhotoPanel().add(Box.createRigidArea(new Dimension(0, 5)));
		getPhotoPanel().add(new JLabel("                                                                     Imagen a analizar"));
		getNombreCarta().setMaximumSize(new Dimension(1000, 30));
		getNombreCarta().setHorizontalAlignment(JTextField.CENTER); 
		getNamePanel().setMaximumSize(new Dimension(1000, 50));
		getNamePanel().add(new JLabel("     "));
		getNamePanel().add(getNombreCarta());
		getVersionPanel().add(getVersionList());
		// --------------------------------------------------------------------------
		add(getPhotoPanel());
		add(Box.createRigidArea(new Dimension(0, 10)));
		// --------------------------------------------------------------------------
		add(getNamePanel());
		add(Box.createRigidArea(new Dimension(0, 20)));
		// --------------------------------------------------------------------------
		getVersionList().setMaximumSize(new Dimension(650, 30));
		add(getVersionPanel());
		add(Box.createRigidArea(new Dimension(0, 5)));
		add(new JLabel("                                                                                   Versiones"));
		// --------------------------------------------------------------------------
		setController(father);
	}
	public void setController(GlobalAnalyzePanel father) {
		// ---- CONTROLADOR DE LA FOTO ----
		getText().addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) { /** No needed */ }
			@Override
			public void mousePressed(MouseEvent e) { /** No needed */ }
			@Override
			public void mouseReleased(MouseEvent e) {
				openFileChooser().ifPresent( (File file) -> lee(file, father) );
				//-----
				if(isFound()) {
					try { 
						ShellExec shxt = new ShellExec();
						String nuevaCarta = shxt.executeFile(father.getURLstring());
						String nombreCarta2 = nuevaCarta.replaceAll(" ", "+");
						String urlGeneral = "https://www.cardmarket.com/es/Magic/Cards/" + nombreCarta2;
						String line = new String(urlGeneral.getBytes("ISO-8859-1"), "UTF-8");
						line = line.replaceAll("\\,", "%2C");
						line = line.replaceAll("\\'", "%27");
						AlmacenVersiones x = new AlmacenVersiones(line, nuevaCarta);
						replaceUI(x, father);
					} 
					catch (IOException | NoSuchFieldException e1) { 
						JOptionPane.showMessageDialog(null,"Error en la detección de la carta");
						try {
							Path currentRelativePath = Paths.get("");
							String s = currentRelativePath.toAbsolutePath().toString();
							Image img = ImageIO.read(new File(s + "/src/view/Card.png"));
							father.setIcon(new ImageIcon(img));
						} catch (IOException e2) { LOGGER.log(Level.INFO, "No se ha encontrado Card.png"); }
					} 
				}
				father.getMainFrame().toFront();
			}
			@Override
			public void mouseEntered(MouseEvent e) { /** No needed */ }
			@Override
			public void mouseExited(MouseEvent e) { /** No needed */ }
		});
		
		
		// --------------------------------
		getVersionList().addActionListener(versionL -> {
			father.setActualVersionToShow(getVersionList().getSelectedIndex());
			father.getgDP().getsGDP().getMinField().setText(Double.toString(father.getActualAnalizedCard().getVersiones(father.getActualVersionToShow()).getMinimoPrecio()));
			father.getgDP().getsGDP().getTendField().setText(Double.toString(father.getActualAnalizedCard().getVersiones(father.getActualVersionToShow()).getTendenciaPrecio()));
			father.getgDP().getsGDP().getFoilField().setText(Double.toString(father.getActualAnalizedCard().getVersiones(father.getActualVersionToShow()).getFoilPrecio()));
			try {
				father.getgDP().getsGDP().getAddBDD().getCantidadField().setText("" + father.getgDP().getsGDP().getAddBDD().getOp().countFromDB("NAME = '" + father.getActualAnalizedCard().getNombreCarta() + "' AND EDITION = '" + father.getActualAnalizedCard().getVersiones(father.getActualVersionToShow()).getExpansion() + "' AND RARITY = '" + father.getActualAnalizedCard().getVersiones(father.getActualVersionToShow()).getRarity() + "' AND RESERV = 'NO' AND ONUSE = 'NO'", father.getgDP().getsGDP().getAddBDD().getCon()));
			}catch(Exception ex) { father.getgDP().getsGDP().getAddBDD().getCantidadField().setText("0"); }
		});
	}
	
	public void replaceUI(AlmacenVersiones x, GlobalAnalyzePanel father) throws NoSuchFieldException {
		if(x.getNombreCarta() == "-") { throw new NoSuchFieldException(); }
		father.setActualAnalizedCard(x);
		//-----
		father.setsAP(new SubAnalyzePanel(father));
		father.setgDP(new GlobalDataPanel(father));
		Component[] componentList = father.getComponents();
		for(Component c : componentList){
		    if(c instanceof SubAnalyzePanel || c instanceof GlobalDataPanel){ father.remove(c); }
		}
		father.add(father.getsAP(), BorderLayout.WEST);
		father.add(father.getgDP(), BorderLayout.CENTER);
		setFound(false);
	}
	
	public Optional<File> openFileChooser() {
		JFileChooser fileSelector = new JFileChooser();
		fileSelector.setDialogTitle("Seleccionar Imagen");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG", "png", "image-png");
		FileNameExtensionFilter filter2 = new FileNameExtensionFilter("JPG", "jpg", "image-png");
		fileSelector.setFileFilter(filter);
		fileSelector.setFileFilter(filter2);
		fileSelector.setAcceptAllFileFilterUsed(false);
		int flag = fileSelector.showOpenDialog(null);
		if (flag == JFileChooser.APPROVE_OPTION) {
			setFound(true);
			return Optional.of(fileSelector.getSelectedFile());
		} else {
			setFound(false);
			return Optional.empty();
		}
	}
	public void lee(File file, GlobalAnalyzePanel father) {
		String fileName = file.getName();
		fileName=fileName.substring(fileName.lastIndexOf('.')+1);
		switch(fileName){
		case "png":
			try { readImage(file, father); } 
			catch (IOException e) {
				LOGGER.log(Level.INFO, "La imagen .PNG no sirve.");
				error=true;
			}	
		break;
		case "jpg":
			try { readImage(file, father); } 
			catch (IOException e) {
				LOGGER.log(Level.INFO, "La imagen .JPG no sirve.");
				error=true;
			}
		break;	
		default:
			LOGGER.log(Level.INFO, "No soportamos dicho formato");
			error=true;
        break;	
		}
	}

	public void readImage(File file, GlobalAnalyzePanel father) throws IOException {
		BufferedImage image = ImageIO.read(file); 
		ImageIcon example = new ImageIcon(image);
		father.setIcon(example);
		String cadenaURL = file.getAbsolutePath().replaceAll("\\\\", "\\/");
		father.setURLstring(cadenaURL);
	}
	
	public boolean returnState(){ return (!error); }
	public JLabel getText() { return text; }
	public JComboBox<String> getVersionList() { return versionList; }
	public JTextField getNombreCarta() { return nombreCarta; }
	public JPanel getPhotoPanel(){ return photoPanel; }
	public JPanel getNamePanel(){ return namePanel; }
	public JPanel getVersionPanel(){ return versionPanel; }
	public void setText(JLabel text) { this.text = text; }
	public void setVersionList(JComboBox<String> versionList) { this.versionList = versionList; }
	public void setNombreCarta(JTextField nombreCarta) { this.nombreCarta = nombreCarta; }
	public void setFound(boolean found) { this.found = found; }
	public void setPhotoPanel(JPanel photoPanel){ this.photoPanel = photoPanel; }
	public void setNamePanel(JPanel namePanel){ this.namePanel = namePanel; }
	public void setVersionPanel(JPanel versionPanel){ this.versionPanel = versionPanel; }
	public boolean isFound() { return found; }
}
