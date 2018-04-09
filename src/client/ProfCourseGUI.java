package client;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import shared.Course;
import shared.Professor;

public class ProfCourseGUI extends JFrame{

	private Container c;
	private JButton addCourseb;
	private JButton acDacb;
	private JButton viewCourseb;
	private JScrollPane courseListp;
	private JPanel buttonp;
	JList<String> courseJList;

	DefaultListModel<String> listModel;
	
	ArrayList<Course> courseList;
	
	Professor profUser;
	
	public ProfCourseGUI(Professor newProf) 
	{
		super("Course page");
		profUser = newProf;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		c = getContentPane();
		listModel = new DefaultListModel<String>();
		courseJList = new JList<String>(listModel);
		String width = "1234567890123456789012345678901234567890";
		courseJList.setPrototypeCellValue(width);
		courseJList.setVisibleRowCount(15);
		courseListp = new JScrollPane(courseJList);
		courseListp.setBorder(new EmptyBorder(15,15,15,15));
		
		buttonp = new JPanel();
		buttonp.setLayout(new BoxLayout(buttonp, BoxLayout.PAGE_AXIS));
		addCourseb = new JButton("add course");
		acDacb = new JButton("activate/deactivate course");
		viewCourseb = new JButton("view course");
		
		buttonp.add(addCourseb);
		buttonp.add(Box.createRigidArea(new Dimension(0,15)));
		buttonp.add(acDacb);
		buttonp.add(Box.createRigidArea(new Dimension(0,15)));
		buttonp.add(viewCourseb);
		addCourseb.setAlignmentX( Component.CENTER_ALIGNMENT );
		acDacb.setAlignmentX( Component.CENTER_ALIGNMENT );
		viewCourseb.setAlignmentX( Component.CENTER_ALIGNMENT );
		buttonp.setBorder(new EmptyBorder(15,15,15,15));
		c.add(courseListp, "Center");
		c.add(buttonp, "East");
	}
	
	public void updateCourseList()
	{
		//call the server, ask for a list of courses based on the profID, and update courseList
	}
	
	/**
	 * shows current list of courses on GUI
	 */
	public void displayList()
	{
		listModel.removeAllElements();
		for(int i = 0;i<courseList.size();i++)
		{
			listModel.addElement(courseList.get(i).getName());
		}
	}
	
	class ClientMgrActionListener implements ActionListener {
		/**
		 * listens for button events.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == viewCourseb) {
				//open course page with student list and assignment list
			}
			else if(e.getSource() == addCourseb) {

			}
			else if(e.getSource() == acDacb) {

			}
		}
	}
	
	class ClientMgrListListener implements ListSelectionListener {
		/**
		 * listens for list selection action. 
		 */
		public void valueChanged(ListSelectionEvent e) {
			int index = courseJList.getSelectedIndex();
			if (index >= 0) {
				String line = (String) listModel.get(index);
				//update text boxes
				
				
			}
		}
	}

}
