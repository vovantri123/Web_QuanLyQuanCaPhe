package models;

public class NguoiDung {
	private String maND;
	private String tenND;
	private int namSinh;
	private String gioiTinh;
	private String sdt;
	private String email;
	private String diaChi;
	private String anhND;
	private String vaiTro;
	private String tenDangNhap;
	private String matKhau; 
	
	public NguoiDung() {
		
	}

	public NguoiDung(String maND, String tenND, int namSinh, String gioiTinh, String sdt, String email, String diaChi,
			String anhND, String vaiTro, String tenDangNhap, String matKhau) { //Table NguoiDung
		this.maND = maND;
		this.tenND = tenND;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.email = email;
		this.diaChi = diaChi;
		this.anhND = anhND;
		this.vaiTro = vaiTro;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}
	
	public NguoiDung(String tenND, String anhND)
	{
		this.tenND = tenND;
		this.anhND = anhND;
	}

	public String getMaND() {
		return maND;
	}

	public void setMaND(String maND) {
		this.maND = maND;
	}

	public String getTenND() {
		return tenND;
	}

	public void setTenND(String tenND) {
		this.tenND = tenND;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getAnhND() {
		return anhND;
	}

	public void setAnhND(String anhND) {
		this.anhND = anhND;
	}

	public String getVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	 
	
	
}
