package DTO;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;
public class DTONhanVien implements Serializable{

    public static final String taikhoan = null;
    String MaNV, TenNV, DiaChi, SDT,sex;
    float luong;

    public DTONhanVien(float luong) {
        this.luong = luong;
    }
    
    String NgaySinh;
    transient Scanner sc = new Scanner(System.in);
    public DTONhanVien() {
    }

    public DTONhanVien(String MaNV) {
        this.MaNV = MaNV;
    }
    
    public DTONhanVien(String MaNV, String TenNV,String sex, String NgaySinh, String DiaChi, String SDT, float luong) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.sex = sex;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.luong = luong;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }
}
