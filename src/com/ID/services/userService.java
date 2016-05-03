package com.ID.services;

import java.sql.*;

public class userService {
	
	public String dbDriver = "com.mysql.jdbc.Driver";
	public String dbConnection = "jdbc:mysql://localhost:3306/id";
	public String dbUser = "C27872";
	public String dbPassword = "w@lkom57";
	
	public Connection getDbConnection(){
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			System.out.println("class not found!");
			e.printStackTrace();
		}
		
		Connection connection = null;	
		try {
			connection = DriverManager.getConnection(dbConnection,dbUser,dbPassword);
		} catch (SQLException e) {
			System.out.println("Sql exception in getDbConnection");
			e.printStackTrace();
		}
		
		if (connection != null) {
			System.out.println("Success!");
		} else {
			System.out.println("Failure!");
		}
		
		return connection;
		
	}
	
	public void userPersist(String firstName, String lastName, String emailId,String password){
		
		String sqlQuery = "insert into user(FirstName,LastName,EmailId,password)"
						+	" values('" + firstName + "','" + lastName + "','"	+ emailId + "','" 
						+ password+ "');";
		
		System.out.println(sqlQuery);
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection=	getDbConnection();
			statement=connection.createStatement();
			statement.executeUpdate(sqlQuery);
			
			System.out.println("Record is inserted into USER table!");
			
		} catch (SQLException e) {
			System.out.println("Sql exception in insertLoginDetails");
			e.printStackTrace();
		}
		
		
		
	}

}
