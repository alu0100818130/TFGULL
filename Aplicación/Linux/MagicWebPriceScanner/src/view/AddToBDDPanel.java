package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.Serializable;
import java.sql.Connection;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicArrowButton;

import dao.Conexion;
import dao.Operaciones;

public class AddToBDDPanel extends JPanel implements Serializable{
	private static final long serialVersionUID = 6654893663659160198L;
	private JTextField cartaField = new JTextField("-", 27);
	private JTextField cantidadField = new JTextField("0", 20);
	private transient Connection con;
	private transient Operaciones op;
	private transient Conexion cn;
	private JButton minusButton = new BasicArrowButton(BasicArrowButton.WEST);
	private JButton plusButton = new BasicArrowButton(BasicArrowButton.EAST);
	private JButton doneButton = new JButton("Añadir a la Base de Datos");
	public AddToBDDPanel(GlobalAnalyzePanel father) {
        setCn(new Conexion());
        setOp(new Operaciones());
        setCon(cn.accederBD(false));
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		// --------------------------------------------------------------
		JPanel introPanel = new JPanel();
		introPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		introPanel.add(new JLabel("             Añadir cartas a la Base de Datos             "));
		introPanel.add(new JLabel("(La edición es la seleccionada bajo la carta)"));
		// --------------------------------------------------------------
		JPanel panelGeneral = new JPanel(); 
		panelGeneral.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelGeneral.setBorder(BorderFactory.createEmptyBorder(00, 20, 20, 20));
		// --------------------------------------------------------------
		JPanel carta = new JPanel();
		carta.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		getCartaField().setEnabled(false);
		getCartaField().setHorizontalAlignment(JTextField.CENTER); 
		if(father.getActualAnalizedCard() != null) {
			getCartaField().setText(father.getActualAnalizedCard().getNombreCarta());
		}
		carta.add(new JLabel("      CARTA:    "));
		carta.add(getCartaField());
		// --------------------------------------------------------------
		JPanel cantidad = new JPanel();
		cantidad.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		getCantidadField().setHorizontalAlignment(JTextField.CENTER); 
		if(father.getActualAnalizedCard() != null) {
			try {
				getCantidadField().setText("" + getOp().countFromDB("NAME = '" + father.getActualAnalizedCard().getNombreCarta() + "' AND EDITION = '" + father.getActualAnalizedCard().getVersiones(father.getActualVersionToShow()).getExpansion() + "' AND RARITY = '" + father.getActualAnalizedCard().getVersiones(father.getActualVersionToShow()).getRarity() + "' AND RESERV = 'NO' AND ONUSE = 'NO'", getCon()));
			}catch(Exception ex) { getCantidadField().setText("0"); }
		}
		cantidad.add(new JLabel("CANTIDAD:    "));
		cantidad.add(getMinusButton());
		cantidad.add(getCantidadField());
		cantidad.add(getPlusButton());
		// --------------------------------------------------------------
		JPanel donePanel = new JPanel();
		donePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		donePanel.add(getDoneButton());
		// --------------------------------------------------------------
		add(Box.createRigidArea(new Dimension(0, 20)));
		panelGeneral.add(carta);
		panelGeneral.add(cantidad);
		panelGeneral.add(donePanel);
		add(introPanel);
		add(panelGeneral);
		add(Box.createRigidArea(new Dimension(0, 30)));
		setController(father);
	}
	public void setController(final GlobalAnalyzePanel father) {
		setDoneController(father);
		setPlusMinusController();
	}
	public void setDoneController(final GlobalAnalyzePanel father) {
		getDoneButton().addActionListener(doneB -> {
				if(!getCartaField().getText().equals("-")) {
					try{
						int cantidad = Integer.parseInt(getCantidadField().getText());
						if(cantidad >= 0) {
							getOp().insert("NAME, EDITION, RARITY, CNT, RESERV, ONUSE, LASTREV, MINPR, TENDPR, FOILPR",
									       "'" + father.getActualAnalizedCard().getNombreCarta() + "','" + father.getActualAnalizedCard().getVersiones(father.getActualVersionToShow()).getExpansion() + "','" + father.getActualAnalizedCard().getVersiones(father.getActualVersionToShow()).getRarity() + "','" + cantidad + "','NO','NO','" + new Date() + "','" + father.getActualAnalizedCard().getVersiones(father.getActualVersionToShow()).getMinimoPrecio() + "','" + father.getActualAnalizedCard().getVersiones(father.getActualVersionToShow()).getTendenciaPrecio() + "','" + father.getActualAnalizedCard().getVersiones(father.getActualVersionToShow()).getFoilPrecio() + "'",
									       getCon());
						}
						else {
							JOptionPane.showMessageDialog(null,"No se aceptan número negativos");
							getCantidadField().setText("0");
						}
					} catch(Exception ex) {
						JOptionPane.showMessageDialog(null,"Error al añadir entrada a la BDD");
					}
				}
		});
	}
	public void setPlusMinusController() {
		getMinusButton().addActionListener(minusB -> {
				if(!getCartaField().getText().equals("-")) {
						int cantidad = Integer.parseInt(getCantidadField().getText());
						if(cantidad > 0) {
							cantidad--;
							getCantidadField().setText(cantidad + "");
						}
				}
		});
		
		
		getPlusButton().addActionListener(plusB -> {
				if(!getCartaField().getText().equals("-")) {
					int cantidad = Integer.parseInt(getCantidadField().getText());
					if(cantidad >= 0) {
						cantidad++;
						getCantidadField().setText(cantidad + "");
					}
					else { getCantidadField().setText("0"); }
				}
		});
	}
	
	public JTextField getCartaField() { return cartaField; }
	public JButton getDoneButton() { return doneButton; }
	public JTextField getCantidadField() { return cantidadField; }
	public Connection getCon() { return con; }
	public Operaciones getOp() { return op; }
	public Conexion getCn() { return cn; }
	public JButton getMinusButton() { return minusButton; }
	public JButton getPlusButton() { return plusButton; }
	public void setCartaField(JTextField cartaField) { this.cartaField = cartaField; }
	public void setDoneButton(JButton doneButton) { this.doneButton = doneButton; }
	public void setCantidadField(JTextField cantidadField) { this.cantidadField = cantidadField; }
	public void setCon(Connection con) { this.con = con; }
	public void setOp(Operaciones op) { this.op = op; }
	public void setCn(Conexion cn) { this.cn = cn; }
	public void setMinusButton(JButton minusButton) { this.minusButton = minusButton; }
	public void setPlusButton(JButton plusButton) { this.plusButton = plusButton; }
}
