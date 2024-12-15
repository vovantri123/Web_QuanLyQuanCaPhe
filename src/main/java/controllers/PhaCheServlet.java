package controllers;

import java.io.IOException;

import daos.NguyenLieuDao;
import daos.PhaCheDao;
import daos.SanPhamDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.PhaChe;

/**
 * Servlet implementation class PhaCheServlet
 */

@WebServlet("/PhaCheServlet")
public class PhaCheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhaCheServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		NguyenLieuDao nlDao = new NguyenLieuDao();
        SanPhamDao spDao = new SanPhamDao();
        PhaCheDao pcDao = new PhaCheDao();
        String action = request.getParameter("action");
        
        if(action == null) { 
        	String maSP = request.getParameter("maSP");
        	String tenSP = request.getParameter("tenSP");
        	request.setAttribute("maSP", maSP);
        	request.setAttribute("tenSP", tenSP); 
        	request.setAttribute("nguyenLieuList", nlDao.getAll());
        	
        	request.setAttribute("phaCheList", pcDao.getByMaSP(maSP));
        	
        	request.getRequestDispatcher("/views/template/admin.jsp?page=sanPhamPhaChe").forward(request, response);
        } else if (action.equals("insert")) { 
        	// public PhaChe(String maSP, String maNL, int soLuong)
        	String maSP = request.getParameter("maSP");
        	String maNL = request.getParameter("maNL"); 
        	int soLuong = Integer.parseInt(request.getParameter("soLuong")); 
        	
        	PhaChe newPhaChe = new PhaChe(maSP, maNL, soLuong); 
        	
        	if (pcDao.insert(newPhaChe)) {
                request.setAttribute("msg", "Thêm thành công");
            } else {
                request.setAttribute("msg", "Thêm không thành công");
            } 
        	
        	String tenSP = request.getParameter("tenSP");
        	request.setAttribute("maSP", maSP);
        	request.setAttribute("tenSP", tenSP);
        	request.setAttribute("nguyenLieuList", nlDao.getAll());
        	
        	request.setAttribute("phaCheList", pcDao.getByMaSP(maSP));
        	
        	request.getRequestDispatcher("/views/template/admin.jsp?page=sanPhamPhaChe").forward(request, response);
        } else if (action.equals("delete")) {
        	String maSP = request.getParameter("maSP");
        	String maNL = request.getParameter("maNL");
            if (pcDao.delete(maSP,maNL)) {
                request.setAttribute("msg", "Xóa thành công");
            } else {
                request.setAttribute("msg", "Xóa không thành công");
            }
             
        	String tenSP = request.getParameter("tenSP");
        	request.setAttribute("maSP", maSP);
        	request.setAttribute("tenSP", tenSP);
        	request.setAttribute("nguyenLieuList", nlDao.getAll());
        	
        	request.setAttribute("phaCheList", pcDao.getByMaSP(maSP));
        	
        	request.getRequestDispatcher("/views/template/admin.jsp?page=sanPhamPhaChe").forward(request, response);
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
