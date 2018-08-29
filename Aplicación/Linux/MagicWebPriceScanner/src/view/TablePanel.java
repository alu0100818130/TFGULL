package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class TablePanel extends JPanel{
	public TablePanel(JScrollPane tabla) {
		this.setLayout(new BorderLayout(30, 30));
		this.add(tabla);
	}
}
