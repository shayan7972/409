package shared;

import java.io.Serializable;

public abstract class User implements Serializable{

	private int id;
	private String firstName;
	private String lastName;
	
	public User(int newId, String newFirstName, String newLastName) {
		id = newId;
		firstName = newFirstName;
		lastName = newLastName;
	}
	
	public void setID(int newID)
	{
		id = newID;
	}
	public void setFirstName( String newFirstName)
	{
		firstName = newFirstName;
	}
	public void setLastName(String newLastName)
	{
		lastName = newLastName;
	}
	
	public int getID()
	{
		return id;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
}
