package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.Conexion;
import dao.Operaciones;

@SuppressWarnings("serial")
public class EditFrame extends JFrame{
	private static final String NAME = "NAME = '";
	private static final String EDITION = "' AND EDITION = '";
	private static final String RARITY = "' AND RARITY = '";
	private static final String FIELDS = "NAME, EDITION, RARITY, CNT, RESERV, ONUSE, LASTREV, MINPR, TENDPR, FOILPR";
	private JPanel editPanel = new JPanel();
	private JTextField cantNorm = new JTextField("-", 5);
	private JTextField cantReserv = new JTextField("-", 5);
	private JTextField cantEnUso = new JTextField("-", 5);
	private JButton doneButton = new JButton("Done");
	private Integer[] initialValues = new Integer[3];
	private transient Conexion cn;
	private transient Connection con;
	private transient Operaciones op;
	private String nameE;
	private String ediT;
	private String rarY;
	private String lastR;
	private String minpR;
	private String tendpR;
	private String foilpR;
	
	public EditFrame() {
        setCn(new Conexion());
        setOp(new Operaciones());
        setCon(cn.accederBD(false));
	}
	public void start(List<String> values, final GlobalDataBasePanel father) {
	    setNamE(values.get(0));
	    setEdiT(values.get(1));
	    setRaritY(values.get(2));
	    setLastR(values.get(3));
	    setMinpR(values.get(4));
	    setTendpR(values.get(5));
	    setFoilpR(values.get(6));
		getEditPanel().setLayout(new BorderLayout(5, 5));
	    
		// ------------- CABECERA --------------------
		
		JPanel cabecera = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cabecera.add(new JLabel("Editar carta: " + getNamE() + " (" + getEdiT() + ")"));
		
		// ------------- CANTIDADES ------------------
		
		JPanel cantidades = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel cantidadesNormal = new JPanel();
		cantidadesNormal.setLayout(new BoxLayout(cantidadesNormal, BoxLayout.PAGE_AXIS));
		JPanel cantidadesReservadas = new JPanel();
		cantidadesReservadas.setLayout(new BoxLayout(cantidadesReservadas, BoxLayout.PAGE_AXIS));
		JPanel cantidadesEnUso = new JPanel();
		cantidadesEnUso.setLayout(new BoxLayout(cantidadesEnUso, BoxLayout.PAGE_AXIS));
		JPanel textNormal = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel textReservadas = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel textEnUso = new JPanel(new FlowLayout(FlowLayout.CENTER));
		textNormal.add(new JLabel("Cantidad:"));
		textReservadas.add(new JLabel("Reservadas:"));
		textEnUso.add(new JLabel("En Uso:"));
		getCantNorm().setHorizontalAlignment(JTextField.CENTER);
		getCantReserv().setHorizontalAlignment(JTextField.CENTER);
		getCantEnUso().setHorizontalAlignment(JTextField.CENTER);
		getInitialValues()[0] = Integer.parseInt(getOp().countFromDB(NAME + getNamE() + EDITION + getEdiT() + RARITY + getRaritY() + "' AND RESERV = 'NO' AND ONUSE = 'NO'", getCon()));
		getInitialValues()[1] = Integer.parseInt(getOp().countFromDB(NAME + getNamE() + EDITION + getEdiT() + RARITY + getRaritY() + "' AND RESERV = 'SI' AND ONUSE = 'NO'", getCon()));
		getInitialValues()[2] = Integer.parseInt(getOp().countFromDB(NAME + getNamE() + EDITION + getEdiT() + RARITY + getRaritY() + "' AND RESERV = 'NO' AND ONUSE = 'SI'", getCon()));
		getCantNorm().setText("" + getInitialValues()[0]);
		getCantReserv().setText("" + getInitialValues()[1]);
		getCantEnUso().setText("" + getInitialValues()[2]);
		cantidadesNormal.add(textNormal);
		cantidadesNormal.add(getCantNorm());
		cantidadesReservadas.add(textReservadas);
		cantidadesReservadas.add(getCantReserv());
		cantidadesEnUso.add(textEnUso);
		cantidadesEnUso.add(getCantEnUso());
		
		cantidades.setBorder(BorderFactory.createLineBorder(Color.black));
		cantidades.add(cantidadesNormal);
		cantidades.add(cantidadesReservadas);
		cantidades.add(cantidadesEnUso);
		
		// ------------- DONE BUTTON -----------------
		
		JPanel donePanel = new JPanel();
		donePanel.add(getDoneButton());
		
		getEditPanel().add(cabecera, BorderLayout.NORTH);
		getEditPanel().add(cantidades, BorderLayout.CENTER);
		getEditPanel().add(donePanel, BorderLayout.EAST);
		getEditPanel().add(new JLabel(""), BorderLayout.WEST);
		getEditPanel().add(new JLabel(""), BorderLayout.SOUTH);
		this.add(getEditPanel());
        this.addWindowListener(new java.awt.event.WindowAdapter() { 
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                father.getMainFrame().setEnabled(true);
            }
        });
		this.setMinimumSize(new Dimension(400, 150));
		this.setMaximumSize(new Dimension(400, 150));
		this.setResizable(false);
		this.setVisible(true);
		setController(father);
	}
	
	public void setController(final GlobalDataBasePanel father) {
		getDoneButton().addActionListener(doneB -> {
			try {
				int cantidadNormal = 0;
				int cantidadReserv = 0;
				int cantidadEnUso  = 0;
				if(!getCantNorm().getText().equals("")) {
					cantidadNormal = Integer.parseInt(getCantNorm().getText());
				}
				if(!getCantReserv().getText().equals("")) {
					cantidadReserv = Integer.parseInt(getCantReserv().getText());
				}
				if(!getCantEnUso().getText().equals("")) {	
					cantidadEnUso  = Integer.parseInt(getCantEnUso().getText());
				}
				if(cantidadNormal >= 0 && cantidadReserv >= 0 && cantidadEnUso >= 0) {
					getOp().insert(FIELDS,
							       "'" + getNamE() + "','" + getEdiT() + "','" + getRaritY() + "','" + cantidadNormal + "','NO','NO','" + getLastR() + "','" + getMinpR() + "','" + getTendpR() + "','" + getFoilpR() + "'",
							       getCon());
					getOp().insert(FIELDS,
						           "'" + getNamE() + "','" + getEdiT() + "','" + getRaritY() + "','" + cantidadReserv + "','SI','NO','" + getLastR() + "','" + getMinpR() + "','" + getTendpR() + "','" + getFoilpR() + "'",
						           getCon());
					getOp().insert(FIELDS,
						           "'" + getNamE() + "','" + getEdiT() + "','" + getRaritY() + "','" + cantidadEnUso + "','NO','SI','" + getLastR() + "','" + getMinpR() + "','" + getTendpR() + "','" + getFoilpR() + "'",
						           getCon());
				}
				else { throw new IllegalArgumentException("Valores irreconocibles introducidos"); }
				closeWindow(father);
				father.rechargeUI();
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en los valores introducidos");
				getCantNorm().setText("" + getInitialValues()[0]);
				getCantReserv().setText("" + getInitialValues()[1]);
				getCantEnUso().setText("" + getInitialValues()[2]);
			}
		});
	}
	
	public void closeWindow(GlobalDataBasePanel father) { 
		this.dispose();
		father.getMainFrame().setEnabled(true);
		father.getMainFrame().toFront();
	}
	
	public JPanel getEditPanel() { return editPanel; }
	public JTextField getCantEnUso() { return cantEnUso; }
	public JTextField getCantNorm() { return cantNorm; }
	public JTextField getCantReserv() { return cantReserv; }
	public JButton getDoneButton() { return doneButton; }
	public Conexion getCn() { return cn; }
	public Connection getCon() { return con; }
	public Operaciones getOp() { return op; }
	public Integer[] getInitialValues() { return initialValues; }
	public String getNamE() { return nameE; }
	public String getEdiT() { return ediT; }
	public String getMinpR() { return minpR; }
	public String getLastR() { return lastR; }
	public String getTendpR() { return tendpR; }
	public String getFoilpR() { return foilpR; }
	public String getRaritY() { return rarY; }
	public void setEditPanel(JPanel editPanel) { this.editPanel = editPanel; }
	public void setCantNorm(JTextField cantNorm) { this.cantNorm = cantNorm; }
	public void setCantReserv(JTextField cantReserv) { this.cantReserv = cantReserv; }
	public void setCantEnUso(JTextField cantEnUso) { this.cantEnUso = cantEnUso; }
	public void setDoneButton(JButton doneButton) { this.doneButton = doneButton; }
	public void setCn(Conexion cn) { this.cn = cn; }
    public void setCon(Connection con) { this.con = con; }
    public void setOp(Operaciones op) { this.op = op; }
	public void setInitialValues(Integer[] initialValues) { this.initialValues = initialValues; }
	public void setNamE(String namE) { this.nameE = namE; }
	public void setEdiT(String ediT) { this.ediT = ediT; }
	public void setMinpR(String minpR) { this.minpR = minpR; }
	public void setLastR(String lastR) { this.lastR = lastR; }
	public void setTendpR(String tendpR) { this.tendpR = tendpR; }
	public void setFoilpR(String foilpR) { this.foilpR = foilpR; }
	public void setRaritY(String raritY) { this.rarY = raritY; }
}
