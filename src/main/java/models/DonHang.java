package models;

import java.sql.Date;

public class DonHang {
	private String maDH;
	private float giaTriDH;
	private Date ngayMua;
	private String trangThai;
	private String maKV;
	private String maVC;
	
	private String tenKV;
	public DonHang() {
		
	}
	public DonHang(String maDH, float giaTriDH, Date ngayMua, String trangThai, String maKV, String maVC) { //Table DonHang
		super();
		this.maDH = maDH;
		this.giaTriDH = giaTriDH;
		this.ngayMua = ngayMua;
		this.trangThai = trangThai;
		this.maKV = maKV;
		this.maVC = maVC;
	}
	
	public DonHang(String maDH, float giaTriDH, Date ngayMua, String trangThai, String maKV, String maVC, String tenKV) { //Table DonHang join KhuVuc
		this.maDH = maDH;
		this.giaTriDH = giaTriDH;
		this.ngayMua = ngayMua;
		this.trangThai = trangThai;
		this.maKV = maKV;
		this.maVC = maVC;
		this.tenKV = tenKV;
	}
	
	public DonHang(String maDH,float giaTriDH, Date ngayMua, String trangThai, String maKV)
	{
		this.maDH = maDH;
		this.giaTriDH = giaTriDH;
		this.ngayMua = ngayMua;
		this.trangThai = trangThai;
		this.maKV = maKV;
	}
	public String getMaDH() {
		return maDH;
	}
	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}
	public float getGiaTriDH() {
		return giaTriDH;
	}
	public void setGiaTriDH(float giaTriDH) {
		this.giaTriDH = giaTriDH;
	}
	public Date getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getMaKV() {
		return maKV;
	}
	public void setMaKV(String maKV) {
		this.maKV = maKV;
	}
	
	public String getMaVC() {
		return maVC;
	}
	public void setMaVC(String maVC) {
		this.maVC = maVC;
	}
	public String getTenKV() {
		return tenKV;
	}
	public void setTenKV(String tenKV) {
		this.tenKV = tenKV;
	}
	
	
	

}
