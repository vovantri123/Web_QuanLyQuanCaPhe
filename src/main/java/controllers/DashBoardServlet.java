package controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import daos.ChiTietHoaDonDao;
import jakarta.mail.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class dashboardServlet
 */

@WebServlet("/DashBoardServlet")
public class DashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DashBoardServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		ChiTietHoaDonDao cthdDao = new ChiTietHoaDonDao();

		String action = request.getParameter("action");
		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("role").equals("Admin")) 
		{
			String msg = (String) session.getAttribute("msg");
			String typeMess = (String) session.getAttribute("typeMess");

			// Xử lý thông báo nếu có
			if (msg != null && typeMess != null) {
				request.setAttribute("msg", msg);
				request.setAttribute("typeMess", typeMess);
				// Sau khi xử lý, xóa thông báo khỏi session
				session.removeAttribute("msg");
				session.removeAttribute("typeMess");
			}
			if (action == null) {
				String startDateStr = request.getParameter("startDate");
				String endDateStr = request.getParameter("endDate");

				Date startDateSql;
				Date endDateSql;

				try {
					if (startDateStr == null || startDateStr.isEmpty()) {
						startDateSql = Date.valueOf("2024-11-01"); // Ngày bắt đầu mặc định
					} else {
						startDateSql = Date.valueOf(startDateStr);
					}

					if (endDateStr == null || endDateStr.isEmpty()) {
						endDateSql = new Date(System.currentTimeMillis()); // Ngày kết thúc là ngày hiện tại
					} else {
						endDateSql = Date.valueOf(endDateStr);
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					startDateSql = Date.valueOf("2024-11-02");
					endDateSql = new Date(System.currentTimeMillis());
				}
				float totalRevenue = cthdDao.getTongGiaTriDonHangByDateRange(startDateSql, endDateSql);
				int totalProducts = cthdDao.getTongSanPhamByDateRange(startDateSql, endDateSql);
				int totalCustomers = cthdDao.getTongKhachHangByDateRange(startDateSql, endDateSql);

				request.setAttribute("totalRevenue", totalRevenue);
				request.setAttribute("totalProducts", totalProducts);
				request.setAttribute("totalCustomers", totalCustomers);
				request.setAttribute("startDate", startDateSql.toString()); // Chuyển lại sang String khi cần hiển thị
				request.setAttribute("endDate", endDateSql.toString());

				List<Map<String, Object>> sanPhamVaSoLuong = cthdDao.getSanPhamVaTongSoLuongByDateRange(startDateSql,
						endDateSql);
				List<Map<String, Object>> sanPhamVaTongTien = cthdDao.getSanPhamVaTongTienByDateRange(startDateSql,
						endDateSql);
				List<Map<String, Object>> ngayMuaVaGiaTri = cthdDao.getNgayMuaVaGiaTriDHByDateRange(startDateSql,
						endDateSql);

				request.setAttribute("sanPhamVaSoLuong", sanPhamVaSoLuong);
				request.setAttribute("sanPhamVaTongTien", sanPhamVaTongTien);
				request.setAttribute("ngayMuaVaGiaTri", ngayMuaVaGiaTri);
			}

			// Chuyển tiếp đến trang dashboard
			request.getRequestDispatcher("/views/template/admin.jsp?page=dashboard").forward(request, response);
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
