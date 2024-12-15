package models;

public class ThanhToan {
	private String maND;
	private String maDH;
	private String maPTTT;
	public ThanhToan() {
		
	}
	public ThanhToan(String maND, String maDH, String maPTTT) {
		super();
		this.maND = maND;
		this.maDH = maDH;
		this.maPTTT = maPTTT;
	}
	public String getMaND() {
		return maND;
	}
	public void setMaND(String maND) {
		this.maND = maND;
	}
	public String getMaDH() {
		return maDH;
	}
	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}
	public String getMaPTTT() {
		return maPTTT;
	}
	public void setMaPTTT(String maPTTT) {
		this.maPTTT = maPTTT;
	}
	
}
