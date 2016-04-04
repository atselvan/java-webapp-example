package servicesDb;

import java.sql.*;

public class loginDb {
	
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
	
	public void insertLoginDetails(String username,String password){
		
		String loginQuery = "insert into user(username,password)"
						+	" values('"	+ username + "','" 
						+ password+ "');";
		
		System.out.println(loginQuery);
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection=	getDbConnection();
			statement=connection.createStatement();
			statement.executeUpdate(loginQuery);
			
			System.out.println("Record is inserted into USER table!");
			
		} catch (SQLException e) {
			System.out.println("Sql exception in insertLoginDetails");
			e.printStackTrace();
		}
		
		
		
	}

}
