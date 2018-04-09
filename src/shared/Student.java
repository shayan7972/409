package shared;

import java.io.Serializable;

public class Student extends User implements Serializable{

	public Student(int id,String firstName,String lastName) {
		super(id,firstName,lastName);
	}

}
