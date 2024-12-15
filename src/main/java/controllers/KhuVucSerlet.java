package controllers;

import java.io.IOException;

import daos.KhuVucDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.KhuVuc;

/**
 * Servlet implementation class KhuVucSerlet
 */

@WebServlet("/KhuVucServlet")
public class KhuVucSerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhuVucSerlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        KhuVucDao kvDao = new KhuVucDao();
        String action = request.getParameter("action"); 
        
        if (action == null) {
            request.setAttribute("khuVucList", kvDao.getAll());
            request.getRequestDispatcher("/views/template/admin.jsp?page=khuVucTable").forward(request, response);
        } else if (action.equals("search")) {
            String tenKV = request.getParameter("txtSearchTenKhuVuc"); 
            request.setAttribute("khuVucList", kvDao.searchByName(tenKV));
            request.getRequestDispatcher("/views/template/admin.jsp?page=khuVucTable").forward(request, response); 
        } else if (action.equals("add")) {  
            request.getRequestDispatcher("/views/template/admin.jsp?page=khuVucAdd").forward(request, response);
        } else if (action.equals("edit")) {
            String maKV = request.getParameter("maKV");
            request.setAttribute("khuVuc", kvDao.getById(maKV));   
            request.getRequestDispatcher("/views/template/admin.jsp?page=khuVucEdit").forward(request, response);
        } else if (action.equals("insert") || action.equals("update")) { 
        	// public KhuVuc(String maKV, String tenKV, float phiVanChuyen) 
        	String maKV = request.getParameter("maKV");
        	String tenKV = request.getParameter("tenKV");
        	float phiVanChuyen = Float.parseFloat(request.getParameter("phiVanChuyen"));  
        	KhuVuc newKhuVuc = new KhuVuc(maKV, tenKV, phiVanChuyen); 
        	
        	if (action.equals("insert")) {
                if (kvDao.insert(newKhuVuc)) {
                    request.setAttribute("msg", "Thêm thành công");
                } else {
                    request.setAttribute("msg", "Thêm không thành công");
                }
            } else {
                if (kvDao.update(newKhuVuc)) {
                    request.setAttribute("msg", "Sửa thành công");
                } else {
                    request.setAttribute("msg", "Sửa không thành công");
                }
            }
        	
        	request.setAttribute("khuVucList", kvDao.getAll());
            request.getRequestDispatcher("/views/template/admin.jsp?page=khuVucTable").forward(request, response);
        } else if (action.equals("delete")) {
        	String maKV = request.getParameter("maKV");
            if (kvDao.delete(maKV)) {
                request.setAttribute("msg", "Xóa thành công");
            } else {
                request.setAttribute("msg", "Xóa không thành công");
            }
            request.setAttribute("khuVucList", kvDao.getAll());
            request.getRequestDispatcher("/views/template/admin.jsp?page=khuVucTable").forward(request, response);
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
