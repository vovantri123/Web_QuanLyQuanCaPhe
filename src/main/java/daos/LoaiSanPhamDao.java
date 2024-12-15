package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnection;
import models.LoaiSanPham; 

public class LoaiSanPhamDao {
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
	public LoaiSanPhamDao() {
		// TODO Auto-generated constructor stub
	}
	public List<LoaiSanPham> getAll()
	{ 
		String sql = """
				SELECT * 
				FROM LoaiSanPham
				""";  
        List<LoaiSanPham> data = new ArrayList<>(); 

        try { 
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
             
            while (rs.next()) {  
            	LoaiSanPham lsp = new LoaiSanPham(
                    rs.getString("MaLoaiSP"), 
                    rs.getString("TenLoaiSP"), 
                    rs.getString("HinhLoaiSP") 
                );
                data.add(lsp);    
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            DBConnection.close(rs, ps, conn); // Đảm bảo đóng kết nối
        }  

        return data;  
	}
	 
	public LoaiSanPham getById(String maLoaiSP) {
        String sql = """
    		SELECT * 
			FROM LoaiSanPham
			WHERE MaLoaiSP = ? 
            """;
        LoaiSanPham loaiSanPham = null;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maLoaiSP);
            rs = ps.executeQuery(); 
            if (rs.next()) {
            	loaiSanPham = new LoaiSanPham(
        			rs.getString("MaLoaiSP"), 
                    rs.getString("TenLoaiSP"), 
                    rs.getString("HinhLoaiSP") 
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return loaiSanPham;
    }
	
	public boolean insert(LoaiSanPham loaiSanPham) {
	    String sql = """
	        INSERT INTO LoaiSanPham(MaLoaiSP, TenLoaiSP, HinhLoaiSP)
	        VALUES (?, ?, ?)
	    """;

	    try {
	        conn = DBConnection.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, loaiSanPham.getMaLoaiSP());
	        ps.setString(2, loaiSanPham.getTenLoaiSP());
	        ps.setString(3, loaiSanPham.getHinhLoaiSP());

	        return ps.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnection.close(rs, ps, conn);
	    }
	    return false;
	}
	
	public boolean update(LoaiSanPham loaiSanPham) {
	    String sql = """
	        UPDATE LoaiSanPham
	        SET TenLoaiSP = ?, HinhLoaiSP = ?
	        WHERE MaLoaiSP = ?
	    """;

	    try {
	        conn = DBConnection.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, loaiSanPham.getTenLoaiSP());
	        ps.setString(2, loaiSanPham.getHinhLoaiSP());
	        ps.setString(3, loaiSanPham.getMaLoaiSP());

	        return ps.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnection.close(rs, ps, conn);
	    }
	    return false;
	}
	
	public boolean delete(String maLoaiSP) {
	    String sql = """
	        DELETE FROM LoaiSanPham
	        WHERE MaLoaiSP = ?
	    """;

	    try {
	        conn = DBConnection.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, maLoaiSP);

	        return ps.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnection.close(rs, ps, conn);
	    }
	    return false;
	}
	
	public List<LoaiSanPham> searchByName(String tenLoaiSP) {
	    String sql = """
	        SELECT * 
	        FROM LoaiSanPham
	        WHERE TenLoaiSP LIKE ?
	    """;
	    List<LoaiSanPham> data = new ArrayList<>();

	    try {
	        conn = DBConnection.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, "%" + tenLoaiSP + "%");  
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            LoaiSanPham lsp = new LoaiSanPham(
	                rs.getString("MaLoaiSP"),
	                rs.getString("TenLoaiSP"),
	                rs.getString("HinhLoaiSP")
	            );
	            data.add(lsp);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnection.close(rs, ps, conn);
	    }

	    return data;
	}
 
}
