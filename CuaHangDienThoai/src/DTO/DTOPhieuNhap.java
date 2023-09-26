package DTO;

import java.io.Serializable;
import java.util.Date;

public class DTOPhieuNhap implements Serializable{
    String maPhieuNhap;
    String ngayNhap;
    int gioNhap;
    float tongTien = 0;
    public String mancc;
    public String manv;    
    
    public DTOPhieuNhap() {
    }

    public DTOPhieuNhap(String maPhieuNhap, String ngayNhap, int gioNhap, String mancc, String manv, float tongTien) {
        this.maPhieuNhap = maPhieuNhap;
        this.ngayNhap = ngayNhap;
        this.gioNhap = gioNhap;
        this.mancc = mancc;
        this.manv = manv;
        this.tongTien = 0;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPN) {
        this.maPhieuNhap = maPN;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getGioNhap() {
        return gioNhap;
    }

    public void setGioNhap(int gioNhap) {
        this.gioNhap = gioNhap;
    }

    public Float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

//    public void setMaSanPham(String MaSP) {
//        ChiTietPhieuNhap phieunhap = new ChiTietPhieuNhap();
//        phieunhap.setMaSP(MaSP);
//        phieunhap.Nhap();
//    }

    public String getMaNCC() {
        return mancc;
    }

    public void setMaNCC(String mancc) {
        this.mancc = mancc;
    }

    public String getMaNV() {
        return manv;
    }

    public void setMaNV(String manv) {
        this.manv = manv;
    }
}
 
