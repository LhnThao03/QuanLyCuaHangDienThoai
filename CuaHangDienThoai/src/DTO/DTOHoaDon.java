package DTO;

import java.io.Serializable;
import java.util.ArrayList;

public class DTOHoaDon implements Comparable<DTOHoaDon>, Serializable {

    private String maHoaDon, maNhanVien, maKhachHang, gioLap;
    private float tongTien = 0;
    ArrayList <DTOSanPham> sp = new ArrayList<DTOSanPham>();
    public DTOHoaDon() {
        this.maHoaDon = "";
        this.maNhanVien = "";
        this.maKhachHang = "";
        this.gioLap = "";
        this.tongTien = 0;
    }

    public DTOHoaDon(String maHoaDon, String maNhanVien, String maKhachHang, String gioLap, float tongTien) {
        this.maHoaDon = maHoaDon;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.gioLap = gioLap;
        this.tongTien = tongTien;
    }

    public DTOHoaDon(String maHoaDon, String maNhanVien, String maKhachHang, String gioLap) {
        this.maHoaDon = maHoaDon;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.gioLap = gioLap;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }
    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getGioLap() {
        return gioLap;
    }

    public void setGioLap(String gioLap) {
        this.gioLap = gioLap;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float TongTien) {
        this.tongTien = TongTien;
    }

    @Override
    public int compareTo(DTOHoaDon o) {
        return this.maHoaDon.compareTo(o.maHoaDon);
    }
}
