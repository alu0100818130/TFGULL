package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GlobalDataPanel extends JPanel{
	private SubGlobalDataPanel sGDP;
	public GlobalDataPanel(GlobalAnalyzePanel father){
		setsGDP(new SubGlobalDataPanel(father));
		this.setLayout(new BorderLayout(30, 30));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setMaximumSize(new Dimension(562, 602));
		this.setMinimumSize(new Dimension(562, 602));
		this.add(getsGDP());
	}
	public SubGlobalDataPanel getsGDP() { return sGDP; }
	public void setsGDP(SubGlobalDataPanel sGDP) { this.sGDP = sGDP; }
}
