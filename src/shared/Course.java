package shared;

import java.io.Serializable;

public class Course  implements Serializable{

	private int id;
	private int profID;
	private String name;
	private boolean active;
	
	public Course(int id, int profID,String name,boolean active) {
		this.id = id;
		this.profID = profID;
		this.name = name;
		this.active = active;
	}
	
	public void setID(int id)
	{
		this.id = id;
	}
	public void setProfID(int profID)
	{
		this.profID = profID;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setActive(boolean active)
	{
		this.active = active;
	}
	public int getID()
	{
		return id;
	}
	public int getProfID()
	{
		return profID;
	}
	public String getName()
	{
		return name;
	}
	public boolean getActive()
	{
		return active;
	}

}
