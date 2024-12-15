package models;

public class LoaiSanPham {
	private String maLoaiSP;
	private String tenLoaiSP;
	private String hinhLoaiSP;

	
	public LoaiSanPham() {
		
	}
	
	public LoaiSanPham(String maLoaiSP, String tenLoaiSP, String hinhLoaiSP) { 

		this.maLoaiSP = maLoaiSP;
		this.tenLoaiSP = tenLoaiSP;
		this.hinhLoaiSP = hinhLoaiSP;
	}
	
	public String getMaLoaiSP() {
		return maLoaiSP;
	}
	public void setMaLoaiSP(String maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}
	public String getTenLoaiSP() {
		return tenLoaiSP;
	}
	public void setTenLoaiSP(String tenLoaiSP) {
		this.tenLoaiSP = tenLoaiSP;
	}
	public String getHinhLoaiSP() {
		return hinhLoaiSP;
	}
	public void setHinhLoaiSP(String hinhLoaiSP) {
		this.hinhLoaiSP = hinhLoaiSP;
	}
	
}
