package controllers;

import java.io.IOException;
import java.sql.Date;

import daos.VoucherDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Voucher; 

/**
 * Servlet implementation class VoucherServlet
 */

@WebServlet("/VoucherServlet")
public class VoucherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public VoucherServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        VoucherDao vcDao = new VoucherDao();
        String action = request.getParameter("action"); 
        
        if (action == null) {
            request.setAttribute("voucherList", vcDao.getAll());
            request.getRequestDispatcher("/views/template/admin.jsp?page=voucherTable").forward(request, response);
        } else if (action.equals("search")) {
            String tenVoucher = request.getParameter("txtSearchTenVoucher");
            request.setAttribute("voucherList", vcDao.searchByName(tenVoucher));
            request.getRequestDispatcher("/views/template/admin.jsp?page=voucherTable").forward(request, response); 
        } else if (action.equals("add")) {  
            request.getRequestDispatcher("/views/template/admin.jsp?page=voucherAdd").forward(request, response);
        } else if (action.equals("edit")) {
            String maVC = request.getParameter("maVC");
            request.setAttribute("voucher", vcDao.getByIdToUpdate(maVC)); 
            request.getRequestDispatcher("/views/template/admin.jsp?page=voucherEdit").forward(request, response);
        } else if (action.equals("insert") || action.equals("update")) {
            String maVC = request.getParameter("maVC");
            String tenVC = request.getParameter("tenVC");
            float giaTriVC = Float.parseFloat(request.getParameter("giaTriVC"));
            int soLuotSuDungToiDa = Integer.parseInt(request.getParameter("soLuotSuDungToiDa"));
            int soLuotDaSuDung = Integer.parseInt(request.getParameter("soLuotDaSuDung"));
            Date ngayBatDau = Date.valueOf(request.getParameter("ngayBatDau"));
            Date ngayKetThuc = Date.valueOf(request.getParameter("ngayKetThuc"));
            String trangThai = request.getParameter("trangThai");

            Voucher newVoucher = new Voucher(maVC, tenVC, giaTriVC, soLuotSuDungToiDa, soLuotDaSuDung, ngayBatDau, ngayKetThuc, trangThai);

            if (action.equals("insert")) {
                if (vcDao.insert(newVoucher)) {
                    request.setAttribute("msg", "Thêm thành công");
                } else {
                    request.setAttribute("msg", "Thêm không thành công");
                }
            } else {
                if (vcDao.update(newVoucher)) {
                    request.setAttribute("msg", "Sửa thành công");
                } else {
                    request.setAttribute("msg", "Sửa không thành công");
                }
            }
            request.setAttribute("voucherList", vcDao.getAll());
            request.getRequestDispatcher("/views/template/admin.jsp?page=voucherTable").forward(request, response);
        } else if (action.equals("delete")) {
            String maVC = request.getParameter("maVC");
            if (vcDao.delete(maVC)) {
                request.setAttribute("msg", "Xóa thành công");
            } else {
                request.setAttribute("msg", "Xóa không thành công");
            }
            request.setAttribute("voucherList", vcDao.getAll());
            request.getRequestDispatcher("/views/template/admin.jsp?page=voucherTable").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	
    	doGet(request, response);
    }
}
