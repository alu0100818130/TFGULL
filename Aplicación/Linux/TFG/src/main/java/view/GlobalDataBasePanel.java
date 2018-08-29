package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.sql.Connection;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import dao.Conexion;
import dao.Operaciones;

@SuppressWarnings("serial")
public class GlobalDataBasePanel extends JPanel{
	private static final String DELETE = "DELETE";
	private JScrollPane scroll;
	private JPanel tablePanel;
	private JPanel buttonsPanel;
	private transient Connection con;
	private transient Operaciones op;
	private transient Conexion cn;
	private MainFrame mainFrame;
	private String[] columnas = { "NAME", "EDITION", "RARITY", "CNT", "RESERV", "ONUSE", "LASTREV", "MINPR", "TENDPR", "FOILPR", "EDIT", DELETE };
	public GlobalDataBasePanel(MainFrame mf) {
		// --------------------------------------------------
		setMainFrame(mf);
        setCn(new Conexion());
        setOp(new Operaciones());
        setCon(getCn().accederBD(false));
        prepareTable();
		// --------------------------------------------------
		setTablePanel(new TablePanel(getScroll())); 
		setButtonsPanel(new ButtonsPanel(this));
		this.setLayout(new BorderLayout(30, 30));
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.add(getTablePanel(), BorderLayout.CENTER);
		this.add(getButtonsPanel(), BorderLayout.EAST);
	}

	public void rechargeUI() {
		prepareTable();
		setTablePanel(new TablePanel(getScroll()));
		setButtonsPanel(new ButtonsPanel(this));
		Component[] componentList = getComponents();
		for(Component c : componentList){
		    if(c instanceof JPanel){ remove(c); }
		}
		this.add(getTablePanel(), BorderLayout.CENTER);
		this.add(getButtonsPanel(), BorderLayout.EAST);
	}
	
	public void prepareTable() {
        JTable tableX = new JTable(getOp().getCartas(getCon()), getColumnas()) {
            @Override
            public boolean isCellEditable(int row, int column) {    
            	return(this.getColumnModel().getColumn(column).getHeaderValue().equals("EDIT") ||
            		   this.getColumnModel().getColumn(column).getHeaderValue().equals(DELETE));
            }
        };
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableX.getColumn("NAME").setCellRenderer(centerRenderer);
        tableX.getColumn("EDITION").setCellRenderer(centerRenderer);
        tableX.getColumn("RARITY").setCellRenderer(centerRenderer);
        tableX.getColumn("CNT").setCellRenderer(centerRenderer);
        tableX.getColumn("RESERV").setCellRenderer(centerRenderer);
        tableX.getColumn("ONUSE").setCellRenderer(centerRenderer);
        tableX.getColumn("LASTREV").setCellRenderer(centerRenderer);
        tableX.getColumn("MINPR").setCellRenderer(centerRenderer);
        tableX.getColumn("TENDPR").setCellRenderer(centerRenderer);
        tableX.getColumn("FOILPR").setCellRenderer(centerRenderer);
        tableX.getColumn("EDIT").setCellRenderer(new ButtonRenderer());
        tableX.getColumn("EDIT").setCellEditor(new ButtonEditor(new JCheckBox(), true, tableX, this));
        tableX.getColumn(DELETE).setCellRenderer(new ButtonRenderer());
        tableX.getColumn(DELETE).setCellEditor(new ButtonEditor(new JCheckBox(), false, tableX, this));
        setScroll(new JScrollPane(tableX));
	}
	
	public JPanel getTablePanel() { return tablePanel; }
	public JPanel getButtonsPanel() { return buttonsPanel; }
	public Connection getCon() { return con; }
	public Operaciones getOp() { return op; }
	public Conexion getCn() { return cn; }
	public String[] getColumnas() { return columnas; }
	public JScrollPane getScroll() { return scroll; }
	public MainFrame getMainFrame() { return mainFrame; }
	public void setTablePanel(JPanel tablePanel) { this.tablePanel = tablePanel; }
	public void setButtonsPanel(JPanel buttonsPanel) { this.buttonsPanel = buttonsPanel; }
	public void setCon(Connection con) { this.con = con; }
	public void setOp(Operaciones op) { this.op = op; }
	public void setCn(Conexion cn) { this.cn = cn; }
	public void setColumnas(String[] columnas) { this.columnas = columnas; }
	public void setScroll(JScrollPane scroll) { this.scroll = scroll; }
	public void setMainFrame(MainFrame mainFrame) { this.mainFrame = mainFrame; }
}
