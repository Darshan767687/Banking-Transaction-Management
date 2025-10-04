package com.saven.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_factory {
	
	static Connection con=null;
	static String url="jdbc:mysql://localhost:3306/savendb";
	static String un="root";
	static String pass="ROOT7";
	
	static public Connection requestConnection() throws SQLException, ClassNotFoundException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,un,pass);
		return con;
	}

	
	

}
