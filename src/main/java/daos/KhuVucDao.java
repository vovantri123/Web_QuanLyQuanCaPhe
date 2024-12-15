package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnection;
import models.DonHang;
import models.KhuVuc;

public class KhuVucDao {
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<KhuVuc> getAll()  { 
        String sql = """
        		SELECT * 
    			FROM KhuVuc
        		"""; 
        List<KhuVuc> data = new ArrayList<>(); 

        try { 
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {  
            	KhuVuc kv = new KhuVuc(
                    rs.getString("MaKV"),  
                    rs.getString("TenKV"), 
                    rs.getFloat("PhiVanChuyen")
                ); 
                data.add(kv);  
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            DBConnection.close(rs, ps, conn); 
        }  

        return data;  
    }
    
    public KhuVuc getById(String maKV) {
        String sql = """
    		SELECT * 
			FROM KhuVuc
			WHERE MaKV = ? 
            """;
        KhuVuc khuVuc = null;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maKV);
            rs = ps.executeQuery(); 
            if (rs.next()) {
            	khuVuc = new KhuVuc(
	    			rs.getString("MaKV"),  
	                rs.getString("TenKV"), 
	                rs.getFloat("PhiVanChuyen")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return khuVuc;
    }
    
    public boolean insert(KhuVuc k) {
        String sql = """
            INSERT INTO KhuVuc(MaKV, TenKV, PhiVanChuyen)
            VALUES (?, ?, ?)
            """;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, k.getMaKV());   
            ps.setString(2, k.getTenKV());   
            ps.setFloat(3, k.getPhiVanChuyen());   

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(null, ps, conn);
        }
        return false;
    }
 
    public boolean update(KhuVuc k) {
        String sql = """ 
            UPDATE KhuVuc
            SET TenKV = ?, PhiVanChuyen = ?
            WHERE MaKV = ?
            """;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, k.getTenKV());  
            ps.setFloat(2, k.getPhiVanChuyen());  
            ps.setString(3, k.getMaKV());  

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(null, ps, conn);
        }
        return false;
    }
 
    public boolean delete(String maKV) {
        String sql = """
            DELETE FROM KhuVuc
            WHERE MaKV = ?
            """;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maKV);  

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(null, ps, conn);
        }
        return false;
    }
    
    public List<KhuVuc> searchByName(String tenKV) {
        String sql = """
            SELECT * 
            FROM KhuVuc
            WHERE TenKV LIKE ?
        """;
        List<KhuVuc> data = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + tenKV + "%"); 
            rs = ps.executeQuery();

            while (rs.next()) {
                KhuVuc kv = new KhuVuc(
                    rs.getString("MaKV"),
                    rs.getString("TenKV"),
                    rs.getFloat("PhiVanChuyen")
                );
                data.add(kv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }

        return data;
    }
}
