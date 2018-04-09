package shared;

import java.io.Serializable;

public class Submission  implements Serializable{

	private int id;
	private int assignemntID;
	private int studentID;
	private String path;
	private int grade;
	private String comment;
	private String title;
	private String timeStamp;
	
	public Submission(int id, int assignemntID, int studentID, String path, int grade, String comment, String title,
			String timeStamp) {
		super();
		this.id = id;
		this.assignemntID = assignemntID;
		this.studentID = studentID;
		this.path = path;
		this.grade = grade;
		this.comment = comment;
		this.title = title;
		this.timeStamp = timeStamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAssignemntID() {
		return assignemntID;
	}

	public void setAssignemntID(int assignemntID) {
		this.assignemntID = assignemntID;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}


}
