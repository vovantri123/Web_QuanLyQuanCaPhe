package controllers;

import java.io.IOException;

import daos.DonViDao;
import daos.NguyenLieuDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.NguyenLieu;

/**
 * Servlet implementation class NguyenLieuServlet
 */

@WebServlet("/NguyenLieuServlet")
public class NguyenLieuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NguyenLieuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        NguyenLieuDao nlDao = new NguyenLieuDao();
        DonViDao dvDao = new DonViDao();
        String action = request.getParameter("action"); 
        
        if (action == null) {
            request.setAttribute("nguyenLieuList", nlDao.getAll());
            request.getRequestDispatcher("/views/template/admin.jsp?page=nguyenLieuTable").forward(request, response);
        } else if (action.equals("search")) {
            String tenNL = request.getParameter("txtSearchTenNguyenLieu"); 
            request.setAttribute("nguyenLieuList", nlDao.searchByName(tenNL));
            request.getRequestDispatcher("/views/template/admin.jsp?page=nguyenLieuTable").forward(request, response); 
        } else if (action.equals("add")) {  
        	request.setAttribute("donViList", dvDao.getAll());
            request.getRequestDispatcher("/views/template/admin.jsp?page=nguyenLieuAdd").forward(request, response);
        } else if (action.equals("edit")) {
            String maNL = request.getParameter("maNL");
            request.setAttribute("nguyenLieu", nlDao.getById(maNL));  
            request.setAttribute("donViList", dvDao.getAll());
            request.getRequestDispatcher("/views/template/admin.jsp?page=nguyenLieuEdit").forward(request, response);
        } else if (action.equals("insert") || action.equals("update")) { 
        	// public NguyenLieu(String maNL, String tenNL, int soLuongTonKho, String maDV) { // Table NguyenLieu
        	String maNL = request.getParameter("maNL");
        	String tenNL = request.getParameter("tenNL");
        	int soLuongTonKho = Integer.parseInt(request.getParameter("soLuongTonKho")); 
        	String maDV = request.getParameter("maDV");  
        	
        	NguyenLieu newNguyenLieu = new NguyenLieu(maNL, tenNL, soLuongTonKho, maDV); 
        	
        	if (action.equals("insert")) {
                if (nlDao.insert(newNguyenLieu)) {
                    request.setAttribute("msg", "Thêm thành công");
                } else {
                    request.setAttribute("msg", "Thêm không thành công");
                }
            } else {
                if (nlDao.update(newNguyenLieu)) {
                    request.setAttribute("msg", "Sửa thành công");
                } else {
                    request.setAttribute("msg", "Sửa không thành công");
                }
            }
        	
        	request.setAttribute("nguyenLieuList", nlDao.getAll());
            request.getRequestDispatcher("/views/template/admin.jsp?page=nguyenLieuTable").forward(request, response);
        } else if (action.equals("delete")) {
        	String maNL = request.getParameter("maNL");
            if (nlDao.delete(maNL)) {
                request.setAttribute("msg", "Xóa thành công");
            } else {
                request.setAttribute("msg", "Xóa không thành công");
            }
            request.setAttribute("nguyenLieuList", nlDao.getAll());
            request.getRequestDispatcher("/views/template/admin.jsp?page=nguyenLieuTable").forward(request, response);
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
