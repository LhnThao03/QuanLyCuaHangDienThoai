package DTO;

import java.io.Serializable;

public class ChiTietPhieuNhap implements Serializable{
    private String MaPN;
    private String MaSP;
    private Integer soLuong;
    private Float donGia;
    private double thanhTien;

    public ChiTietPhieuNhap(String MaSP) {
        this.MaSP = MaSP;
    }

    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(String MaPN, String MaSP, Integer soLuong, Float donGia, double thanhTien) {
        this.MaPN = MaPN;
        this.MaSP = MaSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }
    
    public void setMaPN(String MaPN){
        this.MaPN = MaPN;
    }
    
    public String getMaPN(String MaPN){
        return MaPN;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getMaPN() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
