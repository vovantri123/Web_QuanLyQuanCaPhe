package models;

import java.sql.Date;

public class Voucher {
	private String maVC;
	private String tenVC;
	private float giaTriVC;
	private int soLuotSuDungToiDa;
	private int soLuotDaSuDung;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	private String trangThai;
	public Voucher() {
		
	}
	public Voucher(String maVC, String tenVC, float giaTriVC, int soLuotSuDungToiDa, int soLuotDaSuDung,
			Date ngayBatDau, Date ngayKetThuc, String trangThai) {
		super();
		this.maVC = maVC;
		this.tenVC = tenVC;
		this.giaTriVC = giaTriVC;
		this.soLuotSuDungToiDa = soLuotSuDungToiDa;
		this.soLuotDaSuDung = soLuotDaSuDung;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.trangThai = trangThai;
	}
	public String getMaVC() {
		return maVC;
	}
	public void setMaVC(String maVC) {
		this.maVC = maVC;
	}
	public String getTenVC() {
		return tenVC;
	}
	public void setTenVC(String tenVC) {
		this.tenVC = tenVC;
	}
	public float getGiaTriVC() {
		return giaTriVC;
	}
	public void setGiaTriVC(float giaTriVC) {
		this.giaTriVC = giaTriVC;
	}
	public int getSoLuotSuDungToiDa() {
		return soLuotSuDungToiDa;
	}
	public void setSoLuotSuDungToiDa(int soLuotSuDungToiDa) {
		this.soLuotSuDungToiDa = soLuotSuDungToiDa;
	}
	public int getSoLuotDaSuDung() {
		return soLuotDaSuDung;
	}
	public void setSoLuotDaSuDung(int soLuotDaSuDung) {
		this.soLuotDaSuDung = soLuotDaSuDung;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
}
