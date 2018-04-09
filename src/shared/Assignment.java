package shared;

import java.io.Serializable;

public class Assignment  implements Serializable{

	private int id;
	private int courseID;
	private String title;
	private String path;
	private boolean active;
	private String timeStamp;
	public Assignment(int id, int courseID, String title, String path, boolean active, String timeStamp) {
		super();
		this.id = id;
		this.courseID = courseID;
		this.title = title;
		this.path = path;
		this.active = active;
		this.timeStamp = timeStamp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}
