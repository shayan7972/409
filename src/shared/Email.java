package shared;

import java.io.Serializable;
import java.util.ArrayList;

public class Email  implements Serializable{

	private String from;
	private ArrayList<String> to;
	private String subject;
	private String content;
	
	public Email(String from, ArrayList<String> to, String subject, String content) {
		super();
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.content = content;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public ArrayList<String> getTo() {
		return to;
	}
	public void setTo(ArrayList<String> to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

}
