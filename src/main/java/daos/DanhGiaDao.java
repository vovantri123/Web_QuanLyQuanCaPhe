package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnection;
import models.DanhGia;
import models.NguoiDung;

public class DanhGiaDao {
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public DanhGiaDao() {}
    
    public List<DanhGia> getAllByIdSP(String idSP)  { 
        String sql = """
        		SELECT DanhGia.MaND, NguoiDung.TenND, 
        		NguoiDung.AnhND, DanhGia.MaSP, 
        		DanhGia.SoSao, DanhGia.NhanXet 
        		FROM DanhGia INNER JOIN 
        		NguoiDung ON DanhGia.MaND = NguoiDung.MaND 
        		WHERE MaSP = ?
        		"""; 
        List<DanhGia> data = new ArrayList<>(); 

        try { 
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, idSP);
            rs = ps.executeQuery();
            
            while (rs.next()) {  
            	DanhGia dg = new DanhGia(
            			rs.getString("MaND"),
            			rs.getString("TenND"),
            			rs.getString("AnhND"),
            			rs.getString("MaSP"),
            			rs.getInt("SoSao"),
            			rs.getString("NhanXet"));
                data.add(dg);  
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            DBConnection.close(rs, ps, conn); 
        }  

        return data;  
    }
    
    public boolean insert(DanhGia dg) {
        String sql = """
            INSERT INTO DanhGia(MaND, MaSP, SoSao, NhanXet)
            VALUES (?, ?, ?, ?)
        """;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, dg.getMaND());
            ps.setString(2, dg.getMaSP());
            ps.setInt(3, dg.getSoSao());
            ps.setString(4, dg.getNhanXet());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }
    
    public boolean update(DanhGia dg) {
        String sql = """
            UPDATE DanhGia
            SET NhanXet = ?
            WHERE MaND = ?
        """;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, dg.getNhanXet());
            ps.setString(2, dg.getMaND());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }
    
    public boolean delete(String maND) {
        String sql = """
            DELETE FROM DanhGia WHERE MaND = ?
        """;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maND);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }
    
}
