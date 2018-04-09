package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import shared.Professor;

public class Client {
	private ObjectOutputStream print;
	private Socket socket;
	private ObjectInputStream socketIn;
	LoginGUI login;

	public Client(String serverName, int portNumber) throws UnknownHostException, IOException {
		socket = new Socket(serverName, portNumber);
		print = new ObjectOutputStream(socket.getOutputStream());
		print.flush();
		socketIn = new ObjectInputStream(socket.getInputStream());
		

	}

	public void checkLogin(String user, String pass) throws IOException, ClassNotFoundException, SQLException {

		String response = null;

		print.writeObject(user);
		print.writeObject(pass);

		response = (String) socketIn.readObject();
		
		//GET A PROFESSOR OBJECT FROM SERVER
		Professor profUser = new Professor(0,null,null);
		
		if (response.equals("Match")) {
			JOptionPane.showMessageDialog(null, "Match");
			login.dispose();
			startProfGUI(profUser);
			
		} else {
			JOptionPane.showMessageDialog(null, "Invalid login information");
		}
		
	}
	
	public void startProfGUI(Professor profUser) throws SQLException
	{
		ProfCourseGUI newProfCourseGUI = new ProfCourseGUI(profUser);
		newProfCourseGUI.pack();
		newProfCourseGUI.setVisible(true);
	}

	public void communicate() throws UnknownHostException, IOException {
		login = new LoginGUI(this);
		login.pack();
		login.setVisible(true);

	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Client client = new Client("localhost", 9099);
		client.communicate();

	}

}