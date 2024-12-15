package models;

public class PhuongThucThanhToan {
	private String maPTTT;
	private String tenPTTT;
	public PhuongThucThanhToan() {
		
	}
	public PhuongThucThanhToan(String maPTTT, String tenPTTT) {
		super();
		this.maPTTT = maPTTT;
		this.tenPTTT = tenPTTT;
	}
	public String getMaPTTT() {
		return maPTTT;
	}
	public void setMaPTTT(String maPTTT) {
		this.maPTTT = maPTTT;
	}
	public String getTenPTTT() {
		return tenPTTT;
	}
	public void setTenPTTT(String tenPTTT) {
		this.tenPTTT = tenPTTT;
	}
	
}
