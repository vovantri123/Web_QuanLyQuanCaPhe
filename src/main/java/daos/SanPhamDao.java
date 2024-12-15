package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnection;
import models.SanPham; 

public class SanPhamDao {
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
	public SanPhamDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<SanPham> getAll()
	{
		String sql = """
				SELECT sp.*, lsp.TenLoaiSP 
				FROM SanPham sp
				LEFT OUTER JOIN LoaiSanPham lsp ON sp.MaLoaiSP = lsp.MaLoaiSP
				"""; 
        List<SanPham> data = new ArrayList<>(); 

        try { 
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
         // public SanPham(String maSP, String tenSP, float giaSP, String anhSP, String maLoaiSP, String moTaSP, String tenLoaiSP) 
            while (rs.next()) {  
            	SanPham sp = new SanPham(
                    rs.getString("MaSP"),  
                    rs.getString("TenSP"), 
                    rs.getFloat("GiaSP"),  
                    rs.getString("AnhSP"),  
                    rs.getString("MaLoaiSP"),
                    rs.getString("MoTaSP"),
                    rs.getString("TenLoaiSP")
                ); 
                data.add(sp);   
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            DBConnection.close(rs, ps, conn);  
        }  

        return data;   
	}
	
	public SanPham getById(String maSP) {
        String sql = """
    		SELECT sp.*, lsp.TenLoaiSP 
			FROM SanPham sp
			LEFT OUTER JOIN LoaiSanPham lsp ON sp.MaLoaiSP = lsp.MaLoaiSP
			WHERE sp.MaSP = ? 
            """;
        SanPham sanPham = null;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maSP);
            rs = ps.executeQuery(); 
            if (rs.next()) {
            	sanPham = new SanPham(
        			rs.getString("MaSP"),  
                    rs.getString("TenSP"), 
                    rs.getFloat("GiaSP"),  
                    rs.getString("AnhSP"),  
                    rs.getString("MaLoaiSP"),
                    rs.getString("MoTaSP"),
                    rs.getString("TenLoaiSP")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return sanPham;
    }
	 
    public boolean insert(SanPham sp) {
        String sql = """
            INSERT INTO SanPham(MaSP, TenSP, GiaSP, AnhSP, MaLoaiSP, MoTaSP)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTenSP());
            ps.setFloat(3, sp.getGiaSP());
            ps.setString(4, sp.getAnhSP());
            ps.setString(5, sp.getMaLoaiSP());
            ps.setString(6, sp.getMoTaSP());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }
 
    public boolean update(SanPham sp) {
        String sql = """
            UPDATE SanPham
            SET TenSP = ?, GiaSP = ?, AnhSP = ?, MaLoaiSP = ?, MoTaSP = ?
            WHERE MaSP = ?
            """;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getTenSP());
            ps.setFloat(2, sp.getGiaSP());
            ps.setString(3, sp.getAnhSP());
            ps.setString(4, sp.getMaLoaiSP());
            ps.setString(5, sp.getMoTaSP());
            ps.setString(6, sp.getMaSP());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }
 
    public boolean delete(String maSP) {
        String sql = """
            DELETE FROM SanPham
            WHERE MaSP = ?
            """;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maSP);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }
    
    public List<SanPham> searchByMaLoaiSP(String maLoaiSP) {
        String sql = """
            SELECT sp.*, lsp.TenLoaiSP
            FROM SanPham sp
            LEFT OUTER JOIN LoaiSanPham lsp ON sp.MaLoaiSP = lsp.MaLoaiSP
            WHERE sp.MaLoaiSP = ?
        """;
        List<SanPham> data = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maLoaiSP);   
            rs = ps.executeQuery();

            while (rs.next()) {
                SanPham sp = new SanPham(
                    rs.getString("MaSP"),
                    rs.getString("TenSP"),
                    rs.getFloat("GiaSP"),
                    rs.getString("AnhSP"),
                    rs.getString("MaLoaiSP"),
                    rs.getString("MoTaSP"),
                    rs.getString("TenLoaiSP")
                );
                data.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }

        return data;
    }

    
 
    
    
	 
    public List<SanPham> getAllHot()
	{
		String sql = """
				SELECT SanPham.MaSP, 
				SanPham.TenSP, 
				SanPham.GiaSP, 
				SanPham.AnhSP,
				SanPham.MaLoaiSP, AVG(DanhGia.SoSao) as TB
				FROM SanPham INNER JOIN DanhGia ON SanPham.MaSP = DanhGia.MaSP 
				GROUP BY SanPham.MaSP,SanPham.TenSP, SanPham.GiaSP, SanPham.AnhSP, SanPham.MaLoaiSP
				"""; 
        List<SanPham> data = new ArrayList<>(); 

        try { 
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) { 
                // Khởi tạo đối tượng Slide từ dữ liệu trong ResultSet
            	SanPham s = new SanPham(
                    rs.getString("MaSP"), // Mã slide
                    rs.getString("TenSP"), // Tên slide
                    rs.getFloat("GiaSP"), // Ảnh slide
                    rs.getString("AnhSP"),
                    rs.getString("MaLoaiSP"),// Vị trí slide
                    rs.getDouble("TB")
                );
                data.add(s);  // Thêm slide vào danh sách
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            DBConnection.close(rs, ps, conn); // Đảm bảo đóng kết nối
        }  

        return data;  // Trả về danh sách các slide
	}
	 
	public List<SanPham> getAllSP()
	{
		String sql = """
				SELECT SanPham.MaSP, SanPham.TenSP, SanPham.GiaSP, SanPham.AnhSP, SanPham.MaLoaiSP,LoaiSanPham.TenLoaiSP 
				FROM SanPham INNER JOIN LoaiSanPham ON SanPham.MaLoaiSP = LoaiSanPham.MaLoaiSP
				"""; 
        List<SanPham> data = new ArrayList<>(); 

        try { 
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) { 
                // Khởi tạo đối tượng Slide từ dữ liệu trong ResultSet
            	SanPham s = new SanPham(
                    rs.getString("MaSP"), // Mã slide
                    rs.getString("TenSP"), // Tên slide
                    rs.getFloat("GiaSP"), // Ảnh slide
                    rs.getString("AnhSP"), // Vị trí slide
                    rs.getString("MaLoaiSP"),
                    rs.getString("MoTaSP"),
                    rs.getString("TenLoaiSP")
                );
                data.add(s);  // Thêm slide vào danh sách
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            DBConnection.close(rs, ps, conn); // Đảm bảo đóng kết nối
        }  

        return data;  // Trả về danh sách các slide
	}
	
	public List<SanPham> getSanPhamByLoaiSP(String idLoaiSP)
	{
		String sql = """
				SELECT * FROM SanPham INNER JOIN 
				LoaiSanPham ON SanPham.MaLoaiSP = LoaiSanPham.MaLoaiSP 
				WHERE SanPham.MaLoaiSP = ?
				"""; 
        List<SanPham> data = new ArrayList<>(); 

        try { 
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,idLoaiSP);
            rs = ps.executeQuery();
            
            while (rs.next()) { 
                
            	SanPham s = new SanPham(
                    rs.getString("MaSP"), 
                    rs.getString("TenSP"), 
                    rs.getFloat("GiaSP"), 
                    rs.getString("AnhSP"), 
                    rs.getString("MaLoaiSP"),
                    rs.getString("MoTaSP"),
                    rs.getString("TenLoaiSP")
                );
                data.add(s);  
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            DBConnection.close(rs, ps, conn); 
        }  

        return data;  
	}
	
	public List<SanPham> getSanPhamCungLoaiSP(String idLoaiSP, String idSP)
	{
		String sql = """
				SELECT * FROM SanPham INNER JOIN 
				LoaiSanPham ON SanPham.MaLoaiSP = LoaiSanPham.MaLoaiSP 
				WHERE SanPham.MaLoaiSP = ? AND SanPham.MaSP != ?
				"""; 
        List<SanPham> data = new ArrayList<>(); 

        try { 
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,idLoaiSP);
            ps.setString(2,idSP);
            rs = ps.executeQuery();
            
            while (rs.next()) { 
                
            	SanPham s = new SanPham(
                    rs.getString("MaSP"), 
                    rs.getString("TenSP"), 
                    rs.getFloat("GiaSP"), 
                    rs.getString("AnhSP"), 
                    rs.getString("MaLoaiSP"),
                    rs.getString("MoTaSP"),
                    rs.getString("TenLoaiSP")
                );
                data.add(s);  
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            DBConnection.close(rs, ps, conn); 
        }  

        return data;  
	}
	
	public SanPham getSanPhamByLoaiId(String idSP)
	{
		String sql = """
				SELECT * FROM SanPham INNER JOIN 
				LoaiSanPham ON SanPham.MaLoaiSP = LoaiSanPham.MaLoaiSP 
				WHERE SanPham.MaSP = ?
				"""; 
		SanPham s = new SanPham();

        try { 
            conn = DBConnection.getConnection();	
            ps = conn.prepareStatement(sql);
            ps.setString(1,idSP);
            rs = ps.executeQuery();
            
            while (rs.next()) { 
                
            		s = new SanPham(
                    rs.getString("MaSP"), 
                    rs.getString("TenSP"), 
                    rs.getFloat("GiaSP"), 
                    rs.getString("AnhSP"), 
                    rs.getString("MaLoaiSP"),
                    rs.getString("MoTaSP"),
                    rs.getString("TenLoaiSP")
                );
               
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            DBConnection.close(rs, ps, conn); 
        }  

        return s;  
	}	
}
