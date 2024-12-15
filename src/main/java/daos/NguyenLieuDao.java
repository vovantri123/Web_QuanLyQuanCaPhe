package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnection;
import models.NguyenLieu;

public class NguyenLieuDao {
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public NguyenLieuDao() {
    	
    }
    
    public List<NguyenLieu> getAll()  { 
        String sql = """
        		SELECT nl.*, dv.TenDV
				FROM NguyenLieu nl
				INNER JOIN DonVi dv ON nl.MaDV = dv.MaDV 
        		"""; 
        List<NguyenLieu> data = new ArrayList<>(); 

        try { 
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {  
                NguyenLieu nl = new NguyenLieu(
                    rs.getString("MaNL"),  
                    rs.getString("TenNL"), 
                    rs.getInt("SoLuongTonKho"), 
                    rs.getString("MaDV"),
                    rs.getString("TenDV")
                ); 
                data.add(nl);  
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            DBConnection.close(rs, ps, conn); 
        }  

        return data;  
    }
    
    public NguyenLieu getById(String maNL) {
        String sql = """
    		SELECT nl.*, dv.TenDV
			FROM NguyenLieu nl
			INNER JOIN DonVi dv ON nl.MaDV = dv.MaDV
			WHERE nl.MaNL = ? 
            """;
        NguyenLieu nguyenLieu = null;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maNL);
            rs = ps.executeQuery(); 
            if (rs.next()) {
            	nguyenLieu = new NguyenLieu(
        			rs.getString("MaNL"),  
                    rs.getString("TenNL"), 
                    rs.getInt("SoLuongTonKho"), 
                    rs.getString("MaDV"),
                    rs.getString("TenDV") 
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return nguyenLieu;
    }
    
    public boolean insert(NguyenLieu nl) {
        String sql = """
            INSERT INTO NguyenLieu (MaNL, TenNL, SoLuongTonKho, MaDV)
            VALUES (?, ?, ?, ?)
        """;
        
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nl.getMaNL());
            ps.setString(2, nl.getTenNL());
            ps.setInt(3, nl.getSoLuongTonKho());
            ps.setString(4, nl.getMaDV());
            
            return ps.executeUpdate() > 0;  
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false; 
    }
    
    public boolean update(NguyenLieu nl) {
        String sql = """
            UPDATE NguyenLieu
            SET TenNL = ?, SoLuongTonKho = ?, MaDV = ?
            WHERE MaNL = ?
        """;
        
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nl.getTenNL());
            ps.setInt(2, nl.getSoLuongTonKho());
            ps.setString(3, nl.getMaDV());
            ps.setString(4, nl.getMaNL());
            
            return ps.executeUpdate() > 0;   
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;  
    }
    
    public boolean delete(String maNL) {
        String sql = """
            DELETE FROM NguyenLieu
            WHERE MaNL = ?
        """;
        
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maNL);
            
            return ps.executeUpdate() > 0;  
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;  
    }
    
    public List<NguyenLieu> searchByName(String tenNL) {
        String sql = """
            SELECT nl.*, dv.TenDV
            FROM NguyenLieu nl
            INNER JOIN DonVi dv ON nl.MaDV = dv.MaDV
            WHERE nl.TenNL LIKE ?
            """;
        List<NguyenLieu> data = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + tenNL + "%");  
            rs = ps.executeQuery();

            while (rs.next()) {
                NguyenLieu nl = new NguyenLieu(
                    rs.getString("MaNL"),
                    rs.getString("TenNL"),
                    rs.getInt("SoLuongTonKho"),
                    rs.getString("MaDV"),
                    rs.getString("TenDV")
                );
                data.add(nl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }

        return data;
    }

    
    


    
    
    
    
}
