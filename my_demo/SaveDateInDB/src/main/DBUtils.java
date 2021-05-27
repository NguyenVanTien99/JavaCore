package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {
	private static DBUtils instance;
	private Connection connection;
	
	private DBUtils() {
		Properties properties = new Properties();
		
		try {
			properties.load(DBUtils.class.getResourceAsStream("/dbConfig.properties"));
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String userName = properties.getProperty("userName");
			String password = properties.getProperty("password");
			
			
			Class.forName(driver);
			
			connection = DriverManager.getConnection(url,userName,password);
			
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public static DBUtils getInstance() throws SQLException {
		if(instance == null || instance.getConnection().isClosed()) {
			instance = new DBUtils();
		}
		return instance;
	}
	
	 public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
}
