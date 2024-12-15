package controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.Normalizer.Form;

import daos.NguoiDungDao;
import models.*;

/**
 * Servlet implementation class GoogleLoginServlet
 */
@WebServlet("/GoogleLoginServlet")
public class GoogleLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoogleLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String code = request.getParameter("code");
			NguoiDungDao ndDao = new NguoiDungDao();
		if (code != null && !code.isEmpty()) {
			GoogleLogin gg = new GoogleLogin();
			String accessToken = gg.getToken(code);
			NguoiDung nguoiDung = gg.getUserInfo(accessToken);
			if(nguoiDung.getMaND().equals(""))
			{
				nguoiDung.setMaND(ndDao.getIDByEmail(nguoiDung.getEmail()));
			}
			if(!ndDao.checkMailExsist(nguoiDung.getEmail()))
			{
				if(ndDao.insert(nguoiDung))
				{
					HttpSession session = request.getSession();
					session.setAttribute("nguoiDung", nguoiDung);
					session.setAttribute("msg", "Đăng nhập thành công");
					session.setAttribute("typeMess", "success");
					response.sendRedirect(request.getContextPath() + "/TrangChuServlet");
				}
				else {
					request.setAttribute("msg", "Đăng nhập thất bại");
					request.setAttribute("typeMess", "error");
					request.getRequestDispatcher("/views/template/login.jsp").forward(request,
							response);
				}
			}
			else {
				nguoiDung = ndDao.getById(nguoiDung.getMaND());
				HttpSession session = request.getSession();
				session.setAttribute("nguoiDung", nguoiDung);
				session.setAttribute("msg", "Đăng nhập thành công");
				session.setAttribute("typeMess", "success");
				response.sendRedirect(request.getContextPath() + "/TrangChuServlet");
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
