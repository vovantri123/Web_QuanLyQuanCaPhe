package models;

import java.text.DecimalFormat;

public class GioHang {
	private String maND;
	private String maSP;
	private int soLuong;
	
	private String tenSP;
	private float giaSP;
	
	public GioHang() {
		
	}
	public GioHang(String maND, String maSP, int soLuong, String tenSP, float giaSP) {
		super();
		this.maND = maND;
		this.maSP = maSP;
		this.soLuong = soLuong;
		this.tenSP = tenSP;
		this.giaSP = giaSP;
	}
	public GioHang(String maND, String maSP, int soLuong) {
		super();
		this.maND = maND;
		this.maSP = maSP;
		this.soLuong = soLuong;
	}
	public String getMaND() {
		return maND;
	}
	public void setMaND(String maND) {
		this.maND = maND;
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

	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public float getGiaSP() {
		return giaSP;
	}
	public void setGiaSP(float giaSP) {
		this.giaSP = giaSP;
	}
}
