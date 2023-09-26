package DTO;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class iOS extends DTOSanPham implements Serializable{
    float phienbanios;
    public iOS() {
        super();
        this.phienbanios = 0;
    }
    public iOS(String maSanPham, String tenSanPham, int soLuong, float donGia, int NamSX, ChiTietSanPham chitietSP,float phienbanios,String img){
        super(maSanPham, tenSanPham, donGia, soLuong,NamSX,img);
        this.phienbanios = phienbanios;
    }
    
    public iOS(String maSanPham, String tenSanPham, int soLuong, float donGia, int NamSX,float phienbanios,String img){
        super(maSanPham, tenSanPham, donGia, soLuong,NamSX,img);
        this.phienbanios = phienbanios;
    }

    public void setPhienbanios(float phienbanios) {
        this.phienbanios = phienbanios;
    }
    public float getPhienbanios() {
        return phienbanios;
    }

    @Override
    public int compareTo(DTOSanPham o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
