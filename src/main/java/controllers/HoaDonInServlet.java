package controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.List;

import daos.ChiTietHoaDonDao;
import daos.DonHangDao;
import daos.GioHangDao;
import daos.KhuVucDao;
import daos.PhuongThucThanhToanDao;
import daos.ThanhToanDao;
import daos.VoucherDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.ChiTietHoaDon;
import models.DonHang;
import models.GioHang;
import models.KhuVuc;
import models.NguoiDung;
import models.PhuongThucThanhToan;
import models.ThanhToan;
import models.Voucher;

/**
 * Servlet implementation class HoaDonInServlet
 */
@WebServlet("/HoaDonInServlet")
public class HoaDonInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HoaDonInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		NguoiDung nd = (NguoiDung) session.getAttribute("nguoiDung"); // Mã người dùng

		// Thêm đơn hàng vào db
		GioHangDao ghDao = new GioHangDao();
        DonHangDao dhDao = new DonHangDao();
        ThanhToanDao ttDao = new ThanhToanDao();    
        ChiTietHoaDonDao ctDao = new ChiTietHoaDonDao();
        KhuVucDao kvDao = new KhuVucDao();
        VoucherDao vcDao = new VoucherDao();
        PhuongThucThanhToanDao ptttDao = new PhuongThucThanhToanDao();
        
        String maDH = dhDao.generateMaDH(); // Tạo mã đơn hàng
        List<GioHang> cart = ghDao.getById(nd.getMaND()); // Lấy danh sách giỏ hàng
        
        String maGG = (String) session.getAttribute("maGiamGia");
        String maKV = (String) session.getAttribute("maKV");
        String maPTTT = (String) session.getAttribute("maPTTT");
        DecimalFormat df = new DecimalFormat("#");
        
        
        String amountStr = request.getParameter("tongTien");
        float amount = 0;
        if (amountStr != null && !amountStr.trim().isEmpty()) {
            amount = Float.parseFloat(amountStr);
        } else {
            // Xử lý lỗi nếu "thanhTien" không hợp lệ
            amount = 0; // Hoặc ném ngoại lệ hoặc thông báo lỗi cho người dùng
        }
        
        Date ngayHT = new Date(System.currentTimeMillis()); // Ngày hiện tại
        

                       
        // Lưu thông tin đơn hàng vào database
        DonHang dh = new DonHang(maDH, amount, ngayHT , "Đang giao", maKV, maGG);
        dhDao.insert(dh);
        
        // Lưu thông tin thanh toán vào database
        ThanhToan tt = new ThanhToan(nd.getMaND(), maDH, maPTTT);                       
        ttDao.insert(tt);
        
        request.setAttribute("cart", cart);
        // Thêm từng sản phẩm trong giỏ hàng vào chi tiết hóa đơn
        for (GioHang gh : cart) {
            ctDao.insert(new ChiTietHoaDon(maDH, gh.getMaSP(), gh.getSoLuong(), gh.getSoLuong() * gh.getGiaSP()));
        }
        
        // Gửi thông tin
        KhuVuc kv = kvDao.getById(maKV);
        PhuongThucThanhToan pttt = ptttDao.getById(maPTTT);
        request.setAttribute("tenKV", kv.getTenKV());
        request.setAttribute("phiVanChuyen", kv.getPhiVanChuyen());
        request.setAttribute("tenPTTT", pttt.getTenPTTT());
        request.setAttribute("maDH", maDH);
        request.setAttribute("ngayHT", ngayHT);
        
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String soDT = request.getParameter("soDT");
        String thanhTien = request.getParameter("thanhTien");
        
        // Set giá trị để gửi sang JSP
        request.setAttribute("ten", ten);
        request.setAttribute("diaChi", diaChi);
        request.setAttribute("soDT", soDT);
        request.setAttribute("thanhTien", thanhTien);
        
        // Lấy phí vận chuyển và mã giảm giá
        Voucher vc = vcDao.getById(maGG);
        if (vc != null) {
            request.setAttribute("giamGia", vc.getGiaTriVC());
        } else {
            request.setAttribute("giamGia", "0"); // Nếu không có voucher, giảm giá bằng 0
        }
	    
	    // Forward to the JSP for display
	    request.getRequestDispatcher("/views/template/hoadon.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
