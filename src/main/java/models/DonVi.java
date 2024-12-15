package models;

public class DonVi {
	private String maDV;
	private String tenDV;
	public DonVi() {
		
	}
	public DonVi(String maDV, String tenDV) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
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
