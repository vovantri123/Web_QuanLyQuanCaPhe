package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnection;
import models.Voucher;

public class VoucherDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public VoucherDao() { 
    }

    // Phương thức lấy tất cả các voucher từ cơ sở dữ liệu
    public List<Voucher> getAll()  { 
        String sql = """
        		SELECT * 
        		FROM Voucher
        		""";  
        List<Voucher> data = new ArrayList<>(); 

        try { 
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {  
                Voucher v = new Voucher(
                    rs.getString("maVC"),  
                    rs.getString("tenVC"),  
                    rs.getFloat("giaTriVC"),  
                    rs.getInt("soLuotSuDungToiDa"), 
                    rs.getInt("soLuotDaSuDung"),  
                    rs.getDate("ngayBatDau"), 
                    rs.getDate("ngayKetThuc"),  
                    rs.getString("trangThai")  
                );
                data.add(v);   
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            DBConnection.close(rs, ps, conn);  
        }  

        return data;   
    }
    
    public Voucher getById(String maVC) {
        String sql = """
                SELECT * 
                FROM Voucher
                WHERE maVC = ? 
                AND SoLuotDaSuDung < SoLuotSuDungToiDa 
                AND NgayKetThuc >= CAST(GETDATE() AS DATE)
        		AND NgayBatDau <= CAST(GETDATE() AS DATE)
            """;
        Voucher voucher = null;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maVC);
            rs = ps.executeQuery();

            if (rs.next()) {
                voucher = new Voucher(
                    rs.getString("maVC"),
                    rs.getString("tenVC"),
                    rs.getFloat("giaTriVC"),
                    rs.getInt("soLuotSuDungToiDa"),
                    rs.getInt("soLuotDaSuDung"),
                    rs.getDate("ngayBatDau"),
                    rs.getDate("ngayKetThuc"),
                    rs.getString("trangThai")
                );
               System.out.println(voucher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return voucher;
    }
    
    public Voucher getByIdToUpdate(String maVC) {
        String sql = """
                SELECT * 
                FROM Voucher
                WHERE maVC = ?  
            """;
        Voucher voucher = null;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maVC);
            rs = ps.executeQuery();

            if (rs.next()) {
                voucher = new Voucher(
                    rs.getString("maVC"),
                    rs.getString("tenVC"),
                    rs.getFloat("giaTriVC"),
                    rs.getInt("soLuotSuDungToiDa"),
                    rs.getInt("soLuotDaSuDung"),
                    rs.getDate("ngayBatDau"),
                    rs.getDate("ngayKetThuc"),
                    rs.getString("trangThai")
                );
               System.out.println(voucher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return voucher;
    }

    public boolean insert(Voucher v) {
        String sql = """
            INSERT INTO Voucher(maVC, tenVC, giaTriVC, soLuotSuDungToiDa, soLuotDaSuDung, ngayBatDau, ngayKetThuc, trangThai)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, v.getMaVC()); //Đã có trg_TuDongTaoMaVC_Voucher, nên 1 và 8 điền j cũng được
            ps.setString(2, v.getTenVC());
            ps.setFloat(3, v.getGiaTriVC());
            ps.setInt(4, v.getSoLuotSuDungToiDa());
            ps.setInt(5, v.getSoLuotDaSuDung());
            ps.setDate(6, v.getNgayBatDau());
            ps.setDate(7, v.getNgayKetThuc());
            ps.setString(8, v.getTrangThai());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }

    public boolean update(Voucher v) {
        String sql = """
            UPDATE Voucher
            SET tenVC=?, giaTriVC=?, soLuotSuDungToiDa=?, soLuotDaSuDung=?, ngayBatDau=?, ngayKetThuc=?, trangThai=?
            WHERE maVC=?
            """;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, v.getTenVC());
            ps.setFloat(2, v.getGiaTriVC());
            ps.setInt(3, v.getSoLuotSuDungToiDa());
            ps.setInt(4, v.getSoLuotDaSuDung());
            ps.setDate(5, v.getNgayBatDau());
            ps.setDate(6, v.getNgayKetThuc());
            ps.setString(7, v.getTrangThai());
            ps.setString(8, v.getMaVC());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }

    public boolean delete(String maVC) {
        String sql = """
            DELETE FROM Voucher
            WHERE maVC=?
            """;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maVC);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }
    
    public List<Voucher> searchByName(String tenVC) {
    	String sql = """
    	        SELECT * FROM Voucher
    	        WHERE tenVC LIKE ?
    	    """;
        List<Voucher> data = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + tenVC + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Voucher v = new Voucher(
                    rs.getString("maVC"),
                    rs.getString("tenVC"),
                    rs.getFloat("giaTriVC"),
                    rs.getInt("soLuotSuDungToiDa"),
                    rs.getInt("soLuotDaSuDung"),
                    rs.getDate("ngayBatDau"),
                    rs.getDate("ngayKetThuc"),
                    rs.getString("trangThai")
                );
                data.add(v); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return data;
    }
    
    public boolean updateSoLuong(String maVC) {
        String sql = """
            UPDATE Voucher
			SET SoLuotSuDungToiDa = SoLuotSuDungToiDa - 1, SoLuotDaSuDung = SoLuotDaSuDung + 1
			WHERE maVC= ?
            """;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maVC);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }

}
