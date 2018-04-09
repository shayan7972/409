package shared;

import java.io.Serializable;

public class StudentEnrollment  implements Serializable{

	private int id;
	private int studentID;
	private int courseID;
	private boolean enrolling;
	public StudentEnrollment(int id, int studentID, int courseID, boolean enrolling) {
		super();
		this.id = id;
		this.studentID = studentID;
		this.courseID = courseID;
		this.enrolling = enrolling;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public boolean isEnrolling() {
		return enrolling;
	}
	public void setEnrolling(boolean enrolling) {
		this.enrolling = enrolling;
	}



}
