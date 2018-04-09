package server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import shared.Assignment;
import shared.Course;
import shared.Student;
import shared.User;

public class DBHelper {
    PreparedStatement stmt;
    Connection connection;
//    ObjectOutputStream out;
//    ObjectInputStream in;
    public String sql;
    public String connectionInfo = "jdbc:mysql://localhost:3306/ensf409",  
		login = "root",
	        password = "shayan1234";
    
    public DBHelper(){
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(connectionInfo, login, password);
		System.out.println("Connected to: " + connectionInfo + "\n");
		createTable();
		fillTables();
//		this.in = in;
//		this.out = out;

	} catch (Exception e) {
		e.printStackTrace();
	}
	
    }
    public String loginCheck(String user, String password) throws IOException, ClassNotFoundException, SQLException{
	    String match = "Match";
	    String query = "select * from user where id=? and password=?";
	    PreparedStatement pst = connection.prepareStatement(query);
	    int id = Integer.parseInt(user);
	    pst.setInt(1, id);
	    pst.setString(2, password);
	    ResultSet rs = pst.executeQuery();
	    if (rs.next()) {
	    	return match;
	    }
	    else {
	    	return "no";
	    }
	}
    
    public boolean is_student(String user) throws SQLException {
    	String query = "select * from user where id=?";
    	PreparedStatement pst = connection.prepareStatement(query);
 	    int id = Integer.parseInt(user);
 	    pst.setInt(1, id);
 	    ResultSet rs = pst.executeQuery();
 	    char type = rs.getString("type").charAt(0);
 	    if (type == 'S') {
			return true;
		}
 	    return false;
    }
    
    public ArrayList<Course> get_course_list(int prof_id) throws SQLException {
    	ArrayList<Course> courselist = new ArrayList<Course>();
    	String query = "select * from course where prof_id=?";
    	PreparedStatement pst = connection.prepareStatement(query);
 	    pst.setInt(1, prof_id);
 	    ResultSet rs = pst.executeQuery();
 	    while (rs.next())
        {
         int id = rs.getInt("id");
         String name = rs.getString("name");
         boolean is_active = rs.getBoolean("active");
         Course course = new Course(id,prof_id,name,is_active);
         courselist.add(course);
        }
 	    return courselist;
    }
    
    public ArrayList<Course> allcourses() throws SQLException {
    	ArrayList<Course> courselist = new ArrayList<Course>();
    	String query = "select * from course";
    	PreparedStatement pst = connection.prepareStatement(query);
 	    ResultSet rs = pst.executeQuery();
 	    while (rs.next())
        {
         int id = rs.getInt("id");
         String name = rs.getString("name");
         int prof_id = rs.getInt("prof_id");
         boolean is_active = rs.getBoolean("active");
         Course course = new Course(id,prof_id,name,is_active);
         courselist.add(course);
        }
 	    return courselist;
    }
    
    public ArrayList<Course> allactivecourses() throws SQLException {
    	ArrayList<Course> courselist = new ArrayList<Course>();
    	String query = "select * from course where active=true";
    	PreparedStatement pst = connection.prepareStatement(query);
 	    ResultSet rs = pst.executeQuery();
 	    while (rs.next())
        {
         int id = rs.getInt("id");
         String name = rs.getString("name");
         int prof_id = rs.getInt("prof_id");
         Course course = new Course(id,prof_id,name,true);
         courselist.add(course);
        }
 	    return courselist;
    }
    
    
    public ArrayList<Student> get_students(int course_id) throws SQLException{
    	ArrayList<Student> studentlist = new ArrayList<Student>();
    	String query = "select * from studentenrollment where course_id=?";
    	PreparedStatement pst = connection.prepareStatement(query);
 	    pst.setInt(1, course_id);
 	    ResultSet rs = pst.executeQuery();
 	    while (rs.next())
        {
         int id = rs.getInt("id");
         String query2 = "select * from user where id=?";
     	 PreparedStatement pst2 = connection.prepareStatement(query2);
  	     pst2.setInt(1, id);
  	     ResultSet rs2 = pst.executeQuery();
  	     String firstName = rs2.getString("firstname");
         String lastName = rs2.getString("lastname");
         Student student = new Student(id,firstName,lastName);
         studentlist.add(student);
        }
 	    return studentlist;
    }
    
    public ArrayList<Assignment> get_assignment(int course_id) throws SQLException{
    	ArrayList<Assignment> assignmentlist = new ArrayList<Assignment>();
    	String query = "select * from assignment where course_id=?";
    	PreparedStatement pst = connection.prepareStatement(query);
 	    pst.setInt(1, course_id);
 	    ResultSet rs = pst.executeQuery();
 	    while (rs.next())
        {
         int id = rs.getInt("id");
  	     String title = rs.getString("title");
         String path = rs.getString("path");
         boolean is_active = rs.getBoolean("active");
         String date = rs.getString("date");
         Assignment a = new Assignment(id, course_id, title, path, is_active, date);
         assignmentlist.add(a);
        }
 	    return assignmentlist;
    }
    
    
    public void add_course(String name, int prof_id, boolean is_active) throws SQLException {
    	String query = " insert into course (prof_id, name, active)"
    	        + " values (?, ?, ?)";
    	PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setInt(1, prof_id);
        preparedStmt.setString (2, name);
        preparedStmt.setBoolean(3, is_active);
        preparedStmt.execute();
        //auto_increment the course id
    }
    
    
    public void shift_activation_course(int course_id) throws SQLException {
    	String query2 = "select active from course where id = ?";
    	PreparedStatement preparedStmt2 = connection.prepareStatement(query2);
        preparedStmt2.setInt(1, course_id);
 	    ResultSet rs = preparedStmt2.executeQuery();
 	    rs.next();
 	    String query = "update course set active = ? where id = ?";
 	    PreparedStatement preparedStmt = connection.prepareStatement(query);
 	    preparedStmt.setInt(2, course_id);
 	    if (rs.getBoolean("active")) {
 	 	    preparedStmt.setBoolean(1, false);
 	    }
 	    else {
 	 	    preparedStmt.setBoolean(1, true);
 	    }
        
        preparedStmt.executeUpdate();
    }
    
    public int get_course_id(String name) throws SQLException {
    	String query = "select id from course where name = ?";
    	PreparedStatement preparedStmt = connection.prepareStatement(query);
    	preparedStmt.setString(1, name);
    	ResultSet rs = preparedStmt.executeQuery();
    	int id = 0;
    	while (rs.next()) {
    		id = rs.getInt("id");
    	}
    	return id;
    }
    
    
    public void activate_assignment(int assign_id) throws SQLException {
        String query = "update assignment set active = ? where course_id = ?";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setBoolean(1, true);
        preparedStmt.setInt(2, assign_id);
        preparedStmt.executeUpdate();
    }
    
    public void deactivate_assignment(int assign_id) throws SQLException {
        String query = "update assignment set active = ? where course_id = ?";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setBoolean(1, false);
        preparedStmt.setInt(2, assign_id);
        preparedStmt.executeUpdate();
    }
    
    public ArrayList<Student> get_all_students() throws SQLException{
    	ArrayList<Student> allstudents = new ArrayList<Student>();
    	String query = "select * from user where type=?";
    	PreparedStatement pst = connection.prepareStatement(query);
 	    pst.setString(1, "S");
 	    ResultSet rs = pst.executeQuery();
 	    while (rs.next())
        {
         int id = rs.getInt("id");
  	     String firstName = rs.getString("firstname");
         String lastName = rs.getString("lastname");
         Student student = new Student(id,firstName,lastName);
         allstudents.add(student);
        }
 	    return allstudents;
    }
    
    public ArrayList<Student> search_student_last_name(String q) throws SQLException{
    	ArrayList<Student> search_lastname = new ArrayList<Student>();
    	String query = "select * from user where type=?, lastname like' " + q + " '% ";
    	PreparedStatement pst = connection.prepareStatement(query);
 	    pst.setString(1, "S");
 	    ResultSet rs = pst.executeQuery();
 	    while (rs.next())
        {
         int id = rs.getInt("id");
  	     String firstName = rs.getString("firstname");
         String lastName = rs.getString("lastname");
         Student student = new Student(id,firstName,lastName);
         search_lastname.add(student);
        }
 	    return search_lastname;
    }
    
    public ArrayList<Student> search_student_id(int q) throws SQLException{
    	ArrayList<Student> search_id = new ArrayList<Student>();
    	String query = "select * from user where type=?, id like'% " + q + " '% ";
    	PreparedStatement pst = connection.prepareStatement(query);
 	    pst.setString(1, "S");
 	    ResultSet rs = pst.executeQuery();
 	    while (rs.next())
        {
         int id = rs.getInt("id");
  	     String firstName = rs.getString("firstname");
         String lastName = rs.getString("lastname");
         Student student = new Student(id,firstName,lastName);
         search_id.add(student);
        }
 	    return search_id;
    }
    
    public void add_assignment(int course_id, String title,String path, boolean is_active,String due) throws SQLException {
    	String query = " insert into assignment (course_id, title, path, active, due_date)"
    	        + " values (?, ?, ?, ?, ?)";
    	PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setInt(1, course_id);
        preparedStmt.setString (2, title);
        preparedStmt.setString (3, path);
        preparedStmt.setBoolean(4, is_active);
        preparedStmt.setString (5, due);
        preparedStmt.execute();
      //auto_increment the course id
    }
    
    public void createDB() {
		try {
			PreparedStatement statement = connection.prepareStatement("CREATE DATABASE d2l");
			statement.execute();
			System.out.println("Created Database d2l");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public void fillTables() throws SQLException {

    	String query = "insert ignore into user(id , password, email, firstname, lastname, type) values(2,\"222\",\"zamani@yahoo.com\",\"kazi\", \"ashfaq\",\"S\")";
    	String q2 = "insert ignore into user(id , password, email, firstname, lastname, type) values(3,\"333\",\"zamani@yahoo.com\",\"kevin\", \"wang\",\"S\")";
    	String q3 = "insert ignore into user(id , password, email, firstname, lastname, type) values(4,\"444\",\"zamani@yahoo.com\",\"mohammad\", \"moshirpour\",\"P\")";
    	String q4 = "insert ignore into course(id , prof_id, name, active) values(1,4,\"ensf409\",true)";
    	String q5 = "insert ignore into course(id , prof_id, name, active) values(2,4,\"seng401\",true)";
    	PreparedStatement statement = connection.prepareStatement(query);
    	PreparedStatement statement2 = connection.prepareStatement(q2);
    	PreparedStatement statement3 = connection.prepareStatement(q3);
    	PreparedStatement statement4 = connection.prepareStatement(q4);
    	PreparedStatement statement5 = connection.prepareStatement(q5);
    	statement.execute();
		statement2.execute();
		statement3.execute();
		statement4.execute();
		statement5.execute();
    }
	/**
	 * Creating tables inside the database
	 */
	public void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS ASSIGNMENT (" + "ID INT(8) NOT NULL AUTO_INCREMENT, "
				+ "COURSE_ID INT(8) NOT NULL, " + "TITLE VARCHAR(50) NOT NULL, "
				+ "PATH VARCHAR(100) NOT NULL, " + "ACTIVE BIT(1) NOT NULL, " + "DUE_DATE CHAR(16) NOT NULL, "
				+ "PRIMARY KEY ( id ))";
		
		String sql1 = "CREATE TABLE IF NOT EXISTS COURSE (" + "ID INT(8) NOT NULL AUTO_INCREMENT,"
				+ "PROF_ID INT(8) NOT NULL, " + "NAME VARCHAR(50) NOT NULL, "
				+ "ACTIVE BIT(1) NOT NULL, " + "PRIMARY KEY ( id ))";
		
		String sql2 = "CREATE TABLE IF NOT EXISTS USER (" + "ID INT(8) NOT NULL AUTO_INCREMENT,"
				+ "PASSWORD VARCHAR(20) NOT NULL, " + "EMAIL VARCHAR(50) NOT NULL, "
				+ "FIRSTNAME VARCHAR(20) NOT NULL, " + "LASTNAME VARCHAR(50) NOT NULL, "
				+ "TYPE CHAR(1) NOT NULL, "+ "PRIMARY KEY ( id ))";
		
		String sql3 = "CREATE TABLE IF NOT EXISTS SUBMISSION (" + "ID INT(8) NOT NULL AUTO_INCREMENT,"
				+ "ASSIGN_ID INT(8) NOT NULL, " + "STUDENT_ID INT(8) NOT NULL, "
				+ "PATH VARCHAR(100) NOT NULL, " + "TITLE VARCHAR(50) NOT NULL, "
				+ "SUBMISSION_GRADE INT(3) NOT NULL, " + "COMMENTS VARCHAR(140) NOT NULL, "
				+ "TIMESTAMP CHAR(16) NOT NULL, "+ "PRIMARY KEY ( id ))";
		
		String sql4 = "CREATE TABLE IF NOT EXISTS STUDENTENROLLMENT (" + "ID INT(8) NOT NULL AUTO_INCREMENT,"
				+ "STUDENT_ID INT(8) NOT NULL, " + "COURSE_ID INT(8) NOT NULL, "
				+ "PRIMARY KEY ( id ))";
		
		String sql5 = "CREATE TABLE IF NOT EXISTS GRADE (" + "ID INT(8) NOT NULL AUTO_INCREMENT,"
				+ "ASSIGN_ID INT(8) NOT NULL, " + "STUDENT_ID INT(8) NOT NULL, "
				+ "COURSE_ID INT(8) NOT NULL, " + "SUBMISSION_GRADE INT(3) NOT NULL, " 
				+ "PRIMARY KEY ( id ))";
		
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			PreparedStatement statement2 = connection.prepareStatement(sql2);
			PreparedStatement statement3 = connection.prepareStatement(sql3);
			PreparedStatement statement4 = connection.prepareStatement(sql4);
			PreparedStatement statement5 = connection.prepareStatement(sql5);
			statement.execute();
			statement1.execute();
			statement2.execute();
			statement3.execute();
			statement4.execute();
			statement5.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
