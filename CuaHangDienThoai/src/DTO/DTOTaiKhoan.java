package DTO;

import java.util.Scanner;
import java.io.Serializable;

public class DTOTaiKhoan implements Serializable {
    private String taikhoan, matkhau;
    public DTOTaiKhoan(){
    }
    public DTOTaiKhoan(String taikhoan, String matkhau){
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }
   
    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }
    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
    public String getTaikhoan() {
        return taikhoan;
    }
    public String getMatkhau() {
        return matkhau;
    }
   
    @Override
    public String toString() {
        return "Tai khoan: " + taikhoan + " || Mat khau: " + matkhau;
    }
}
