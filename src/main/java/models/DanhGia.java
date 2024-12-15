package models;

public class DanhGia extends NguoiDung {
	private String maND;
	private String maSP;
	private int soSao;
	private String nhanXet;
	private String tenND;
	public DanhGia() {
		
	}
	public DanhGia(String maND, String maSP, int soSao, String nhanXet) {
		super();
		this.maND = maND;
		this.maSP = maSP;
		this.soSao = soSao;
		this.nhanXet = nhanXet;
	}
	
	public DanhGia(String maND,String tenND, String anhND,String maSP, int soSao, String nhanXet) {
		super(tenND,anhND);
		this.maND = maND;
		this.maSP = maSP;
		this.soSao = soSao;
		this.nhanXet = nhanXet;
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
	public int getSoSao() {
		return soSao;
	}
	public void setSoSao(int soSao) {
		this.soSao = soSao;
	}
	public String getNhanXet() {
		return nhanXet;
	}
	public void setNhanXet(String nhanXet) {
		this.nhanXet = nhanXet;
	}
	public String getTenND() {
	    return super.getTenND();
	}

	public String getAnhND() {
	    return super.getAnhND();
	}

	
}
