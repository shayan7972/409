package server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Server  {

    	ObjectOutputStream out;
	Socket aSocket;
	ServerSocket serverSocket;
	ObjectInputStream in;
	private ExecutorService pool;
	DBHelper database;
	
	public Server() throws IOException{
	    try{
	    serverSocket = new ServerSocket(9099);
	    pool = Executors.newCachedThreadPool();
	    }
	    catch(IOException e){
		e.printStackTrace();
	    }
	   
	  
	}
	
	public void runServer() throws ClassNotFoundException{
	    try{
	    while(true){
	    aSocket = serverSocket.accept();
	    System.out.println("Server is running...Connection accepted");
	    out = new ObjectOutputStream(aSocket.getOutputStream());
	    out.flush();
	    in = new ObjectInputStream(aSocket.getInputStream());
	   
	   
	    Worker worker = new Worker(in,out);
	    pool.execute(worker);
	    }
	    }
	    catch(IOException e){
		    e.printStackTrace();
		    pool.shutdown();  //shuting down thread pool
//		    try{
//			
//			//Closing connections
//			in.close();
//			out.close();
//			aSocket.close();
//		    }
//		    catch(IOException a){
//			a.printStackTrace();
//		    }
		}
	}
    public static void main(String[] args) throws IOException, ClassNotFoundException {
	// TODO Auto-generated method stub
	Server server = new Server();
	server.runServer();
    }

}
