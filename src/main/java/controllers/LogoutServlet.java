package controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	  HttpSession session = request.getSession(false);

          if (session != null) {
              session.invalidate(); // Xóa toàn bộ session hiện tại
          }
          Cookie[] cookies = request.getCookies();
          if (cookies != null) {
              for (Cookie cookie : cookies) {
                  cookie.setMaxAge(0); // Đặt thời gian sống của cookie là 0 để xóa
                  cookie.setPath("/"); // Đặt path để cookie có thể xóa toàn bộ
                  response.addCookie(cookie); // Thêm cookie đã xóa vào response
              }
          }

          // Chuyển hướng về trang chủ
          response.sendRedirect(request.getContextPath() + "/DangNhapServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
