package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import conn.DBConnection;
import models.ChiTietHoaDon;

public class ChiTietHoaDonDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ChiTietHoaDonDao () {}

	public boolean insert(ChiTietHoaDon ctHD) {
		String sql = """
				INSERT INTO ChiTietHoaDon(MaDH, MaSP, SoLuong, TongTien)
				VALUES(?,?,?,?)
				""";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, ctHD.getMaDH());
			ps.setString(2, ctHD.getMaSP());
			ps.setInt(3, ctHD.getSoLuong());
			ps.setFloat(4, ctHD.getTongTien());
			
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return false;
	}
	
	public List<ChiTietHoaDon> getChiTietHoaDonByMaDH(String maDH) {
	    String sql = """
	        SELECT cthd.MaDH, cthd.MaSP, sp.TenSP, sp.GiaSP, cthd.SoLuong, cthd.TongTien
	        FROM ChiTietHoaDon cthd
	        JOIN SanPham sp ON cthd.MaSP = sp.MaSP
	        WHERE cthd.MaDH = ?
	    """;

	    List<ChiTietHoaDon> chiTietHoaDonList = new ArrayList<>();

	    try {
	        conn = DBConnection.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, maDH); // Gán giá trị mã đơn hàng vào tham số
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            ChiTietHoaDon cthd = new ChiTietHoaDon(
	                rs.getString("MaDH"),
	                rs.getString("MaSP"),
	                rs.getInt("SoLuong"),
	                rs.getFloat("TongTien"),
	                rs.getString("TenSP"),
	                rs.getFloat("GiaSP")
	            );
	            chiTietHoaDonList.add(cthd);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnection.close(rs, ps, conn);  // Đảm bảo đóng kết nối
	    }

	    return chiTietHoaDonList;
	}
	
	public float getTongTienSanPham(String maDH) {
	    String sql = """
	        SELECT COALESCE(SUM(cthd.TongTien), 0) AS TongTienSP
	        FROM DonHang dh
	        JOIN ChiTietHoaDon cthd ON dh.MaDH = cthd.MaDH
	        JOIN SanPham sp ON cthd.MaSP = sp.MaSP
	        WHERE dh.MaDH = ?
	    """;
	    float tongTienSP = 0;

	    try {
	        conn = DBConnection.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, maDH);
	        rs = ps.executeQuery();


	        if (rs.next()) {
	            tongTienSP = rs.getFloat("TongTienSP");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnection.close(rs, ps, conn);
	    }
	    return tongTienSP;
	}
	
	public float layPhiVanChuyenTheoMaDH(String maDH) {
	    String sql = """
	        SELECT kv.PhiVanChuyen
	        FROM DonHang dh
	        JOIN KhuVuc kv ON dh.MaKV = kv.MaKV
	        WHERE dh.MaDH = ?
	    """;

	    float phiVanChuyen = 0;

	    try {
	        conn = DBConnection.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, maDH);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            phiVanChuyen = rs.getFloat("PhiVanChuyen");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnection.close(rs, ps, conn);
	    }

	    return phiVanChuyen;
	}

	public float layGiaTriVoucherTheoMaDH(String maDH) {
	    String sql = """
	        SELECT COALESCE(vc.GiaTriVC, 0) AS GiaTriVC
	        FROM Voucher vc
	        JOIN DonHang dh ON vc.MaVC = dh.MaVC
	        WHERE dh.MaDH = ?
	    """;

	    float giaTriVoucher = 0;

	    try {
	        conn = DBConnection.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, maDH);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            giaTriVoucher = rs.getFloat("GiaTriVC");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnection.close(rs, ps, conn);
	    }

	    return giaTriVoucher;
	}

	// Dashboard methods
	public float getTongGiaTriDonHangByDateRange(Date startDate, Date endDate) {
	    String sql = """
	        SELECT COALESCE(SUM(GiaTriDH), 0) AS TongGiaTriDH
	        FROM DonHang
	        WHERE NgayMua BETWEEN ? AND ?
	    """;

	    float tongGiaTriDH = 0;

	    try {
	        conn = DBConnection.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setDate(1, startDate);
	        ps.setDate(2, endDate);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            tongGiaTriDH = rs.getFloat("TongGiaTriDH");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnection.close(rs, ps, conn);
	    }

	    return tongGiaTriDH;
	}

	public int getTongSanPhamByDateRange(Date startDate, Date endDate) {
	    String sql = """
	        SELECT SUM(cthd.SoLuong) AS TotalQuantity
	        FROM ChiTietHoaDon cthd
	        JOIN DonHang dh ON cthd.MaDH = dh.MaDH
	        WHERE dh.NgayMua BETWEEN ? AND ?
	    """;

	    int totalQuantity = 0;

	    try {
	        conn = DBConnection.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setDate(1, startDate);
	        ps.setDate(2, endDate);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            totalQuantity = rs.getInt("TotalQuantity");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnection.close(rs, ps, conn);
	    }

	    return totalQuantity;
	}

	public int getTongKhachHangByDateRange(Date startDate, Date endDate) {
	    String sql = """
	        SELECT COUNT(DISTINCT tt.MaND) AS DistinctCountMaND
	        FROM ThanhToan tt
	        JOIN DonHang dh ON tt.MaDH = dh.MaDH
	        WHERE dh.NgayMua BETWEEN ? AND ?
	    """;

	    int distinctCountMaND = 0;

	    try {
	        conn = DBConnection.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setDate(1, startDate);
	        ps.setDate(2, endDate);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            distinctCountMaND = rs.getInt("DistinctCountMaND");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnection.close(rs, ps, conn);
	    }

	    return distinctCountMaND;
	}

	public List<Map<String, Object>> getSanPhamVaTongSoLuongByDateRange(Date startDate, Date endDate) {
	    String sql = """
	        SELECT sp.TenSP, SUM(cthd.SoLuong) AS TongSoLuong
	        FROM ChiTietHoaDon cthd
	        JOIN DonHang dh ON cthd.MaDH = dh.MaDH
	        JOIN SanPham sp ON cthd.MaSP = sp.MaSP
	        WHERE dh.NgayMua BETWEEN ? AND ?
	        GROUP BY cthd.MaSP, sp.TenSP
	    """;

	    List<Map<String, Object>> result = new ArrayList<>();

	    try {
	        conn = DBConnection.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setDate(1, startDate);
	        ps.setDate(2, endDate);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            // Tạo một Map để lưu tên sản phẩm và tổng số lượng
	            Map<String, Object> row = new HashMap<>();
	            row.put("TenSP", rs.getString("TenSP"));
	            row.put("TongSoLuong", rs.getInt("TongSoLuong"));

	            // Thêm vào danh sách kết quả
	            result.add(row);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnection.close(rs, ps, conn);
	    }

	    return result;
	}


	public List<Map<String, Object>> getSanPhamVaTongTienByDateRange(Date startDate, Date endDate) {
	    String sql = """
	        SELECT sp.TenSP, SUM(cthd.TongTien) AS TongTien
	        FROM ChiTietHoaDon cthd
	        JOIN DonHang dh ON cthd.MaDH = dh.MaDH
	        JOIN SanPham sp ON cthd.MaSP = sp.MaSP
	        WHERE dh.NgayMua BETWEEN ? AND ?
	        GROUP BY cthd.MaSP, sp.TenSP
	    """;

	    List<Map<String, Object>> result = new ArrayList<>();

	    try {
	        conn = DBConnection.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setDate(1, startDate);
	        ps.setDate(2, endDate);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            // Tạo một Map để lưu tên sản phẩm và tổng tiền
	            Map<String, Object> row = new HashMap<>();
	            row.put("TenSP", rs.getString("TenSP"));
	            row.put("TongTien", rs.getFloat("TongTien"));

	            // Thêm vào danh sách kết quả
	            result.add(row);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnection.close(rs, ps, conn);
	    }
	    return result;
	}

	public List<Map<String, Object>> getNgayMuaVaGiaTriDHByDateRange(Date startDate, Date endDate) {
	    String sql = """
	        SELECT dh.NgayMua, SUM(dh.GiaTriDH) AS GiaTriDH
	        FROM DonHang dh
	        WHERE dh.NgayMua BETWEEN ? AND ?
	        GROUP BY dh.NgayMua
	    """;

	    List<Map<String, Object>> result = new ArrayList<>();

	    try {
	        conn = DBConnection.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setDate(1, startDate);
	        ps.setDate(2, endDate);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            // Tạo một Map để lưu Ngày Mua và Giá Trị Đơn Hàng
	            Map<String, Object> row = new HashMap<>();
	            row.put("NgayMua", rs.getDate("NgayMua")); // Ngày mua
	            row.put("GiaTriDH", rs.getFloat("GiaTriDH")); // Giá trị đơn hàng
	            // Thêm vào danh sách kết quả
	            result.add(row);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnection.close(rs, ps, conn);
	    }

	    return result;
	}
}

