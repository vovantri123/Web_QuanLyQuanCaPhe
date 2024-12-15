package controllers;

import java.io.IOException;

import daos.ChiTietHoaDonDao;
import daos.DonHangDao;
import daos.NguoiDungDao;
import daos.PhuongThucThanhToanDao;
import daos.ThanhToanDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BillServlet
 */
@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ChiTietHoaDonDao cthdDao = new ChiTietHoaDonDao();
		DonHangDao dhDao = new DonHangDao();
		PhuongThucThanhToanDao ptttDao = new PhuongThucThanhToanDao();
		ThanhToanDao ttDao = new ThanhToanDao();
		NguoiDungDao ndDao =new NguoiDungDao();
		
		String action = request.getParameter("action"); 
		String role = request.getParameter("role");
		
		if (action == null) {
			String maDH = request.getParameter("maDH"); 
			request.setAttribute("donHang", dhDao.getById(maDH));
			
			request.setAttribute("tenPTTT", ptttDao.getTenPhuongThucThanhToanByMaDH(maDH));
			
			request.setAttribute("nguoiDung", ndDao.getById(ttDao.getById(maDH).getMaND()));
			
			// Khúc dưới là của table
			request.setAttribute("chiTietHoaDonList", cthdDao.getChiTietHoaDonByMaDH(maDH));  
			
			double tongTienSanPham = cthdDao.getTongTienSanPham(maDH);
		    double phiVanChuyen = cthdDao.layPhiVanChuyenTheoMaDH(maDH);
		    double giam = cthdDao.layGiaTriVoucherTheoMaDH(maDH);
		    double thanhTien = tongTienSanPham + phiVanChuyen - giam;
		    request.setAttribute("tongTienSanPham", tongTienSanPham);
		    request.setAttribute("phiVanChuyen", phiVanChuyen);
		    request.setAttribute("giam", giam);
		    request.setAttribute("thanhTien", thanhTien);
			
		    if (role != null)
		    {
		    	request.getRequestDispatcher("/views/template/adminContents/donHangBill.jsp").forward(request, response);
		    }
		    else 
		    {
		    	 request.getRequestDispatcher("/views/template/admin.jsp?page=donHangBill").forward(request, response);
		    }	   
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
