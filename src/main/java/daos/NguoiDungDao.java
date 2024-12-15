package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnection;
import models.LoaiSanPham;
import models.NguoiDung;
import models.NguyenLieu;

public class NguoiDungDao {
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public NguoiDungDao() {
    	
    }
    
    public List<NguoiDung> getAll()  { 
        String sql = """
        		SELECT * 
    			FROM NguoiDung
        		"""; 
        List<NguoiDung> data = new ArrayList<>(); 

        try { 
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {  
            	NguoiDung nd = new NguoiDung(
                    rs.getString("MaND"),  
                    rs.getString("TenND"), 
                    rs.getInt("NamSinh"), 
                    rs.getString("GioiTinh"),
                    rs.getString("SoDienThoai"),
                    rs.getString("Email"),
                    rs.getString("DiaChi"),
                    rs.getString("AnhND"),
                    rs.getString("VaiTro"),
                    rs.getString("TenDangNhap"),
                    rs.getString("MatKhau")
                ); 
                data.add(nd);  
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            DBConnection.close(rs, ps, conn); 
        }  

        return data;  
    }
    
    public NguoiDung getById(String maND) {
        String sql = """
    		SELECT * 
			FROM NguoiDung
			WHERE MaND = ? 
            """;
        NguoiDung nguoiDung = null;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maND);
            rs = ps.executeQuery(); 
            if (rs.next()) {
            	nguoiDung = new NguoiDung(
        			rs.getString("MaND"),  
                    rs.getString("TenND"), 
                    rs.getInt("NamSinh"), 
                    rs.getString("GioiTinh"),
                    rs.getString("SoDienThoai"),
                    rs.getString("Email"),
                    rs.getString("DiaChi"),
                    rs.getString("AnhND"),
                    rs.getString("VaiTro"),
                    rs.getString("TenDangNhap"),
                    rs.getString("MatKhau") 
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return nguoiDung;
    }
    
    public boolean insert(NguoiDung nguoiDung) {
        String sql = """
            INSERT INTO NguoiDung(MaND, TenND, NamSinh, GioiTinh, SoDienThoai, Email, DiaChi, AnhND, VaiTro, TenDangNhap, MatKhau)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nguoiDung.getMaND());
            ps.setString(2, nguoiDung.getTenND());
            ps.setInt(3, nguoiDung.getNamSinh());
            ps.setString(4, nguoiDung.getGioiTinh());
            ps.setString(5, nguoiDung.getSdt());
            ps.setString(6, nguoiDung.getEmail());
            ps.setString(7, nguoiDung.getDiaChi());
            ps.setString(8, nguoiDung.getAnhND());
            ps.setString(9, nguoiDung.getVaiTro());
            ps.setString(10, nguoiDung.getTenDangNhap());
            ps.setString(11, nguoiDung.getMatKhau());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }

    
    public boolean update(NguoiDung nguoiDung) {
        String sql = """
            UPDATE NguoiDung
            SET TenND = ?, NamSinh = ?, GioiTinh = ?, SoDienThoai = ?, Email = ?, DiaChi = ?, AnhND = ?, VaiTro = ?, TenDangNhap = ?, MatKhau = ?
            WHERE MaND = ?
        """;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nguoiDung.getTenND());
            ps.setInt(2, nguoiDung.getNamSinh());
            ps.setString(3, nguoiDung.getGioiTinh());
            ps.setString(4, nguoiDung.getSdt());
            ps.setString(5, nguoiDung.getEmail());
            ps.setString(6, nguoiDung.getDiaChi());
            ps.setString(7, nguoiDung.getAnhND());
            ps.setString(8, nguoiDung.getVaiTro());
            ps.setString(9, nguoiDung.getTenDangNhap());
            ps.setString(10, nguoiDung.getMatKhau());
            ps.setString(11, nguoiDung.getMaND());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }
    
    public boolean updatePassword(String password,String email,String username) {
        String sql = """
            UPDATE NguoiDung
            SET MatKhau = ?
            WHERE Email = ? AND TenDangNhap = ?
        """;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, email);
            ps.setString(3, username);
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
            DELETE FROM NguoiDung
            WHERE MaND = ?
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
     
    public List<NguoiDung> searchByName(String tenND) {
        String sql = """
            SELECT * 
            FROM NguoiDung
            WHERE TenND LIKE ?
        """;
        List<NguoiDung> data = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + tenND + "%"); 
            rs = ps.executeQuery();

            while (rs.next()) {
                NguoiDung nd = new NguoiDung(
                    rs.getString("MaND"),
                    rs.getString("TenND"),
                    rs.getInt("NamSinh"),
                    rs.getString("GioiTinh"),
                    rs.getString("SoDienThoai"),
                    rs.getString("Email"),
                    rs.getString("DiaChi"),
                    rs.getString("AnhND"),
                    rs.getString("VaiTro"),
                    rs.getString("TenDangNhap"),
                    rs.getString("MatKhau")
                );
                data.add(nd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }

        return data;
    }


    public boolean checkLogin(String username, String password)
    {
    	String sql = """
    			SELECT COUNT(*) FROM NguoiDung WHERE TenDangNhap = ? AND MatKhau = ?
    			""";
    	try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery(); 
            if (rs.next()) {
            	int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }
    
    public boolean checkMail(String email,String username)
    {
    	String sql = """
    			SELECT COUNT(*) FROM NguoiDung WHERE Email = ? AND TenDangNhap = ?
    			""";
    	try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, username);
            rs = ps.executeQuery(); 
            if (rs.next()) {
            	int count = rs.getInt(1);
            	if(count==1){
                	return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }
    
    public boolean checkMailExsist(String email)
    {
    	String sql = """
    			SELECT COUNT(*) FROM NguoiDung WHERE Email = ?
    			""";
    	try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery(); 
            if (rs.next()) {
            	int count = rs.getInt(1);
                if(count==1){
                	return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }
    
    public NguoiDung getByAccount(String username, String password) {
        String sql = """
    		SELECT * 
			FROM NguoiDung
			WHERE TenDangNhap = ? AND MatKhau = ? 
            """;
        NguoiDung nguoiDung = null; 

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql); 
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery(); 
            if (rs.next()) {
            	nguoiDung = new NguoiDung(
        			rs.getString("MaND"),  
                    rs.getString("TenND"), 
                    rs.getInt("NamSinh"),  
                    rs.getString("GioiTinh"),
                    rs.getString("SoDienThoai"),
                    rs.getString("Email"),
                    rs.getString("DiaChi"),
                    rs.getString("AnhND"),
                    rs.getString("VaiTro"),
                    rs.getString("TenDangNhap"), 
                    rs.getString("MatKhau") 
                ); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        } 
        return nguoiDung;
    }
    public String getRole(String username, String password,String email)
    {
    	String sql = """
    			SELECT VaiTro FROM NguoiDung WHERE (TenDangNhap = ? AND MatKhau = ?) OR Email = ?
    			""";
    	 String role = null;
    	try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            rs = ps.executeQuery(); 
            if (rs.next()) {
            	role = rs.getString("VaiTro");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
    	return role;
    }
    public String generateMaND() {
		String sql = "SELECT dbo.FUNC_TaoMaND() AS MaND";
		String maND = null;
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				maND = rs.getString("MaND");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return maND;
	}
    
    public String getIDByEmail(String email)
    {
    	String sql = """
    			SELECT MaND FROM NguoiDung WHERE Email = ?
    			""";
    	 String maND = null;
    	try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery(); 
            if (rs.next()) {
            	maND = rs.getString("MaND");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
    	return maND;
    }
 
}
