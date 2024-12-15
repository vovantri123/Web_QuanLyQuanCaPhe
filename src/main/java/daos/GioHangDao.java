package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnection;
import models.GioHang;
import models.KhuVuc;
import models.GioHang;

public class GioHangDao {
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
	public List<GioHang> getById(String maND)
	{
		String sql = """
		        SELECT gh.MaND, gh.MaSp, gh.SoLuongMua, sp.TenSP, sp.GiaSP 
		        FROM GioHang gh
		        JOIN SanPham sp ON gh.MaSP = sp.MaSP
		        WHERE MaND = ?
		        """;
		List<GioHang> data = new ArrayList<>(); 
		
		GioHang gh = null;
        try { 
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maND);
            rs = ps.executeQuery();
            
            while (rs.next()) { 
                // Khởi tạo đối tượng Slide từ dữ liệu trong ResultSet
            	gh = new GioHang(
                    rs.getString("MaND"),
                    rs.getString("MaSP"),
                    rs.getInt("SoLuongMua"),
                    rs.getString("TenSP"),
                    rs.getFloat("GiaSP")
                );    
            	data.add(gh);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            DBConnection.close(rs, ps, conn); // Đảm bảo đóng kết nối
        }  

        return data;  
	}
	
	public void removeItem(String maND, String maSP) {
        String sql = "DELETE FROM GioHang WHERE maND = ? AND maSP = ?";
        
        try {
        	conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maND);
            ps.setString(2, maSP);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn); // Đảm bảo đóng kết nối
        }  
    }
	
	public boolean insert(GioHang gh) {
        String sql = """
            INSERT INTO GioHang
            (MaND, MaSP, SoLuongMua)
            VALUES (?, ?, ?)
            """;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, gh.getMaND());
            ps.setString(2, gh.getMaSP());
            ps.setInt(3, gh.getSoLuong());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }
	
	public boolean updateSoLuongSanPham(String maSP, int soLuongThem) {
	    String sql = """
	            UPDATE GioHang
	            SET SoLuongMua = SoLuongMua + ?
	            WHERE MaSP = ?
	            """;
	    try {
	        conn = DBConnection.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, soLuongThem);
	        ps.setString(2, maSP);
	        return ps.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnection.close(rs, ps, conn);
	    }
	    return false;
	}
}
