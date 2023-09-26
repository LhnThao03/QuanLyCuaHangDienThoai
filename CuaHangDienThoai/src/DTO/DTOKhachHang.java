package DTO;
import java.io.Serializable;
import java.util.Scanner;
public class DTOKhachHang implements Serializable{
    String MaKH, TenKH, DiaChi, SDT, Gender;
    transient Scanner sc = new Scanner(System.in);
    public DTOKhachHang() {
    }

    public DTOKhachHang(String MaKH, String TenKH, String DiaChi, String SDT, String Gender) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.Gender = Gender;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
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
    
    public void setGender(String Gender){
        this.Gender = Gender;
    }
    
    public String getGender(){
        return Gender;
    }
}
