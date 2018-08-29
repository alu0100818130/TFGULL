package view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonsPanel extends JPanel {
	private JButton actualizarButton = new JButton("Actualizar");
	public ButtonsPanel(GlobalDataBasePanel father) {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(getActualizarButton());
		this.setController(father);
	}
	public void setController(final GlobalDataBasePanel father) {
		getActualizarButton().addActionListener(rechargeB -> father.rechargeUI() );
	}
	public JButton getActualizarButton() { return actualizarButton; }
	public void setActualizarButton(JButton actualizarButton) { this.actualizarButton = actualizarButton; }
}
