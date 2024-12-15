package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnection;
import models.DonHang;

public class DonHangDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public DonHangDao() {
	}

	public List<DonHang> getAll() {
		String sql = """
				 		SELECT dh.*, kv.TenKV
				FROM DonHang dh
				INNER JOIN KhuVuc kv ON dh.MaKV = kv.MaKV
				 		""";
		List<DonHang> data = new ArrayList<>();

		try {
			// public DonHang(String maDH, float giaTriDH, Date ngayMua, String trangThai,
			// String maKV, String maVC, String tenKV)
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				DonHang dh = new DonHang(rs.getString("MaDH"), rs.getFloat("GiaTriDH"), rs.getDate("NgayMua"),
						rs.getString("TrangThai"), rs.getString("MaKV"), rs.getString("MaVC"), rs.getString("TenKV"));
				data.add(dh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}

		return data;
	}

	public String generateMaDH() {
		String sql = "SELECT dbo.FUNC_TaoMaDH() AS MaDH";
		String maDH = null;
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				maDH = rs.getString("MaDH");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return maDH;
	}

	public boolean insert(DonHang dh) {
		String sql = """
				INSERT INTO DonHang(MaDH, GiaTriDH, NgayMua, TrangThai, MaKV, MaVC)
				VALUES(?,?,?,?,?,?)
				""";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dh.getMaDH());
			ps.setFloat(2, dh.getGiaTriDH());
			ps.setDate(3, dh.getNgayMua());
			ps.setString(4, dh.getTrangThai());
			ps.setString(5, dh.getMaKV());
			ps.setString(6, dh.getMaVC());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return false;
	}

	public List<DonHang> getByRange(Date fromDate, Date toDate, String maND, String trangThai) {
	    // Bắt đầu câu SQL cơ bản
	    StringBuilder sql = new StringBuilder("""
	                SELECT dh.*, kv.TenKV
	                FROM DonHang dh
	                INNER JOIN KhuVuc kv ON dh.MaKV = kv.MaKV
	            """);

	    boolean firstCondition = false;  // Biến kiểm tra điều kiện đầu tiên

	    // Nếu có maND, thêm điều kiện lọc theo MaND
	    if (maND != null && !maND.isEmpty()) {
	        sql.append(" INNER JOIN ThanhToan tt ON tt.MaDH = dh.MaDH WHERE MaND = ?");
	        firstCondition = true;
	    }

	    // Thêm điều kiện lọc theo khoảng thời gian nếu ngày không phải null
	    if (fromDate != null && toDate != null) {
	        // Nếu đã có điều kiện đầu tiên, thêm AND, nếu không thì chỉ cần WHERE
	        if (firstCondition) {
	            sql.append(" AND dh.NgayMua BETWEEN ? AND ?");
	        } else {
	            sql.append(" WHERE dh.NgayMua BETWEEN ? AND ?");
	            firstCondition = true;
	        }
	    }

	    // Nếu có trạng thái, thêm điều kiện lọc theo trạng thái
	    if (trangThai != null && !trangThai.isEmpty() && !trangThai.equals("Tất cả")) {
	        if (firstCondition) {
	            sql.append(" AND dh.TrangThai = ?");
	        } else {
	            sql.append(" WHERE dh.TrangThai = ?");
	            firstCondition = true;
	        }
	    }

	    List<DonHang> data = new ArrayList<>();

	    try {
	        conn = DBConnection.getConnection();
	        ps = conn.prepareStatement(sql.toString());

	        // Nếu có maND, set tham số cho maND
	        int index = 1;
	        if (maND != null && !maND.isEmpty()) {
	            ps.setString(index++, maND);
	        }

	        // Nếu có khoảng thời gian, set tham số cho ngày
	        if (fromDate != null && toDate != null) {
	            ps.setDate(index++, new java.sql.Date(fromDate.getTime()));  // Convert Date to java.sql.Date
	            ps.setDate(index++, new java.sql.Date(toDate.getTime()));    // Convert Date to java.sql.Date
	        }

	        // Nếu có trạng thái, set tham số cho trạng thái
	        if (trangThai != null && !trangThai.isEmpty() && !trangThai.equals("Tất cả")) {
	            ps.setString(index++, trangThai);
	        }

	        rs = ps.executeQuery();

	        while (rs.next()) {
	            DonHang dh = new DonHang(rs.getString("MaDH"), rs.getFloat("GiaTriDH"), rs.getDate("NgayMua"),
	                    rs.getString("TrangThai"), rs.getString("MaKV"), rs.getString("MaVC"), rs.getString("TenKV"));
	            data.add(dh);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnection.close(rs, ps, conn);
	    }

	    return data;
	}

	public DonHang getById(String maDH) {
		String sql = """
				SELECT dh.*, kv.TenKV
				FROM DonHang dh
				INNER JOIN KhuVuc kv ON dh.MaKV = kv.MaKV
				WHERE MaDH = ?
				      """;
		DonHang donHang = null;

		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, maDH);
			rs = ps.executeQuery();
			if (rs.next()) {
				donHang = new DonHang(rs.getString("MaDH"), rs.getFloat("GiaTriDH"), rs.getDate("NgayMua"),
						rs.getString("TrangThai"), rs.getString("MaKV"), rs.getString("MaVC"), rs.getString("TenKV"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}

		return donHang;
	}
	
	public boolean updateTrangThai(String trangThai,String maDH) {
        String sql = """
            UPDATE DonHang
            SET TrangThai = ?
            WHERE MaDH = ?
        """;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, trangThai);
            ps.setString(2, maDH);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }

	public List<DonHang> getByNDId(String maND) {
		String sql = """
				SELECT dh.*, kv.TenKV
				FROM DonHang dh
				INNER JOIN KhuVuc kv ON dh.MaKV = kv.MaKV
				INNER JOIN ThanhToan tt ON tt.MaDH = dh.MaDH
				WHERE MaND = ?
				      """;
		List<DonHang> data = new ArrayList<>();

		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, maND);
			rs = ps.executeQuery();
			while (rs.next()) {
				DonHang donHang = new DonHang(rs.getString("MaDH"), rs.getFloat("GiaTriDH"), rs.getDate("NgayMua"),
						rs.getString("TrangThai"), rs.getString("MaKV"), rs.getString("MaVC"), rs.getString("TenKV"));
				data.add(donHang);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}

		return data;
	}
}
