package client;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import shared.Student;

public class MyListView implements ListCellRenderer {

	static DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

	public Component getListCellRendererComponent(JList<? extends Student> list, Student value, int index,
			boolean isSelected, boolean cellHasFocus) {
		JLabel lbl = (JLabel) defaultRenderer.getListCellRendererComponent(list, value.toString(), index, isSelected,
				cellHasFocus);
		lbl.setPreferredSize(new Dimension(300, 20));
		return lbl;
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		// TODO Auto-generated method stub
		return null;
	}

	


	

}