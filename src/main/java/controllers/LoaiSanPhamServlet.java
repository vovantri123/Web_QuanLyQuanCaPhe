package controllers;

import java.io.IOException;

import daos.LoaiSanPhamDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.LoaiSanPham;
import utilities.XuLyAnh;

/**
 * Servlet implementation class LoaiSanPhamServlet
 */

@WebServlet("/LoaiSanPhamServlet")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	    maxFileSize = 1024 * 1024 * 10,      // 10MB
	    maxRequestSize = 1024 * 1024 * 50    // 50MB
	)
public class LoaiSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoaiSanPhamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        LoaiSanPhamDao lspDao = new LoaiSanPhamDao();
        String action = request.getParameter("action");  
        
        if (action == null) {
            request.setAttribute("loaiSanPhamList", lspDao.getAll());
            request.getRequestDispatcher("/views/template/admin.jsp?page=loaiSanPhamTable").forward(request, response);
        } else if (action.equals("search")) {
            String tenLoaiSP = request.getParameter("txtSearchTenLoaiSanPham"); 
            request.setAttribute("loaiSanPhamList", lspDao.searchByName(tenLoaiSP));
            request.getRequestDispatcher("/views/template/admin.jsp?page=loaiSanPhamTable").forward(request, response); 
        } else if (action.equals("add")) {  
            request.getRequestDispatcher("/views/template/admin.jsp?page=loaiSanPhamAdd").forward(request, response);
        } else if (action.equals("edit")) {
            String maLoaiSP = request.getParameter("maLoaiSP");
            request.setAttribute("loaiSanPham", lspDao.getById(maLoaiSP));   
            request.getRequestDispatcher("/views/template/admin.jsp?page=loaiSanPhamEdit").forward(request, response);
        } else if (action.equals("insert") || action.equals("update")) { 
        	System.out.println("213213");
        	//public LoaiSanPham(String maLoaiSP, String tenLoaiSP, String hinhLoaiSP)
        	
        	String maLoaiSP = request.getParameter("maLoaiSP");
        	String tenLoaiSP = request.getParameter("tenLoaiSP");
        	String hinhLoaiSP = request.getParameter("hinhLoaiSP");   
        	
        	System.out.println("Mã loại sản phẩm: " + maLoaiSP);
            System.out.println("Tên loại sản phẩm: " + tenLoaiSP);
            System.out.println("Hình loại sản phẩm: " + hinhLoaiSP);
        	
        	LoaiSanPham newLoaiSP = new LoaiSanPham(maLoaiSP, tenLoaiSP, hinhLoaiSP);
        	
        	XuLyAnh xuLyAnh = new XuLyAnh();
        	xuLyAnh.luuAnh(request,getServletContext(),"HinhSanPham"); 
        	
        	
        	
        	if (action.equals("insert")) {
                if (lspDao.insert(newLoaiSP)) {
                    request.setAttribute("msg", "Thêm thành công");
                } else {
                    request.setAttribute("msg", "Thêm không thành công");
                }
            } else {
                if (lspDao.update(newLoaiSP)) {
                    request.setAttribute("msg", "Sửa thành công");
                } else {
                    request.setAttribute("msg", "Sửa không thành công");
                }
            }
        	
        	request.setAttribute("loaiSanPhamList", lspDao.getAll());
            request.getRequestDispatcher("/views/template/admin.jsp?page=loaiSanPhamTable").forward(request, response);
        } else if (action.equals("delete")) {
        	String maLoaiSP = request.getParameter("maLoaiSP");
            if (lspDao.delete(maLoaiSP)) {
                request.setAttribute("msg", "Xóa thành công");
            } else {
                request.setAttribute("msg", "Xóa không thành công");
            }
            request.setAttribute("loaiSanPhamList", lspDao.getAll());
            request.getRequestDispatcher("/views/template/admin.jsp?page=loaiSanPhamTable").forward(request, response);
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
