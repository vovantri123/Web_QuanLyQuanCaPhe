package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import daos.NguoiDungDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.NguoiDung;
import utilities.XuLyAnh;

/**
 * Servlet implementation class DangKyServlet
 */
@WebServlet("/DangKyServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class DangKyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangKyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		NguoiDungDao ndDao = new NguoiDungDao();
		String action = request.getParameter("action");
		if (action.equals("signup")) {
			request.getRequestDispatcher("/views/template/signup.jsp").forward(request, response);
		} else if (action.equals("register")) {

			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			String matKhauRetry = request.getParameter("matKhauRetry");
			String hoTen = request.getParameter("hoTen");
			String ngay = request.getParameter("ngay");
			String sdt = request.getParameter("sdt");
			String gioiTinh = request.getParameter("gioiTinh");
			String email = request.getParameter("email");
			String anhND = request.getParameter("anhND");
			String diaChi = request.getParameter("diaChi");


			
			int year = Integer.parseInt(ngay);

			NguoiDung nDung = new NguoiDung("", hoTen, year, gioiTinh, sdt, email, diaChi, anhND, "User", tenDangNhap, matKhau);
			XuLyAnh xLyAnh = new XuLyAnh();
			xLyAnh.luuAnh(request, getServletContext(), "HinhNguoiDung");

			if (matKhau.equals(matKhauRetry)) {
				if (ndDao.insert(nDung)) {
					request.setAttribute("msg", "Thêm thành công");
					request.setAttribute("typeMess", "success");
				} else {
					request.setAttribute("msg", "Không thành công");
					request.setAttribute("typeMess", "error");
				}
			} else {
				request.setAttribute("msg", "Không thành công");
				request.setAttribute("typeMess", "error");
			}
			request.getRequestDispatcher("/views/template/signup.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
