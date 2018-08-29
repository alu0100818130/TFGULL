package view;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.AlmacenVersiones;

@SuppressWarnings("serial")
public class GlobalAnalyzePanel extends JPanel{
	private static final Logger LOGGER = Logger.getLogger("view.GlobalAnalizePanel");
	private int actualVersionToShow = 0;
	private SubAnalyzePanel sAP;
	private GlobalDataPanel gDP;
	private ImageIcon icon = new ImageIcon();
	private transient AlmacenVersiones actualAnalizedCard = null;
	private String urlString;
	private MainFrame mainFrame;
	public GlobalAnalyzePanel(MainFrame mf) {
		setMainFrame(mf);
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		Image img;
		try {
			img = ImageIO.read(new File(s + "\\src\\view\\Card.png"));
			setIcon(new ImageIcon(img));
		} catch (IOException e) {
			LOGGER.log(Level.INFO, "Error al leer la imagen por defecto");
		}
		setsAP(new SubAnalyzePanel(this));
		setgDP(new GlobalDataPanel(this));
		this.setLayout(new BorderLayout(30, 30));
		this.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));
		this.add(getsAP(), BorderLayout.WEST);
		this.add(getgDP(), BorderLayout.CENTER);
	}
	public int getActualVersionToShow() { return actualVersionToShow; }
	public SubAnalyzePanel getsAP() { return sAP; }
	public GlobalDataPanel getgDP() { return gDP; }
	public ImageIcon getIcon() { return icon; }
	public AlmacenVersiones getActualAnalizedCard() { return actualAnalizedCard; }
	public String getURLstring() { return urlString; }
	public MainFrame getMainFrame() { return mainFrame; }
	public void setActualVersionToShow(int actualVersionToShow) { this.actualVersionToShow = actualVersionToShow; }
	public void setsAP(SubAnalyzePanel sAP) { this.sAP = sAP; }
	public void setgDP(GlobalDataPanel gDP) { this.gDP = gDP; }
	public void setIcon(ImageIcon icon) { this.icon = icon; }
	public void setActualAnalizedCard(AlmacenVersiones actualAnalizedCard) { this.actualAnalizedCard = actualAnalizedCard; }
	public void setURLstring(String uRLstring) { urlString = uRLstring; }
	public void setMainFrame(MainFrame mainFrame) { this.mainFrame = mainFrame; }
}
