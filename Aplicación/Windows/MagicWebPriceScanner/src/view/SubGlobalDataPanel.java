package view;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SubGlobalDataPanel extends JPanel{
	private double minPrice = 0.0;
	private double tendPrice = 0.0;
	private double foilPrice = 0.0;
	private JTextField minField = new JTextField("-", 7);
	private JTextField tendField = new JTextField("-", 7);
	private JTextField foilField = new JTextField("-", 7);
	private AddToBDDPanel addBDD;
	public SubGlobalDataPanel(GlobalAnalyzePanel father) {
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	    // ---------------------------------------------------
		JPanel minPanel = new JPanel();
		JPanel tendPanel = new JPanel();
		JPanel foilPanel = new JPanel();
		minPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		tendPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		foilPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		minPanel.setMaximumSize(new Dimension(1000, 30));
		tendPanel.setMaximumSize(new Dimension(1000, 30));
		foilPanel.setMaximumSize(new Dimension(1000, 30));
		// ---------------------------------------------------
		minField.setEnabled(false);
		tendField.setEnabled(false);
		foilField.setEnabled(false);
		if(father.getActualAnalizedCard() != null && father.getActualAnalizedCard().getNumVersiones() != 0) {
			minField.setText(Double.toString(father.getActualAnalizedCard().getVersiones(father.getActualVersionToShow()).getMinimoPrecio()));
			tendField.setText(Double.toString(father.getActualAnalizedCard().getVersiones(father.getActualVersionToShow()).getTendenciaPrecio()));
			foilField.setText(Double.toString(father.getActualAnalizedCard().getVersiones(father.getActualVersionToShow()).getFoilPrecio()));
		}
		minField.setHorizontalAlignment(JTextField.CENTER); 
		tendField.setHorizontalAlignment(JTextField.CENTER); 
		foilField.setHorizontalAlignment(JTextField.CENTER); 
		// ---------------------------------------------------
	    minPanel.add(new JLabel("PRECIO MÍNIMO: "));
	    tendPanel.add(new JLabel("PRECIO TENDENCIA: "));
	    foilPanel.add(new JLabel("PRECIO MÍNIMO FOIL: "));
	    minPanel.add(getMinField());
	    tendPanel.add(getTendField());
	    foilPanel.add(getFoilField());
	    minPanel.add(new JLabel(" €"));
	    tendPanel.add(new JLabel(" €"));
	    foilPanel.add(new JLabel(" €"));
	    // ---------------------------------------------------
	    
	    setAddBDD(new AddToBDDPanel(father));
	    
	    // ---------------------------------------------------
	    add(minPanel);
	    add(tendPanel);
	    add(foilPanel);
	    add(Box.createRigidArea(new Dimension(0, 20)));
	    add(getAddBDD());
	    add(Box.createRigidArea(new Dimension(0, 20)));
	    add(new ManualSearchPanel(father));
	}
	public double getMinPrice() { return minPrice; }
	public double getTendPrice() { return tendPrice; }
	public double getFoilPrice() { return foilPrice; }
	public JTextField getMinField() { return minField; }
	public JTextField getTendField() { return tendField; }
	public JTextField getFoilField() { return foilField; }
	public AddToBDDPanel getAddBDD() { return addBDD; }
	public void setMinPrice(double minPrice) { this.minPrice = minPrice; }
	public void setTendPrice(double tendPrice) { this.tendPrice = tendPrice; }
	public void setFoilPrice(double foilPrice) { this.foilPrice = foilPrice; }
	public void setMinField(JTextField minField) { this.minField = minField; }
	public void setTendField(JTextField tendField) { this.tendField = tendField; }
	public void setFoilField(JTextField foilField) { this.foilField = foilField; }
	public void setAddBDD(AddToBDDPanel addBDD) { this.addBDD = addBDD; }
}
