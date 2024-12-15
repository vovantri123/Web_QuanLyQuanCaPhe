package conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {    
	public static Connection getConnection() {
		return SQLServerConnection.initializeDatabase(); 
	} 
	
	public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
		closeResultSet(rs);
		closePreparedStatement(ps);
		closeConnection(conn);
	}
	
	
	
	
	public static void closeConnection(Connection conn) {
	    try {
	        if (conn != null) {
	        	conn.close();
	        }
	    } catch (SQLException e) {
	        System.out.println(e);
	    }
	}
	
	public static void closePreparedStatement(PreparedStatement ps) {
	    try {
	        if (ps != null) {
	            ps.close();
	        }
	    } catch (SQLException e) {
	        System.out.println(e);
	    }
	} 
	
	public static void closeResultSet(ResultSet rs) {
	    try {
	        if (rs != null) {
	            rs.close();
	        }
	    } catch (SQLException e) {
	        System.out.println(e);
	    }
	}

}
