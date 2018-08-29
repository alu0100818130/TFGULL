package view;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import dao.Conexion;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private JPanel analizeTab = new JPanel();
	private JPanel dataBaseTab = new JPanel();
	private JTabbedPane pestanas = new JTabbedPane();
	private transient Conexion cn;
	public MainFrame(){
        cn = new Conexion();
        cn.accederBD(true);
	}
	public void start() {
        this.addWindowListener(new java.awt.event.WindowAdapter() { // CLAVE
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
		// ---- INITIAL CONFIG ----
		setAnalizeTab(new GlobalAnalyzePanel(this));
		setDataBaseTab(new GlobalDataBasePanel(this));
		this.getPestanas().addTab("Analyze", getAnalizeTab());
		this.getPestanas().addTab("Base de Datos", getDataBaseTab());
		getContentPane().add(this.getPestanas());
		// Detalles de Ventana
		this.setMinimumSize(new Dimension(990, 720));
		this.setMaximumSize(new Dimension(990, 720));
		this.setResizable(false);
		this.setVisible(true);
	}	
	public JPanel getAnalizeTab() { return analizeTab; }
	public JPanel getDataBaseTab() { return dataBaseTab; }
	public JTabbedPane getPestanas() { return pestanas; }
	public void setAnalizeTab(JPanel analizeTab) { this.analizeTab = analizeTab; }
	public void setDataBaseTab(JPanel dataBaseTab) { this.dataBaseTab = dataBaseTab; }
	public void setPestanas(JTabbedPane pestanas) { this.pestanas = pestanas; }
}
