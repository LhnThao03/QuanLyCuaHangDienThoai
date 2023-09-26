package DTO;

import java.util.Scanner;
import java.io.Serializable;


public abstract class DTOSanPham implements Comparable<DTOSanPham>, Serializable {

    protected String maSanPham;
    protected String tenSanPham;
    protected int soLuong;
    protected float donGia;
    protected  int NamSX;
    protected String img;
    protected ChiTietSanPham chitietSP = new ChiTietSanPham();
    transient Scanner sc = new Scanner(System.in);

    public DTOSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public DTOSanPham(String maSanPham, String tenSanPham, float donGia, int soLuong, int namsx, String img) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.NamSX = namsx;
        this.img = img;
    }
    
    public DTOSanPham() {
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
            this.maSanPham=maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public int getNamSX() {
        return NamSX;
    }

    public void setNamSX(int NamSX) {
        this.NamSX = NamSX;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public ChiTietSanPham getChitietSP() {
        return chitietSP;
    }

    public void setChitietSP(ChiTietSanPham chitietSP) {
        this.chitietSP = chitietSP;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public String getImg(){
        return img;
    }
    public void setImg(String img){
        this.img = img;
    }
    
    @Override
    public int compareTo(DTOSanPham o) {
        return this.maSanPham.compareTo(o.maSanPham);
    }

    @Override
    public String toString() {
        return "Ma san pham: " + maSanPham + "| TenSanPham: " + tenSanPham + "| So luong: " + soLuong + "| Don gia: " + donGia + "\n"+ chitietSP;
    }
}