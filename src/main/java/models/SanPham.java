package models;

import java.text.DecimalFormat;

public class SanPham {
	private String maSP;
	private String tenSP;
	private float giaSP;
	private String anhSP;
	private String maLoaiSP;

	private String moTaSP;
	
	private String tenLoaiSP;

	private double trungBinhSoSao;
	public SanPham() {
		
	}
	
	public SanPham(String maSP, String tenSP, float giaSP, String anhSP, String maLoaiSP, String moTaSP) { //Table SanPham
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.giaSP = giaSP;
		this.anhSP = anhSP;
		this.maLoaiSP = maLoaiSP;
		this.moTaSP = moTaSP;
	}
	
	public SanPham(String maSP, String tenSP, float giaSP, String anhSP, String maLoaiSP, String moTaSP, String tenLoaiSP) { //Table SanPham join LoaiSanPham
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.giaSP = giaSP;
		this.anhSP = anhSP;
		this.maLoaiSP = maLoaiSP;
		this.moTaSP = moTaSP;
		this.tenLoaiSP = tenLoaiSP;
	}
	
	
	public SanPham(String maSP,String tenSP, float giaSP, String anhSP, String maLoaiSP,double trungBinhSoSao) { //Table SanPham join DanhGia
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.giaSP = giaSP;
		this.anhSP = anhSP;
		this.trungBinhSoSao = trungBinhSoSao;
		this.maLoaiSP = maLoaiSP;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public float getGiaSP() {
		return giaSP;
	}
	public void setGiaSP(float giaSP) {
		this.giaSP = giaSP;
	}
	public String getAnhSP() {
		return anhSP;
	}
	public void setAnhSP(String anhSP) {
		this.anhSP = anhSP;
	}
	public String getMaLoaiSP() {
		return maLoaiSP;
	}
	public void setMaLoaiSP(String maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}
	public double getTrungBinhSoSao() {
		return trungBinhSoSao;
	}
	public void setTrungBinhSoSao(double trungBinhSoSao) {
		this.trungBinhSoSao = trungBinhSoSao;
	}
	public String getTenLoaiSP() {
		return tenLoaiSP;
	}
	public void setTenLoaiSP(String tenLoaiSP) {
		this.tenLoaiSP = tenLoaiSP;
	}
	
	
	public String getMoTaSP() {
		return moTaSP;
	}

	public void setMoTaSP(String moTaSP) {
		this.moTaSP = moTaSP;
	}

	public String getPriceFormat()
	{
		DecimalFormat formatter = new DecimalFormat("#,###");
		return formatter.format(getGiaSP())+"đ";
	}
	
	@Override
    public String toString() {
        return "SanPham{" +
                "maSP='" + maSP + '\'' +
                ", tenSP='" + tenSP + '\'' +
                ", giaSP=" + giaSP +
                ", anhSP='" + anhSP + '\'' +
                ", maLoaiSP='" + maLoaiSP + '\'' +
                ", moTaSP='" + moTaSP + '\'' +
                ", tenLoaiSP='" + tenLoaiSP + '\'' +
                ", trungBinhSoSao=" + trungBinhSoSao +
                '}';
	}
}
