package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.LoaiSanPham;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import daos.LoaiSanPhamDao;
import daos.SanPhamDao;
import models.*;

/**
 * Servlet implementation class DanhMucSanPham
 */
@WebServlet("/DanhMucSanPham")
public class DanhMucSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhMucSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		SanPhamDao sanPhamDao = new SanPhamDao();
		LoaiSanPhamDao loaiSanPhamDao = new LoaiSanPhamDao();
		
		
		List<LoaiSanPham> listLoaiSanPham = new ArrayList<>();
		listLoaiSanPham = loaiSanPhamDao.getAll();
		request.setAttribute("listLoaiSP", loaiSanPhamDao.getAll());
		
		
		if (id == null || id.equals("0")) {
		    Map<String, List<SanPham>> allProductsByCategory = new HashMap<>();
		    for (LoaiSanPham loaiSanPham : listLoaiSanPham) {
		        List<SanPham> products = sanPhamDao.getSanPhamByLoaiSP(loaiSanPham.getMaLoaiSP());
		        if (!products.isEmpty()) {
		            allProductsByCategory.put(loaiSanPham.getMaLoaiSP(), products);
		        }
		    }
		    request.setAttribute("listToanBoSP", allProductsByCategory);
		} else {
		    request.setAttribute("listSanPham", sanPhamDao.getSanPhamByLoaiSP(id));
		}
		request.getRequestDispatcher("/views/template/danhmucSP.jsp").forward(request, response);

		
		
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
