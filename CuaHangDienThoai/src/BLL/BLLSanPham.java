package BLL;

import DAL.DALSanPham;
import DTO.ChiTietSanPham;
import DTO.DTOSanPham;
import DTO.Android;
import DTO.iOS;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class BLLSanPham {
    private DALSanPham DALSP = new DALSanPham();
    
    public ArrayList<DTOSanPham> BLLgetDL(){
        return DALSP.getallSPlist();
    }
    
    public ArrayList<DTOSanPham> BLLgetIOS(){
        return DALSP.getSPIOSlist();
    }
    
    public ArrayList<DTOSanPham> BLLgetANDROID(){
        return DALSP.getSPANDROIDlist();
    }
    
    public String BLLthemAndriod(Android sp){
        if(DALSP.hasSP(sp.getMaSanPham())){
            return "Mã sản phẩm đã tồn tài!";
        }
        if(DALSP.themSPAndroid((Android)sp)){
            return "Thêm thành công!";
        }
        return "Thêm thất bại!";
    }
    
    public String BLLthemIOS(iOS sp){
        if(DALSP.hasSP(sp.getMaSanPham())){
            return "Mã sản phẩm đã tồn tài!";
        }
        if(DALSP.themSPIOS((iOS)sp)){
            return "Thêm thành công!";
        }
        return "Thêm thất bại!";
    }
    
    public String BLLxoaIOS(iOS sp){
        if(DALSP.xoaIOS(sp)){
            return "Xóa thành công!";
        }
        return "Xóa thất bại!";
    }
    
    public String BLLxoaANDROID(Android sp){
        if(DALSP.xoaANDROID(sp)){
            return "Xóa thành công!";
        }
        return "Xóa thất bại!";
    }
    
    public String BLLsuaIOS(iOS sp){
        if(DALSP.suaSPIOS(sp)){
            return "Sửa thành công!";
        }
        return "Sửa thất bại!";
    }
    
    public String BLLsuaANDROID(Android sp){
        if(DALSP.suaSPAndroid(sp)){
            return "Sửa thành công!";
        }
        return "Sửa thất bại!";
    }
    
    public String BLLsuaSLIOS(iOS sp,int sl){
        if(DALSP.suaSLSPIOS(sp,sl)){
            return "Sửa thành công!";
        }
        return "Sửa thất bại!";
    }
    
    public String BLLsuaSLAND(Android sp,int sl){
        if(DALSP.suaSLSPAND(sp,sl)){
            return "Sửa thành công!";
        }
        return "Sửa thất bại!";
    }
    
    public iOS BLLtimIOS(String mc){
        if(DALSP.hasSPIOS(mc)){
            return DALSP.timtheomaspIOS(mc);
        }
        return null;
    }
    
    public Android BLLtimANDROID(String mc){
        if(DALSP.hasSPANDROID(mc)){
            return DALSP.timtheomaspANDROID(mc);
        }
        return null;
    }
    
    public DTOSanPham BLLtimSP(String mc) {
        DTOSanPham result = null;
        if (DALSP.hasSPIOS(mc)) {
            result = DALSP.timtheomaspIOS(mc);
        } else if (DALSP.hasSPANDROID(mc)) {
            result = DALSP.timtheomaspANDROID(mc);
        }
        return result;
    }
    
    public String BLLthemct(ChiTietSanPham ctsp){
        if(DALSP.themctsp(ctsp)){
            return "Thêm thành công!";
        }
        return "Thêm thất bại!";
    }
    
    public String BLLsuactsp(ChiTietSanPham ctsp, String mc){
        if(!DALSP.hasSP(ctsp.getMaSP())){
            return "Mã hóa đơn không tồn tại!";
        }
        if(DALSP.suaCTSP(ctsp, mc)){
            return "Sửa thành công!";
        }
        return "Sửa thất bại!";
    }
    
    public ChiTietSanPham BLLtimctspANDROID(String mc){
        if(DALSP.hasSPANDROID(mc)){
            return DALSP.timctsptheomasp(mc);
        }
        return null;
    }
    
        public ChiTietSanPham BLLtimctspIOS(String mc){
        if(DALSP.hasSPIOS(mc)){
            return DALSP.timctsptheomasp(mc);
        }
        return null;
    }
}
