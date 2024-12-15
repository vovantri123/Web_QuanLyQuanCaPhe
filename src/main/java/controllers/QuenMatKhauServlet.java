package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.NguoiDung;
import utilities.ResetAccount;

import java.io.IOException;

import daos.NguoiDungDao;

/**
 * Servlet implementation class QuenMatKhauServlet
 */
@WebServlet("/QuenMatKhauServlet")
public class QuenMatKhauServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuenMatKhauServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		NguoiDungDao ndDao = new NguoiDungDao();
		String action = request.getParameter("action");
		if (action == null) {
			request.getRequestDispatcher("/views/template/quenMatKhauContent/quenMatKhau.jsp").forward(request,
					response);
		} else if (action.equals("forget")) {
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			// Generate OTP
			if (ndDao.checkMail(email, username)) {
				String otp = ResetAccount.generateOTP();
				request.getSession().setAttribute("otp", otp);
				request.getSession().setAttribute("email", email);
				request.getSession().setAttribute("username", username);

				// Send OTP via email
				boolean isSent = ResetAccount.sendEmail(email, otp);

				if (isSent) {
					request.setAttribute("msg", "Gửi thành công");
					request.setAttribute("typeMess", "success");
					request.getRequestDispatcher("/views/template/quenMatKhauContent/xacNhanOTP.jsp").forward(request,
							response);
				} else {
					request.setAttribute("msg", "Gửi thất bại");
					request.setAttribute("typeMess", "error");
					request.getRequestDispatcher("/views/template/quenMatKhauContent/quenMatKhau.jsp").forward(request,
							response);
				}
			} else {
				request.setAttribute("msg", "Email của bạn không tồn tại!");
				request.setAttribute("typeMess", "error");
				request.getRequestDispatcher("/views/template/quenMatKhauContent/quenMatKhau.jsp").forward(request,
						response);
			}

		} else if (action.equals("confirm")) {
			String otp = request.getParameter("otp");
			String sessionOtp = (String) request.getSession().getAttribute("otp");
			String sessionEmail = (String) request.getSession().getAttribute("email");
			if (otp.equals(sessionOtp)) {
				request.setAttribute("msg", "OTP xác nhận thành công cho email: " + sessionEmail);
				request.setAttribute("typeMess", "success");
				request.getRequestDispatcher("/views/template/quenMatKhauContent/resetMatKhau.jsp").forward(request,
						response);
			} else {
				request.setAttribute("msg", "OTP xác nhận thất bại!");
				request.setAttribute("typeMess", "error");
				request.getRequestDispatcher("/views/template/quenMatKhauContent/xacNhanOTP.jsp").forward(request,
						response);
			}
		} else if (action.equals("reset")) {
			HttpSession session = request.getSession();
			String email = (String) session.getAttribute("email");
			String username = (String) session.getAttribute("username");
			String newPass = request.getParameter("new-password");
			String confirmPass = request.getParameter("confirm-password");
			
			if(newPass.equals(confirmPass))
			{
				if(ndDao.updatePassword(newPass, email, username))
				{
					request.setAttribute("msg", "Đổi mật khẩu thành công");
					request.setAttribute("typeMess", "success");
					request.getRequestDispatcher("/views/template/login.jsp").forward(request,
							response);
				}
				else {
					request.setAttribute("msg", "Đổi mật khẩu thất bại");
					request.setAttribute("typeMess", "error");
					request.getRequestDispatcher("/views/template/quenMatKhauContent/resetMatKhau.jsp").forward(request,
							response);
				}
			}
			else {
				request.setAttribute("msg", "Mật khẩu của bạn không khớp");
				request.setAttribute("typeMess", "error");
				request.getRequestDispatcher("/views/template/quenMatKhauContent/resetMatKhau.jsp").forward(request,
						response);
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
