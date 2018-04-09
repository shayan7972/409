package shared;

import java.io.Serializable;

public class Professor extends User implements Serializable {

	public Professor(int id,String firstName,String lastName) {
		super(id,firstName,lastName);
	}

}
