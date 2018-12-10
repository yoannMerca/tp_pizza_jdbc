package config;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connexion {

	public static void main(String[] args) {
		Connection conn = null;

		try {
			conn = Connexion.getConnection();

			System.out.println("Connexion effective !");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// do nothing
			}
		}
	}

	public static Connection getConnection() throws Exception{
		Properties prop = new Properties();
		InputStream input = null;
		String url ="";
		String user="";
		String passwd="";
		try {	
			input = new FileInputStream("src/main/java/config/parmeters.properties");
			prop.load(input);
			Class.forName("com.mysql.jdbc.Driver");
			url = prop.getProperty("url");
			user = prop.getProperty("dbuser");
			passwd = prop.getProperty("dbpassword");
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, user, passwd);
	}
}