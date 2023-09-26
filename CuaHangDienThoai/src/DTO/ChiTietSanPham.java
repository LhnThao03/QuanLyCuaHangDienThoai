package DTO;
import java.io.Serializable;
public class ChiTietSanPham implements Serializable{
    private String MaSP;
    private String baoHanh;
    private String mauSac;
    private String IMEI;
    private String manHinh;
    private String ram;
    private String rom;
    private String pin;
    private String thietKe;
    private String camera;
    private String xuatXu;
    private float khoiLuong;
    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String MaSP, String baoHanh, String mauSac, String IMEI, String manHinh,String ram,String rom, String pin,String thietKe,String camera,String xuatXu,float khoiLuong) {
        this.MaSP = MaSP;
        this.baoHanh = baoHanh;
        this.mauSac=mauSac;
        this.IMEI=IMEI;
        this.manHinh=manHinh;
        this.ram=ram;
        this.rom=rom;
        this.pin=pin;
        this.thietKe=thietKe;
        this.camera=camera;
        this.xuatXu=xuatXu;
        this.khoiLuong=khoiLuong;
    }
    
    public void setMaSP(String MaSP){
        this.MaSP = MaSP;
    }
    
    public String getMaSP(){
        return MaSP;
    }

    public String getBaoHanh() {
        return baoHanh;
    }

    public String getMauSac() {
        return mauSac;
    }

    public String getIMEI() {
        return IMEI;
    }

    public String getManHinh(){
        return manHinh;
    }

    public String getRam(){
        return ram;
    }

    public String getRom(){
        return rom;
    }

    public String getPin(){
        return pin;
    }
    
    public String getThietKe(){
        return thietKe;
    }

    public String getCamera(){
        return camera;
    }

    public String getXuatXu(){
        return xuatXu;
    }
    
    public float getKhoiLuong(){
        return khoiLuong;
    }
    public void setBaoHanh(String baoHanh) {
        this.baoHanh = baoHanh;
    }

    public void setMauSac(String mauSac) {
        this.mauSac =mauSac;
    }

    public void setIMEI(String IMEI) {
        this.IMEI= IMEI;
    }

    public void setManHinh(String manHinh) {
        this.manHinh= manHinh;
    }

    public void setRam(String ram) {
        this.ram= ram;
    }

    public void setRom(String rom) {
        this.rom= rom;
    }

    public void setPin(String pin) {
        this.pin= pin;
    }

    public void setThietKe(String thietKe) {
        this.thietKe= thietKe;
    }
    public void setCamera(String camera) {
        this.camera= camera;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu=xuatXu ;
    }

    public void setKhoiLuong(float khoiLuong) {
        this.khoiLuong= khoiLuong;
    }

    @Override
    public String toString() {
        return "Bao hanh: " + baoHanh + "| Mau sac: " + mauSac + "|  IMEI: " + IMEI + "| Man hinh: " + manHinh + "| Ram: " + ram + "| Rom: " + rom + "| Pin: " + pin + "| Thiet ke: " + thietKe + "| Camera: " + camera + "| Xuat xu: " + xuatXu + "| Khoi luong: " + khoiLuong;
    }

}