package shared;

import java.io.Serializable;

public class Grade  implements Serializable{

	private int studentID;
	private int grade;
	private String studentName;
	private String assignmentName;
	
	public Grade(int studentID, int grade, String studentName, String assignmentName) {
		super();
		this.studentID = studentID;
		this.grade = grade;
		this.studentName = studentName;
		this.assignmentName = assignmentName;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getAssignmentName() {
		return assignmentName;
	}
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

}
