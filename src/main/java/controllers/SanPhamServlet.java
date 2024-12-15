package controllers;

import java.io.IOException;

import daos.LoaiSanPhamDao;
import daos.NguyenLieuDao;
import daos.SanPhamDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.SanPham;
import utilities.XuLyAnh;

/**
 * Servlet implementation class SanPhamServlet
 */

@WebServlet("/SanPhamServlet")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	    maxFileSize = 1024 * 1024 * 10,      // 10MB
	    maxRequestSize = 1024 * 1024 * 50    // 50MB
	)
public class SanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SanPhamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		LoaiSanPhamDao lspDao = new LoaiSanPhamDao();
		NguyenLieuDao nlDao = new NguyenLieuDao();
        SanPhamDao spDao = new SanPhamDao();
        String action = request.getParameter("action"); 
        
        if (action == null) {
            request.setAttribute("sanPhamList", spDao.getAll());
            request.setAttribute("loaiSPList", lspDao.getAll()); 
            request.getRequestDispatcher("/views/template/admin.jsp?page=sanPhamTable").forward(request, response);
        } else if (action.equals("filter")) { 
        	String option = request.getParameter("filterOption");
        	if(option.equals("default")) { 
        		 request.setAttribute("sanPhamList", spDao.getAll());
                 request.setAttribute("loaiSPList", lspDao.getAll());
                 request.getRequestDispatcher("/views/template/admin.jsp?page=sanPhamTable").forward(request, response);
        	} else { 
        		request.setAttribute("sanPhamList", spDao.searchByMaLoaiSP(option));
                request.setAttribute("loaiSPList", lspDao.getAll());
        		request.getRequestDispatcher("/views/template/admin.jsp?page=sanPhamTable").forward(request, response);
        	} 
        } else if (action.equals("add")) {  
        	request.setAttribute("loaiSPList", lspDao.getAll());  
            request.getRequestDispatcher("/views/template/admin.jsp?page=sanPhamAdd").forward(request, response);
        } else if (action.equals("edit")) {
            String maSP = request.getParameter("maSP");
            request.setAttribute("sanPham", spDao.getById(maSP));
            request.setAttribute("loaiSPList", lspDao.getAll());   
            request.getRequestDispatcher("/views/template/admin.jsp?page=sanPhamEdit").forward(request, response);
        } else if (action.equals("insert") || action.equals("update")) { 
        	// public SanPham(String maSP, String tenSP, float giaSP, String anhSP, String maLoaiSP, String moTaSP) { //Table SanPham
        	String maSP = request.getParameter("maSP");
        	String tenSP = request.getParameter("tenSP");
        	float giaSP = Float.parseFloat(request.getParameter("giaSP"));
        	String anhSP = request.getParameter("anhSP");
        	String maLoaiSP = request.getParameter("maLoaiSP");
        	String moTaSP = request.getParameter("moTaSP");
        	
        	SanPham newSanPham= new SanPham(maSP, tenSP, giaSP, anhSP, maLoaiSP, moTaSP);
        	XuLyAnh xuLyAnh = new XuLyAnh();
        	xuLyAnh.luuAnh(request,getServletContext(),"HinhSanPham"); 
        	
        	if (action.equals("insert")) {
                if (spDao.insert(newSanPham)) {
                    request.setAttribute("msg", "Thêm thành công");
                } else {
                    request.setAttribute("msg", "Thêm không thành công");
                }
            } else {
                if (spDao.update(newSanPham)) {
                    request.setAttribute("msg", "Sửa thành công");
                } else {
                    request.setAttribute("msg", "Sửa không thành công");
                }
            }
        	
        	request.setAttribute("loaiSPList", lspDao.getAll());
        	request.setAttribute("sanPhamList", spDao.getAll());
            request.getRequestDispatcher("/views/template/admin.jsp?page=sanPhamTable").forward(request, response);
        } else if (action.equals("delete")) {
        	String maSP = request.getParameter("maSP");
            if (spDao.delete(maSP)) {
                request.setAttribute("msg", "Xóa thành công");
            } else {
                request.setAttribute("msg", "Xóa không thành công");
            }
            request.setAttribute("loaiSPList", lspDao.getAll());
            request.setAttribute("sanPhamList", spDao.getAll());
            request.getRequestDispatcher("/views/template/admin.jsp?page=sanPhamTable").forward(request, response);
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
