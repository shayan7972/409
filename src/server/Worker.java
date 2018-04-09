package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLException;

public class Worker implements Runnable{
    ObjectInputStream in;
    ObjectOutputStream out;
    DBHelper db;
    String user;
    String pass;
    String res;
    
    Worker(ObjectInputStream in, ObjectOutputStream out){
	this.in = in;
	this.out = out;
	db = new DBHelper();
	user = null;
	pass = null;
	res = null;
    }
  
    public void readFromSocket() throws ClassNotFoundException, IOException{
	try{
	user = (String) in.readObject();
	pass = (String) in.readObject();
	}
	catch(ClassNotFoundException e){
	    e.printStackTrace();
	}
	catch(IOException e){
	    e.printStackTrace();
	}
    }
    @Override
    public void run() {
	// TODO Auto-generated method stub
	try {
	    try {
		readFromSocket();
		try {
			res = db.loginCheck(user,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.writeObject(res);
	    } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
