package models;

public class ChiTietHoaDon {
	private String maDH;
	private String maSP;
	private int soLuong;
	private float tongTien;
	
	private String tenSP;
	private float gia;
	
	public ChiTietHoaDon() {
		
	}
	
	public ChiTietHoaDon(String maDH, String maSP, int soLuong, float tongTien) { //Table ChiTietHoaDon
		super();
		this.maDH = maDH;
		this.maSP = maSP;
		this.soLuong = soLuong;
		this.tongTien = tongTien;
	}
	 
	public ChiTietHoaDon(String maDH, String maSP, int soLuong, float tongTien, String tenSP, float gia) { //Table ChiTietHoaDon join SanPham (dùng cho cái bill)
		this.maDH = maDH;
		this.maSP = maSP;
		this.soLuong = soLuong;
		this.tongTien = tongTien;
		this.tenSP = tenSP;
		this.gia = gia;
	}

	public String getMaDH() {
		return maDH;
	}
	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public float getTongTien() {
		return tongTien;
	}
	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}
	
}
