package controllers;

import java.io.IOException;
import java.sql.Date;  // Đảm bảo import đúng lớp java.sql.Date

import daos.DonHangDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.NguoiDung;

/**
 * Servlet implementation class DonHangServlet
 */

@WebServlet("/DonHangServlet")
public class DonHangServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public DonHangServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        NguoiDung nd = (NguoiDung) session.getAttribute("nguoiDung");
        DonHangDao dhDao = new DonHangDao();

        String action = request.getParameter("action");
        if (action == null) {
            handleStatusUpdates(request, dhDao);
            handleDataFetching(request, nd, dhDao);
            forwardToPage(request, response, nd);
        }
    }

    private void handleStatusUpdates(HttpServletRequest request, DonHangDao dhDao) {
        String maDH = request.getParameter("maDH");
        String suaTT = request.getParameter("suaTT");
        String huyTT = request.getParameter("huyTT");

        if ("edit".equals(suaTT)) {
            dhDao.updateTrangThai("Đã giao", maDH);
        }
        if ("edit".equals(huyTT)) {
            dhDao.updateTrangThai("Đã hủy", maDH);
        }
    }

    private void handleDataFetching(HttpServletRequest request, NguoiDung nd, DonHangDao dhDao) {
        String trangThai = request.getParameter("trangThai");
        String fromDateStr = request.getParameter("fromDate");
        String toDateStr = request.getParameter("toDate");

        try {
            if (isNotEmpty(fromDateStr) && isNotEmpty(toDateStr)) {
                Date fromDate = Date.valueOf(fromDateStr);
                Date toDate = Date.valueOf(toDateStr);
                setDonHangListByRange(request, nd, dhDao, fromDate, toDate, trangThai);
            } else if (isNotEmpty(trangThai)) {
                setDonHangListByRange(request, nd, dhDao, null, null, trangThai);
            } else {
                setDonHangListAll(request, nd, dhDao);
            }
        } catch (IllegalArgumentException e) {
            request.setAttribute("errorMessage", "Định dạng ngày không hợp lệ.");
        }
    }

    private void setDonHangListByRange(HttpServletRequest request, NguoiDung nd, DonHangDao dhDao, Date fromDate, Date toDate, String trangThai) {
        if (!"ND01".equals(nd.getMaND())) {
            request.setAttribute("donHangList", dhDao.getByRange(fromDate, toDate, nd.getMaND(), trangThai));
        } else {
            request.setAttribute("donHangList", dhDao.getByRange(fromDate, toDate, null, trangThai));
        }
    }

    private void setDonHangListAll(HttpServletRequest request, NguoiDung nd, DonHangDao dhDao) {
        if (!"ND01".equals(nd.getMaND())) {
            request.setAttribute("donHangList", dhDao.getByNDId(nd.getMaND()));
        } else {
            request.setAttribute("donHangList", dhDao.getAll());
        }
    }

    private void forwardToPage(HttpServletRequest request, HttpServletResponse response, NguoiDung nd) throws ServletException, IOException {
        if (!"ND01".equals(nd.getMaND())) {
            request.getRequestDispatcher("/views/template/quanlyhoadon.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/views/template/admin.jsp?page=donHangTable").forward(request, response);
        }
    }

    private boolean isNotEmpty(String str) {
        return str != null && !str.isEmpty();
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
