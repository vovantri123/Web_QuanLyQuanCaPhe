package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.DanhGia;
import models.NguoiDung;

import java.io.IOException;

import daos.DanhGiaDao;

/**
 * Servlet implementation class DanhGiaServlet
 */
@WebServlet("/DanhGiaServlet")
public class DanhGiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhGiaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DanhGiaDao dgDao = new DanhGiaDao(); 
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		NguoiDung nd = (NguoiDung) session.getAttribute("nguoiDung");	
		String id = (String) session.getAttribute("id");
		String idLoaiSp = (String) session.getAttribute("idLoaiSp");
		String maNDHT = request.getParameter("idNguoiDungHT");
		if(action.equals("gui"))
		{
			String soSao = request.getParameter("rating");
			String danhGia = request.getParameter("comment");
			int sao = Integer.parseInt(soSao);
			DanhGia dGia = new DanhGia(nd.getMaND(),id,sao,danhGia);
			if(!nd.getMaND().equals(maNDHT))
			{
				System.out.println(maNDHT);
				if(dgDao.insert(dGia))
				{
					response.sendRedirect(request.getContextPath() + "/ChiTietSanPhamServlet?id="+id+"&type="+idLoaiSp);
				}
				else {
					response.sendRedirect(request.getContextPath() + "/ChiTietSanPhamServlet?id="+id+"&type="+idLoaiSp);
				}
			}
			else {
				if(dgDao.update(dGia))
				{
					response.sendRedirect(request.getContextPath() + "/ChiTietSanPhamServlet?id="+id+"&type="+idLoaiSp);
				}
				else {
					response.sendRedirect(request.getContextPath() + "/ChiTietSanPhamServlet?id="+id+"&type="+idLoaiSp);
				}
			}
			
		}
		else if(action.equals("delete"))
		{
			String idND = request.getParameter("id");
			if(dgDao.delete(idND))
			{
				response.sendRedirect(request.getContextPath() + "/ChiTietSanPhamServlet?id="+id+"&type="+idLoaiSp);
			}
			else {
				response.sendRedirect(request.getContextPath() + "/ChiTietSanPhamServlet?id="+id+"&type="+idLoaiSp);
			}
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
