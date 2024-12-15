package models;

public class KhuVuc {
	private String maKV;
	private String tenKV;
	private float phiVanChuyen;
	
	public KhuVuc() {
		
	}
	public KhuVuc(String maKV, String tenKV, float phiVanChuyen) { //Table Khu Vuc
		this.maKV = maKV;
		this.tenKV = tenKV;
		this.phiVanChuyen = phiVanChuyen;
	}
	public String getMaKV() {
		return maKV;
	}
	public void setMaKV(String maKV) {
		this.maKV = maKV;
	}
	public String getTenKV() {
		return tenKV;
	}
	public void setTenKV(String tenKV) {
		this.tenKV = tenKV;
	}
	public float getPhiVanChuyen() {
		return phiVanChuyen;
	}
	public void setPhiVanChuyen(float phiVanChuyen) {
		this.phiVanChuyen = phiVanChuyen;
	}
	
}
