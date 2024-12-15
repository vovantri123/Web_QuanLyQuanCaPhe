package daos; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnection;
import models.PhaChe;

public class PhaCheDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public PhaCheDao() {
        // Constructor mặc định
    }

    // Thêm mới PhaChe
    public boolean insert(PhaChe phaChe) {
        String sql = """
            INSERT INTO PhaChe(MaSP, MaNL, SoLuong)
            VALUES (?, ?, ?)
            """;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, phaChe.getMaSP());
            ps.setString(2, phaChe.getMaNL());
            ps.setInt(3, phaChe.getSoLuong());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }

    // Xóa PhaChe theo MaSP và MaNL
    public boolean delete(String maSP, String maNL) {
        String sql = """
            DELETE FROM PhaChe
            WHERE MaSP = ? AND MaNL = ?
            """;
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maSP);
            ps.setString(2, maNL);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }

    // Lấy danh sách các nguyên liệu pha chế cho sản phẩm
    public List<PhaChe> getByMaSP(String maSP) {
        String sql = """
            SELECT sp.MaSP, nl.MaNL, sp.TenSP, pc.SoLuong, nl.TenNL, nl.SoLuongTonKho
            FROM PhaChe pc
            JOIN NguyenLieu nl ON pc.MaNL = nl.MaNL
            JOIN SanPham sp ON pc.MaSP = sp.MaSP
            WHERE pc.MaSP = ?
        """;
        List<PhaChe> data = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maSP);
            rs = ps.executeQuery();

            while (rs.next()) {
                // Tạo đối tượng PhaChe với thông tin từ các bảng
                PhaChe phaChe = new PhaChe(
                    rs.getString("MaSP"),  // MaSP
                    rs.getString("MaNL"),  // MaNL
                    rs.getInt("SoLuong"),  // SoLuong
                    rs.getString("TenSP"), // TenSP
                    rs.getString("TenNL"),  // TenNL
                    rs.getInt("SoLuongTonKho")
                );
                data.add(phaChe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return data;
    }

}
