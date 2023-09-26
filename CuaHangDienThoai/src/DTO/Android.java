package DTO;

import java.io.Serializable;


public class Android extends DTOSanPham implements Serializable{
    String HangSanXuat;
    public Android(){
        super();
        this.HangSanXuat = null;
    }
    public Android(String maSanPham, String tenSanPham, int soLuong, float donGia, int NamSX, ChiTietSanPham chitietSP, String HangSanXuat,String img) {
        super(maSanPham, tenSanPham, donGia, soLuong,NamSX,img);
        this.HangSanXuat = HangSanXuat;
    }
    
    public Android(String maSanPham, String tenSanPham, int soLuong, float donGia, int NamSX, String HangSanXuat, String img){
        super(maSanPham, tenSanPham, donGia, soLuong,NamSX,img);
        this.HangSanXuat = HangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.HangSanXuat = hangSanXuat;
    }
    public String getHangSanXuat() {
        return HangSanXuat;
    }

//    @Override
//    public void nhap(){
//        System.out.println("Ma san pham: ");
//        maSanPham = sc.nextLine();
//        while(check.findmsp(maSanPham) == null){
//            System.out.println("Ma san pham da ton tai!");
//            System.out.println("Vui long nhap lai!");
//            System.out.println("Ma san pham: ");
//            maSanPham = sc.nextLine();
//        }
//        System.out.print("Ten san pham: ");
//        tenSanPham = sc.nextLine();
//        System.out.print("Don gia: ");
//        this.donGia = sc.nextFloat();
//        System.out.print("So luong: ");
//        this.soLuong = sc.nextInt();
//        System.out.print("Nam san xuat: ");
//        this.NamSX = sc.nextInt();
//        sc.nextLine();
//        chitietSP.nhap();
//        setHangSanXuat(HangSanXuat);
//    }
//
    @Override
    public int compareTo(DTOSanPham o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
