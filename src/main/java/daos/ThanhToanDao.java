package daos;

import conn.DBConnection;
import models.ThanhToan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThanhToanDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ThanhToanDao () {}
	
	public boolean insert(ThanhToan tt) {
		String sql = """
				INSERT INTO ThanhToan(MaND, MaDH, MaPTTT)
				VALUES(?,?,?)
				""";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tt.getMaND());
			ps.setString(2, tt.getMaDH());
			ps.setString(3, tt.getMaPTTT());
			
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return false;
	}

    public ThanhToan getById(String maDH) {
        String sql = """
            SELECT maND, maDH, maPTTT
            FROM ThanhToan
            WHERE maDH = ?
        """;
        ThanhToan thanhToan = null;  

        try {
            conn = DBConnection.getConnection();   
            ps = conn.prepareStatement(sql);
            ps.setString(1, maDH);  

            rs = ps.executeQuery();

            if (rs.next()) {
               
                thanhToan = new ThanhToan(
                    rs.getString("maND"),    
                    rs.getString("maDH"),  
                    rs.getString("maPTTT")   
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);   
        }
        return thanhToan;   
    }
}
