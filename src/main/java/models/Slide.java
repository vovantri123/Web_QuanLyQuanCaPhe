package models;

public class Slide {
	private String maSlide;
	private String tenSlide;
	private String anhSlide;
	private String viTri;
	private String trangThai;
	private String maND;
	public Slide() {
		
	}
	
	public Slide(String maSlide, String tenSlide, String anhSlide, String viTri, String trangThai, String maND) { //Table Slide
		this.maSlide = maSlide;
		this.tenSlide = tenSlide;
		this.anhSlide = anhSlide;
		this.viTri = viTri;
		this.trangThai = trangThai;
		this.maND = maND;
	}
	
	public Slide(String maSlide, String tenSlide, String anhSlide) {
		this.maSlide = maSlide;
		this.tenSlide = tenSlide;
		this.anhSlide = anhSlide;
	}	 
	 
	public String getMaSlide() {
		return maSlide;
	}

	public void setMaSlide(String maSlide) {
		this.maSlide = maSlide;
	}

	public String getTenSlide() {
		return tenSlide;
	}
	public void setTenSlide(String tenSlide) {
		this.tenSlide = tenSlide;
	}
	public String getAnhSlide() {
		return anhSlide;
	}
	public void setAnhSlide(String anhSlide) {
		this.anhSlide = anhSlide;
	}
	public String getViTri() {
		return viTri;
	}
	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getMaND() {
		return maND;
	}
	public void setMaND(String maND) {
		this.maND = maND;
	}
	
}
