package models;

public class NguyenLieu {
	private String maNL;
	private String tenNL;
	private int soLuongTonKho;
	private String maDV;
	
	private String tenDV;
	
	public NguyenLieu() {
		
	}
	
	public NguyenLieu(String maNL, String tenNL, int soLuongTonKho, String maDV) { // Table NguyenLieu
		this.maNL = maNL;
		this.tenNL = tenNL;
		this.soLuongTonKho = soLuongTonKho;
		this.maDV = maDV;
	}
	
	public NguyenLieu(String maNL, String tenNL, int soLuongTonKho, String  maDV, String tenDV) { // Table NguyenLieu join DonVi
		this.maNL = maNL;
		this.tenNL = tenNL;
		this.soLuongTonKho = soLuongTonKho; 
		this.maDV = maDV;
		this.tenDV = tenDV;
	}
	
	
	
	public String getMaNL() {
		return maNL;
	}
	public void setMaNL(String maNL) {
		this.maNL = maNL;
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
	public String getMaDV() {
		return maDV;
	}
	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}
	public String getTenDV() {
		return tenDV;
	}
	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	} 
	
	
	
}
