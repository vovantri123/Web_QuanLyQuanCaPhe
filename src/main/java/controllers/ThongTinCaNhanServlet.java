package controllers;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.NguoiDung;
import utilities.XuLyAnh;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import daos.NguoiDungDao;

/**
 * Servlet implementation class ThongTinCaNhanServlet
 */
@WebServlet("/ThongTinCaNhanServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class ThongTinCaNhanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongTinCaNhanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NguoiDungDao ndDao= new NguoiDungDao();
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		NguoiDung nd = (NguoiDung) session.getAttribute("nguoiDung");
		NguoiDung nDung = ndDao.getById(nd.getMaND());
		
		if(action == null)
		{
			
			if(nDung==null)
			{
				session.setAttribute("nguoiDung", nd);
				request.getRequestDispatcher("/views/template/profile.jsp").forward(request, response);
			}
			else {
				session.setAttribute("nguoiDung", nDung);
				request.getRequestDispatcher("/views/template/profile.jsp").forward(request, response);
			}
			
		}
		else if(action.equals("luu"))
		{
			String tenDangNhap = request.getParameter("tenDangNhapA");
			String matKhau = request.getParameter("matKhauA");
			String hoTen = request.getParameter("hoTen");
			String ngay = request.getParameter("nam");
			String sdt = request.getParameter("sdt");
			String gioiTinh = request.getParameter("gioiTinh");
			String email = request.getParameter("email");
			String anhND = request.getParameter("anhND");
			String diaChi = request.getParameter("diaChi");
			int year = Integer.parseInt(ngay);

			nDung = new NguoiDung(nd.getMaND(), hoTen, year, gioiTinh, sdt, email, diaChi, anhND, "User", tenDangNhap, matKhau);
			XuLyAnh xLyAnh = new XuLyAnh();
			xLyAnh.luuAnh(request, getServletContext(), "HinhNguoiDung");
			if (ndDao.update(nDung)) {
				request.setAttribute("msg", "Thêm thành công");
				request.setAttribute("typeMess", "success");
			} else {
				request.setAttribute("msg", "Không thành công");
				request.setAttribute("typeMess", "error");
			}
			session.setAttribute("nguoiDung", nDung);
			request.getRequestDispatcher("/views/template/profile.jsp").forward(request, response);
			
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
