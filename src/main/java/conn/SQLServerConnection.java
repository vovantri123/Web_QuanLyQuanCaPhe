package conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerConnection {
	public static Connection initializeDatabase()
	{
		String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	    
	    String dbURL = "jdbc:sqlserver://localhost:1433";
	    String dbName = "WebBanCaPhe"; //Thay đổi
//	    String connectionURL = dbURL + ";databaseName=" + dbName + ";encrypt=false;";
	    String connectionURL = dbURL + ";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true";
	    
	    String dbUsername = "sa";  
	    String dbPassword = "1234567890";
	    
	    Connection conn = null; //Đối tượng kết nối CSDL
	    try { 
	        Class.forName(dbDriver);  //Tải JDBC Driver for SQL Server vào bộ nhớ  
	         
	        conn = DriverManager.getConnection(connectionURL, dbUsername, dbPassword); // Establish the connection
	        if (conn != null) {
	            System.out.println("Kết nối thành công với cơ sở dữ liệu.");
	        } else {
	            System.out.println("Kết nối thất bại.");
	        }
	    } catch (Exception ex) {
	    	ex.printStackTrace(); // In lỗi ra Console
	    }
	    
		return conn;
	}
}
