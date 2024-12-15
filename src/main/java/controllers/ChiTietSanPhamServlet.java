package controllers;

import java.io.IOException;
import java.util.List;

import daos.DanhGiaDao;
import daos.GioHangDao;
import daos.SanPhamDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.DanhGia;
import models.GioHang;
import models.NguoiDung;
import models.SanPham;

/**
 * Servlet implementation class ChiTietSanPhamServlet
 */
@WebServlet("/ChiTietSanPhamServlet")
public class ChiTietSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietSanPhamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    GioHangDao ghDao = new GioHangDao();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String idLoaiSp = request.getParameter("type");
		String action = request.getParameter("action");
		System.out.println(idLoaiSp);
		SanPhamDao sanPhamDao = new SanPhamDao();
		DanhGiaDao dgDao = new DanhGiaDao(); 
		HttpSession session = request.getSession();
		NguoiDung nd = (NguoiDung) session.getAttribute("nguoiDung");	
		session.setAttribute("id", id);
		session.setAttribute("idLoaiSp", idLoaiSp);
		if(action==null)
		{
			session.setAttribute("nguoiDung", nd);
			request.setAttribute("product", sanPhamDao.getSanPhamByLoaiId(id));
			request.setAttribute("listReview", dgDao.getAllByIdSP(id));
			request.setAttribute("listProduct", sanPhamDao.getSanPhamCungLoaiSP(idLoaiSp,id));
			request.getRequestDispatcher("/views/template/chitietSP.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		HttpSession session = request.getSession();
        NguoiDung nd = (NguoiDung) session.getAttribute("nguoiDung");  // Lấy mã người dùng từ session

		String id = request.getParameter("id");
        String type = request.getParameter("type");
		
		String maSP = request.getParameter("maSP");
		int soLuong = Integer.parseInt(request.getParameter("soLuong"));
		
        SanPhamDao spDAO = new SanPhamDao();
		SanPham sp = spDAO.getSanPhamByLoaiId(maSP);
		
		List<GioHang> cart = ghDao.getById(nd.getMaND());
		boolean tonTai = false;
		
		for (GioHang gh :cart) {
			if (gh.getMaSP().equals(maSP)) {
				ghDao.updateSoLuongSanPham(maSP, soLuong);
				tonTai = true;
				break;
			}
		}
		
		if (!tonTai) {
			ghDao.insert(new GioHang(nd.getMaND(), maSP, soLuong, sp.getTenSP(), sp.getGiaSP()));
			cart = ghDao.getById(nd.getMaND());
		}
		
		session.setAttribute("soSPDat", cart.size());	
		
		// Kiếm tra cart
		for (GioHang gh :cart) {
			System.out.println("Số lượng: " + gh.getMaSP() + " Số lượng: " + gh.getSoLuong());
		}		

		// Tạo lại URL cho chuyển hướng
        String redirectURL = "ChiTietSanPhamServlet?id=" + id + "&type=" + type;

        // Chuyển hướng trở lại trang đã gửi form
        response.sendRedirect(redirectURL);
	}
}
