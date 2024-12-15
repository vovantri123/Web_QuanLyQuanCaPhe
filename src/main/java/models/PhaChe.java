package models;

public class PhaChe {
	private String maSP;
	private String maNL;
	private int soLuong;
	
	private String tenSP;
	private String tenNL;
	private int soLuongTonKho;
	
	public PhaChe() {
		
	}
	public PhaChe(String maSP, String maNL, int soLuong) { //Table PhaChe
		super();
		this.maSP = maSP;
		this.maNL = maNL;
		this.soLuong = soLuong;
	}
	  
	public PhaChe(String maSP, String maNL, int soLuong, String tenSP, String tenNL, int soLuongTonKho) { //Table PhaChe join NguyenLieu và SanPham
		this.maSP = maSP;
		this.maNL = maNL;
		this.soLuong = soLuong;
		this.tenSP = tenSP;
		this.tenNL = tenNL;
		this.soLuongTonKho = soLuongTonKho;
	}
	
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getMaNL() {
		return maNL;
	}
	public void setMaNL(String maNL) {
		this.maNL = maNL;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getTenNL() {
		return tenNL;
	}
	public void setTenNL(String tenNL) {
		this.tenNL = tenNL;
	}
	public int getSoLuongTonKho() {
		return soLuongTonKho;
	}
	public void setSoLuongTonKho(int soLuongTonKho) {
		this.soLuongTonKho = soLuongTonKho;
	}
	
	
}
