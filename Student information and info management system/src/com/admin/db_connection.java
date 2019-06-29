package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class db_connection {
	
	public Connection con=null;
	public Statement sta=null;
	public void Connection() {
	try{
	String username="root",password="01821143325",port="3306",server="localhost",db_file="student_result";
	String url="jdbc:mysql://"+server+":"+port+"/"+db_file;
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	con=DriverManager.getConnection(url,username,password); 
	sta=con.createStatement();
	System.out.println ("Database connection established");
	}
	catch(Exception exp){
	System.out.println(exp);
	}
	}

}
