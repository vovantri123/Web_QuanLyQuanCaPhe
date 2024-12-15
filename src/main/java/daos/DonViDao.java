package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnection;
import models.DonVi;

public class DonViDao {
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public DonViDao() {
    	
    }
    
    public List<DonVi> getAll()  { 
        String sql = """
        		SELECT *
				FROM DonVi
        		"""; 
        List<DonVi> data = new ArrayList<>(); 

        try {  
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {  
            	DonVi dv = new DonVi(
                    rs.getString("MaDV"),
                    rs.getString("TenDV")
                ); 
                data.add(dv);  
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            DBConnection.close(rs, ps, conn); 
        }  

        return data;  
    }
    
    public DonVi getById(String maDV) {
        String sql = """
    		SELECT *
			FROM DonVi
			WHERE MaDV = ? 
            """;
        DonVi donVi = null;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maDV);
            rs = ps.executeQuery(); 
            if (rs.next()) {
            	donVi = new DonVi(
	    			rs.getString("MaDV"),  
	                rs.getString("TenDV")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return donVi;
    }
    
    public boolean insert(DonVi d) {
        String sql = """
            INSERT INTO DonVi(MaDV, TenDV)
            VALUES (?, ?)
            """;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, d.getMaDV());   
            ps.setString(2, d.getTenDV());   

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(null, ps, conn);
        }
        return false;
    }
 
    public boolean update(DonVi d) {
        String sql = """ 
            UPDATE DonVi
            SET TenDV = ?
            WHERE MaDV = ?
            """;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, d.getTenDV());  
            ps.setString(2, d.getMaDV());  

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(null, ps, conn);
        }
        return false;
    }
 
    public boolean delete(String maDV) {
        String sql = """
            DELETE FROM DonVi
            WHERE MaDV = ?
            """;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maDV);   

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(null, ps, conn);
        }
        return false;
    }
    
    public List<DonVi> searchByName(String tenDV) {
        String sql = """
            SELECT * 
            FROM DonVi
            WHERE TenDV LIKE ?
        """;
        List<DonVi> data = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + tenDV + "%");  
            rs = ps.executeQuery();

            while (rs.next()) {
                DonVi dv = new DonVi(
                    rs.getString("MaDV"),
                    rs.getString("TenDV")
                );
                data.add(dv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }

        return data;
    }

}
