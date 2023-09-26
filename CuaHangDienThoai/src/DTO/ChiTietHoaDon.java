package DTO;

public class ChiTietHoaDon {

    private String MaHD, MaSP;
    private int soLuong; 
    private float donGia,tongTien;
    public ChiTietHoaDon(){
        this.MaHD = "";
        this.MaSP = "";
        this.soLuong = 0;
        this.donGia = 0;
        this.tongTien = 0;
    }
    
    public ChiTietHoaDon(String MaHD, String MaSP, int soLuong, float donGia, float tongTien){
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }
    
    public void setMaHD(String MaHD){
        this.MaHD = MaHD;
    }
    
    public String getMaHD(){
        return MaHD;
    }
    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    } 
}
