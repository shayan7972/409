package client;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JRadioButton;

import shared.Assignment;
import shared.Student;

import java.awt.Font;
import java.sql.SQLException;

public class ProfessorGUI extends JFrame{

	private JFrame frame;
	ArrayList<Student> students;
	
	private JLabel studentListl;
	private JLabel assignmentListl;
	
	private JRadioButton studentId;
	private JRadioButton lastName;
	
	private JButton searchb;
	
	private JButton addAssignmentb;
	
	private JButton acDacAssignmentb;
	
	private JButton removeAssignmentb;

	private JTextField searchField;
	
	JList<String> studentJList;
	DefaultListModel<String> studentListModel;
	private JScrollPane studentListp;
	
	JList<String> assignmentJList;
	DefaultListModel<String> assignmentListModel;
	private JScrollPane assignmentListp;
	
	private ButtonGroup searchTypebg;
	ArrayList<Student> studentList;
	ArrayList<Assignment> assignmentList;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ProfessorGUI window = new ProfessorGUI();
		window.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public ProfessorGUI()  {
		super("D2L");
		setBounds(100, 100, 671, 435);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, "name_7909366916386");

		JInternalFrame internalFrame = new JInternalFrame("Students");		
		JInternalFrame internalFrame_2 = new JInternalFrame("Assignments");
		
		tabbedPane.addTab("Students", null, internalFrame, null);
		tabbedPane.addTab("Assignments", null, internalFrame_2, null);
		
		internalFrame.getContentPane().setLayout(null);
		internalFrame_2.getContentPane().setLayout(null);
		
		studentListModel = new DefaultListModel<String>();
		studentJList = new JList<String>(studentListModel);
		studentListp = new JScrollPane(studentJList);
		internalFrame.getContentPane().add(studentListp);
		studentListp.setBounds(10, 49, 300, 265);		

		studentListl = new JLabel("Students List");
		studentListl.setFont(new Font("Tahoma", Font.BOLD, 13));
		studentListl.setBounds(10, 24, 158, 14);
		internalFrame.getContentPane().add(studentListl);

		lastName = new JRadioButton("Last name");
		lastName.setBounds(406, 21, 109, 23);
		internalFrame.getContentPane().add(lastName);

		studentId = new JRadioButton("Student Id");
		studentId.setBounds(406, 49, 109, 23);
		internalFrame.getContentPane().add(studentId);
		
		searchTypebg = new ButtonGroup();
		searchTypebg.add(studentId);
		searchTypebg.add(lastName);
		studentId.setSelected(true);
		
		searchb = new JButton("search");
		searchb.setBounds(420, 130, 90, 23);
		internalFrame.getContentPane().add(searchb);
		

		JLabel lblNewLabel_1 = new JLabel("Enter the search parameter");
		lblNewLabel_1.setBounds(406, 79, 145, 14);
		internalFrame.getContentPane().add(lblNewLabel_1);

		searchField = new JTextField();
		searchField.setBounds(406, 104, 125, 20);
		internalFrame.getContentPane().add(searchField);
		searchField.setColumns(10);
		tabbedPane.setEnabledAt(0, true);
		
		
		assignmentListModel = new DefaultListModel<String>();
		assignmentJList = new JList<String>(assignmentListModel);
		assignmentListp = new JScrollPane(assignmentJList);
		internalFrame_2.getContentPane().add(assignmentListp);
		assignmentListp.setBounds(10, 49, 300, 265);
		
		assignmentListl = new JLabel("Assignment List");
		assignmentListl.setFont(new Font("Tahoma", Font.BOLD, 13));
		assignmentListl.setBounds(10, 24, 158, 14);
		internalFrame_2.getContentPane().add(assignmentListl);
		
		addAssignmentb = new JButton("add assignment");;
		
		acDacAssignmentb = new JButton("activate/deactivate");;
		
		removeAssignmentb = new JButton("search");;
		
		internalFrame_2.setVisible(true);
		internalFrame.setVisible(true);

		studentListModel.addElement("1");
		studentListModel.addElement("2");
		studentListModel.addElement("3");
				
	}
	
	
//	public void displayList() throws SQLException
//	{
//		studentListModel.removeAllElements();
//		studentList = db.get_students();
//		
//		for(int i = 0;i<courseList.size();i++)
//		{
//			listModel.addElement(courseList.get(i).getName());
//		}
//	}

	
}