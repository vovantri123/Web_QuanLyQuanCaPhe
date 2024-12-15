package controllers;

import java.io.IOException;
import java.util.List;

import daos.GioHangDao;
import daos.NguoiDungDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.GioHang;

/**
 * Servlet implementation class DangNhapServlet
 */
@WebServlet("/DangNhapServlet")
public class DangNhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		NguoiDungDao ndDao = new NguoiDungDao(); 
		GioHangDao ghDao = new GioHangDao();
		if(action==null)
		{
			request.getRequestDispatcher("/views/template/login.jsp").forward(request, response);
		}
		else if(action.equals("login"))
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			HttpSession session = request.getSession();
			if(ndDao.checkLogin(username, password))
			{
				String role = ndDao.getRole(username, password, "");
				if(role.equals("User"))
				{					
					session.setAttribute("nguoiDung", ndDao.getByAccount(username, password));
					session.setAttribute("role", "User");
					session.setAttribute("msg", "Đăng nhập thành công");
					session.setAttribute("typeMess", "success");
					response.sendRedirect(request.getContextPath() + "/TrangChuServlet");
					return;
				}
				else {
					session.setAttribute("nguoiDung", ndDao.getByAccount(username, password));
					session.setAttribute("role", "Admin");
					session.setAttribute("msg", "Đăng nhập thành công");
					session.setAttribute("typeMess", "success");
					response.sendRedirect(request.getContextPath() + "/DashBoardServlet");
					return;
				}
				
			}
			else 
			{
				session.setAttribute("msg", "Đăng nhập thất bại");
				session.setAttribute("typeMess", "error");
				request.getRequestDispatcher("/views/template/login.jsp").forward(request, response);
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
