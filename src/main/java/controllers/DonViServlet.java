package controllers;

import java.io.IOException;

import daos.DonViDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.DonVi;

/**
 * Servlet implementation class DonViServlet
 */
@WebServlet("/DonViServlet")
public class DonViServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonViServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        DonViDao dvDao = new DonViDao();
        String action = request.getParameter("action"); 
        
        if (action == null) {
            request.setAttribute("donViList", dvDao.getAll());
            request.getRequestDispatcher("/views/template/admin.jsp?page=donViTable").forward(request, response);
        } else if (action.equals("add")) {  
            request.getRequestDispatcher("/views/template/admin.jsp?page=donViAdd").forward(request, response);
        } else if (action.equals("search")) {
            String tenDV = request.getParameter("txtSearchTenDonVi"); 
            request.setAttribute("donViList", dvDao.searchByName(tenDV));
            request.getRequestDispatcher("/views/template/admin.jsp?page=donViTable").forward(request, response); 
        } else if (action.equals("edit")) {
            String maDV = request.getParameter("maDV");
            request.setAttribute("donVi", dvDao.getById(maDV));
            request.getRequestDispatcher("/views/template/admin.jsp?page=donViEdit").forward(request, response);
        } else if (action.equals("insert") || action.equals("update")) {  
        	// public DonVi(String maDV, String tenDV)
        	String maDV = request.getParameter("maDV");
        	String tenDV = request.getParameter("tenDV"); 
        	
        	DonVi newDonVi = new DonVi(maDV, tenDV); 
        	if (action.equals("insert")) {
                if (dvDao.insert(newDonVi)) {
                    request.setAttribute("msg", "Thêm thành công");
                } else {
                    request.setAttribute("msg", "Thêm không thành công");
                }
            } else {
                if (dvDao.update(newDonVi)) {
                    request.setAttribute("msg", "Sửa thành công");
                } else {
                    request.setAttribute("msg", "Sửa không thành công");
                }
            }
        	
        	request.setAttribute("donViList", dvDao.getAll());
            request.getRequestDispatcher("/views/template/admin.jsp?page=donViTable").forward(request, response);
        } else if (action.equals("delete")) {
        	String maDV = request.getParameter("maDV");
            if (dvDao.delete(maDV)) {
                request.setAttribute("msg", "Xóa thành công");
            } else {
                request.setAttribute("msg", "Xóa không thành công");
            }
            request.setAttribute("donViList", dvDao.getAll());
            request.getRequestDispatcher("/views/template/admin.jsp?page=donViTable").forward(request, response);
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
