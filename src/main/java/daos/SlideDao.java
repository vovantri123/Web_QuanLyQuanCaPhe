package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnection;
import models.Slide;




public class SlideDao {
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
	public SlideDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Slide> getAll()  { 

        String sql = """
        		SELECT * 
        		FROM Slide
        		""";  
 
        List<Slide> data = new ArrayList<>(); 

        try { 
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
 
            while (rs.next()) {  
            	Slide s = new Slide(
                    rs.getString("MaSlide"),  
                    rs.getString("TenSlide"),  
                    rs.getString("AnhSlide"),  
                    rs.getString("ViTri"), 
                    rs.getString("TrangThai"), 
                    rs.getString("MaND") 
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
	
	public Slide getById(String maSlide) {
        String sql = """
    		SELECT * 
    		FROM Slide
			WHERE MaSlide = ? 
            """;
        Slide slide = null;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maSlide);
            rs = ps.executeQuery(); 
            if (rs.next()) {
            	slide = new Slide(
        			rs.getString("MaSlide"),  
                    rs.getString("TenSlide"),  
                    rs.getString("AnhSlide"),  
                    rs.getString("ViTri"), 
                    rs.getString("TrangThai"), 
                    rs.getString("MaND") 
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return slide;
    }
	 
	public boolean insert(Slide s) {
        String sql = """
            INSERT INTO Slide(MaSlide, TenSlide, AnhSlide, ViTri, TrangThai, MaND)
			VALUES (?, ?, ?, ?, ?, ?)
            """;
        //VALUES('SL10', 'Slidexx', 'slidexx.jpg', '6', N'Hiển thị', 'ND01')
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMaSlide()); // Đã có trg_TuDongTaoMaSlide_Slide, nên cái đây truyền j cx được 
            ps.setString(2, s.getTenSlide());
            ps.setString(3, s.getAnhSlide());
            ps.setString(4, s.getViTri());
            ps.setString(5, s.getTrangThai());
            ps.setString(6, s.getMaND());
             
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }

    public boolean update(Slide s) {
        String sql = """ 
            UPDATE Slide
            SET TenSlide = ?, AnhSlide = ?, ViTri = ?, TrangThai=?, MaND=?
			WHERE MaSlide = ?
            """; 
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, s.getTenSlide());
            ps.setString(2, s.getAnhSlide());
            ps.setString(3, s.getViTri());
            ps.setString(4, s.getTrangThai());
            ps.setString(5, s.getMaND());
            ps.setString(6, s.getMaSlide());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }

    public boolean delete(String maSlide) {
        String sql = """
            DELETE FROM Slide
            WHERE MaSlide=?
            """;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maSlide);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
        return false;
    }
    
    public List<Slide> getAllOrderByViTri() {
        String sql = """
            SELECT * 
            FROM Slide
            ORDER BY ViTri
            """;
        List<Slide> data = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Slide s = new Slide(
                    rs.getString("MaSlide"),
                    rs.getString("TenSlide"),
                    rs.getString("AnhSlide"),
                    rs.getString("ViTri"),
                    rs.getString("TrangThai"),
                    rs.getString("MaND")
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

    
     
     
    public List<Slide> getByTrangThai(String tt)
	{
		String sql = """
				SELECT MaSlide, TenSlide, AnhSlide 
				FROM Slide 
				WHERE TrangThai = ?
				""";
		List<Slide> data = new ArrayList<>();
		
		
		try {
			conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, tt);
            rs = ps.executeQuery();
             
            while (rs.next()) {  
            	Slide s = new Slide(
                    rs.getString("MaSlide"), 
                    rs.getString("TenSlide"), 
                    rs.getString("AnhSlide")  
                );
                data.add(s);  
            }
		} catch (SQLException e) { 
			 e.printStackTrace(); 
		}
		finally {
            DBConnection.close(rs, ps, conn);  

        }
		return data;
	}

}
