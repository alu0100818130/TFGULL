package view;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class ButtonEditor extends DefaultCellEditor {
	
	protected JButton button;
	private String label;
	private boolean isPushed;
	private boolean edit;
	private Integer rowX;
	private JTable tableX;
	private GlobalDataBasePanel father;
  
	public ButtonEditor(JCheckBox checkBox, boolean ed, JTable table, GlobalDataBasePanel father) {
		super(checkBox);
		setEdit(ed);
		setTableX(table);
		setFather(father);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener( fireB -> fireEditingStopped() );
	}
  
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		setRowX(row);
		if (isSelected) {
			button.setForeground(table.getSelectionForeground());
			button.setBackground(table.getSelectionBackground());
		} else{
			button.setForeground(table.getForeground());
			button.setBackground(table.getBackground());
		}
		label = (value ==null) ? "" : value.toString();
		button.setText( label );
		isPushed = true;
		return button;
	}
  
	@Override
	public Object getCellEditorValue() {
		if (isPushed && !getTableX().getValueAt(getRowX(), getTableX().getColumn("NAME").getModelIndex()).toString().equals("-")) {
			if(isEdit()) {
				EditFrame x = new EditFrame();
				List<String> values = new ArrayList<>();
				values.add(getTableX().getValueAt(getRowX(), getTableX().getColumn("NAME").getModelIndex()).toString());
				values.add(getTableX().getValueAt(getRowX(), getTableX().getColumn("EDITION").getModelIndex()).toString());
				values.add(getTableX().getValueAt(getRowX(), getTableX().getColumn("RARITY").getModelIndex()).toString());
				values.add(getTableX().getValueAt(getRowX(), getTableX().getColumn("LASTREV").getModelIndex()).toString());
				values.add(getTableX().getValueAt(getRowX(), getTableX().getColumn("MINPR").getModelIndex()).toString());
				values.add(getTableX().getValueAt(getRowX(), getTableX().getColumn("TENDPR").getModelIndex()).toString());
				values.add(getTableX().getValueAt(getRowX(), getTableX().getColumn("FOILPR").getModelIndex()).toString());
				x.start(values, getFather());
				getFather().getMainFrame().setEnabled(false);
			}
			else {
				father.getOp().insert("NAME, EDITION, RARITY, CNT, RESERV, ONUSE, LASTREV, MINPR, TENDPR, FOILPR",
					           "'" + getTableX().getValueAt(getRowX(), getTableX().getColumn("NAME").getModelIndex()).toString() + 
					           "','" + getTableX().getValueAt(getRowX(), getTableX().getColumn("EDITION").getModelIndex()).toString() + 
					           "','" + getTableX().getValueAt(getRowX(), getTableX().getColumn("RARITY").getModelIndex()).toString() + 
					           "','0','" + getTableX().getValueAt(getRowX(), getTableX().getColumn("RESERV").getModelIndex()).toString() + 
					           "','" + getTableX().getValueAt(getRowX(), getTableX().getColumn("ONUSE").getModelIndex()).toString() + 
					           "','" + getTableX().getValueAt(getRowX(), getTableX().getColumn("LASTREV").getModelIndex()).toString() +
					           "','" + getTableX().getValueAt(getRowX(), getTableX().getColumn("MINPR").getModelIndex()).toString() +
					           "','" + getTableX().getValueAt(getRowX(), getTableX().getColumn("TENDPR").getModelIndex()).toString() +
					           "','" + getTableX().getValueAt(getRowX(), getTableX().getColumn("FOILPR").getModelIndex()).toString() +
					           "'", father.getCon());
				father.rechargeUI();
			}
		}
		isPushed = false;
		return label;
	}
    
	@Override
	public boolean stopCellEditing() {
		isPushed = false;
		return super.stopCellEditing();
	}

	public boolean isEdit() { return edit; }
	public JTable getTableX() { return tableX; }
	public GlobalDataBasePanel getFather() { return father; }
	public Integer getRowX() { return rowX; }
	public void setPushed(boolean is) { isPushed = is; } 
	public void setEdit(boolean edit) { this.edit = edit; }
	public void setTableX(JTable tableX) { this.tableX = tableX; }
	public void setFather(GlobalDataBasePanel father) { this.father = father; }
	public void setRowX(Integer rowX) { this.rowX = rowX; }
}