package DAL;

import DTO.Android;
import DTO.ChiTietSanPham;
import DTO.DTOSanPham;
import DTO.iOS;
import java.util.ArrayList;
import java.sql.*;

public class DALSanPham {
    private Connection c;
    private PreparedStatement p = null;
    private PreparedStatement p1 = null;
    private Statement stm = null;
    public ArrayList <DTOSanPham> spList = new ArrayList<>();
    public ArrayList <ChiTietSanPham> ctspList = new ArrayList<>();

    public boolean open(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QuanLyCuaHangDienThoai;encrypt=false";
            String username = "sa";
            String password = "123";
            c = DriverManager.getConnection(dbUrl,username,password);
            return true;
        }catch(Exception ex){
            System.out.println(ex);
            return false;
        }
    }
    
    public void close(){
        try{
            if(c != null){
                c.close();
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public ArrayList<DTOSanPham > getallSPlist(){
        if(open()){
            try{
                spList.clear();
                String sql = "SELECT * FROM SANPHAMAndroid";
                String sql2 = "SELECT * FROM SANPHAMIOS";
                stm = c.createStatement();
                ResultSet rsAndroid = stm.executeQuery(sql);
                while(rsAndroid.next()){
                    Android ad = new Android();
                    ad.setMaSanPham(rsAndroid.getString("MaSP"));
                    ad.setTenSanPham(rsAndroid.getString("TenSP"));
                    ad.setSoLuong(rsAndroid.getInt("SoLuong"));
                    ad.setDonGia(rsAndroid.getInt("DonGia"));
                    ad.setNamSX(rsAndroid.getInt("NamSX"));
                    ad.setHangSanXuat(rsAndroid.getString("HSX"));
                    ad.setImg(rsAndroid.getString("Hinh"));
                    spList.add(ad);
                }
                ResultSet rsIOS = stm.executeQuery(sql2);
                while(rsIOS.next()){
                    iOS ios = new iOS();
                    ios.setMaSanPham(rsIOS.getString("MaSP"));
                    ios.setTenSanPham(rsIOS.getString("TenSP"));
                    ios.setSoLuong(rsIOS.getInt("SoLuong"));
                    ios.setDonGia(rsIOS.getInt("DonGia"));
                    ios.setNamSX(rsIOS.getInt("NamSX"));
                    ios.setPhienbanios(rsIOS.getFloat("PhienBanIOS"));
                    ios.setImg(rsIOS.getString("Hinh"));
                    spList.add(ios);
                }
                return spList;
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return null;
    }
    
    public ArrayList<DTOSanPham> getSPIOSlist(){
        if(open()){
            try{
                spList.clear();
                String sql = "SELECT * FROM SANPHAMIOS";
                stm = c.createStatement();
                ResultSet rsIOS = stm.executeQuery(sql);
                while(rsIOS.next()){
                    iOS ios = new iOS();
                    ios.setMaSanPham(rsIOS.getString("MaSP"));
                    ios.setTenSanPham(rsIOS.getString("TenSP"));
                    ios.setSoLuong(rsIOS.getInt("SoLuong"));
                    ios.setDonGia(rsIOS.getInt("DonGia"));
                    ios.setNamSX(rsIOS.getInt("NamSX"));
                    ios.setPhienbanios(rsIOS.getFloat("PhienBan"));
                    ios.setImg(rsIOS.getString("Hinh"));
                    spList.add(ios);
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return spList;
    }
    
    public ArrayList<DTOSanPham> getSPANDROIDlist(){
        if(open()){
            try{
                spList.clear();
                String sql = "SELECT * FROM SANPHAMAndroid";
                stm = c.createStatement();
                ResultSet rsAndroid = stm.executeQuery(sql);
                while(rsAndroid.next()){
                    Android ad = new Android();
                    ad.setMaSanPham(rsAndroid.getString("MaSP"));
                    ad.setTenSanPham(rsAndroid.getString("TenSP"));
                    ad.setSoLuong(rsAndroid.getInt("SoLuong"));
                    ad.setDonGia(rsAndroid.getInt("DonGia"));
                    ad.setNamSX(rsAndroid.getInt("NamSX"));
                    ad.setHangSanXuat(rsAndroid.getString("Hang"));
                    ad.setImg(rsAndroid.getString("Hinh"));
                    spList.add(ad);
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return spList;
    }
    
    public boolean hasSP(String MaSP){
        boolean result = false;
        if(open()){
            try{
                String sql = "SELECT * FROM SanPhamAndroid WHERE MaSP=" + MaSP;
                String sql2 = "SELECT * FROM SanPhamIOS WHERE MaSP=" + MaSP;
                stm = c.createStatement();
                ResultSet rsAd = stm.executeQuery(sql);
                result = rsAd.next();
                ResultSet rsIOS = stm.executeQuery(sql2);
                result = rsIOS.next();
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return result;
    }
    
    public boolean hasSPIOS(String MaSP){
        boolean result = false;
        if(open()){
            try{
                String sql = "SELECT * FROM SanPhamIOS WHERE MaSP=?";
                p = c.prepareStatement(sql);
                p.setString(1, MaSP);
                ResultSet rs = p.executeQuery();
                result = rs.next();
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return result;
    }
    
    public boolean hasSPANDROID(String MaSP){
        boolean result = false;
        if(open()){
            try{
                String sql = "SELECT * FROM SanPhamANDROID WHERE MaSP=?";
                p = c.prepareStatement(sql);
                p.setString(1, MaSP);
                ResultSet rs = p.executeQuery();
                result = rs.next();
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return result;
    }
    
    public Android timtheomaspANDROID(String MaSP){
        try{
            if(open()){
                String sqlAd = "SELECT * FROM SanPhamAndroid WHERE MaSP=?";
                p = c.prepareStatement(sqlAd);
                p.setString(1, MaSP);
                ResultSet rsAd = p.executeQuery();
                if(rsAd.next()){
                    String ten = rsAd.getString("TenSP");
                    int SoLuong = rsAd.getInt("SoLuong");
                    float dongia = rsAd.getFloat("DonGia");
                    int nsx = rsAd.getInt("NamSX");
                    String Hang = rsAd.getString("Hang");
                    String img = rsAd.getString("Hinh");
                    Android ad = new Android(MaSP,ten,SoLuong,dongia,nsx,Hang,img);
                    return ad;
                }
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }finally{
            close();
        }
        return null;
    }
    
    public iOS timtheomaspIOS(String MaSP){
        try{
            if(open()){
                String sqlIOS = "SELECT * FROM SanPhamIOS WHERE MaSP=?";
                p = c.prepareStatement(sqlIOS);
                p.setString(1,MaSP);
                ResultSet rsIOS = p.executeQuery();
                if(rsIOS.next()){
                    String ten = rsIOS.getString("TenSP");
                    int SoLuong = rsIOS.getInt("SoLuong");
                    float dongia = rsIOS.getFloat("DonGia");
                    int nsx = rsIOS.getInt("NamSX");
                    float PhienBan = rsIOS.getFloat("PhienBan");
                    String img = rsIOS.getString("Hinh");
                    iOS ios = new iOS(MaSP,ten,SoLuong,dongia,nsx,PhienBan,img);
                    return ios;
                }
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }finally{
            close();
        }
        return null;
    }
    
    public boolean themSPAndroid(Android sp){
        boolean result = false;
        if(open()){
            try{
                String sql = "INSERT INTO SanPhamAndroid VALUES(?, ?, ?, ?, ?, ?, ?)";
                p = c.prepareStatement(sql);
                p.setString(1, sp.getMaSanPham());
                p.setString(2,sp.getTenSanPham());
                p.setInt(3, sp.getSoLuong());
                p.setFloat(4, sp.getDonGia());
                p.setInt(5, sp.getNamSX());
                p.setString(6,sp.getHangSanXuat());
                p.setString(7, sp.getImg());
                if(p.executeUpdate() >= 1){
                    result = true;
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return result;
    }
    
    public boolean themSPIOS(iOS sp){
        boolean result = false;
        if(open()){
            try{
                String sql = "INSERT INTO SanPhamIOS VALUES(?, ?, ?, ?, ?, ?, ?)";
                p = c.prepareStatement(sql);
                p.setString(1, sp.getMaSanPham());
                p.setString(2,sp.getTenSanPham());
                p.setInt(3, sp.getSoLuong());
                p.setFloat(4, sp.getDonGia());
                p.setInt(5, sp.getNamSX());
                p.setFloat(6,sp.getPhienbanios());
                p.setString(7, sp.getImg());
                if(p.executeUpdate() >= 1){
                    result = true;
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return result;
    }
    
    public boolean xoaIOS(iOS sp){
        boolean result = false;
        if(open()){
            try{
                String sql = "DELETE FROM SANPHAMIOS WHERE MaSP = ?";
                p = c.prepareStatement(sql);
                p.setString(1, sp.getMaSanPham());
                if(p.executeUpdate() >= 1){
                    result = true;
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return result;
    }
    
    public boolean xoaANDROID(Android sp){
        boolean result = false;
        if(open()){
            try{
                String sql = "DELETE FROM SANPHAMAndroid WHERE MaSP = ?";
                p = c.prepareStatement(sql);
                p.setString(1, sp.getMaSanPham());
                if(p.executeUpdate() >= 1){
                    result = true;
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return result;
    }
    
    public boolean suaSPAndroid(Android sp){
        boolean result = false;
        if(open()){
            try{
                String SQL = "UPDATE SanPhamAndroid SET MaSP = ?, TenSP = ?, SoLuong = ?, DonGia = ?, NamSX = ?, Hang = ?, Hinh = ? WHERE MaSP = ? ";
                p = c.prepareStatement(SQL);
                p.setString(1, sp.getMaSanPham());
                p.setString(2, sp.getTenSanPham());
                p.setInt(3, sp.getSoLuong());
                p.setFloat(4, sp.getDonGia());
                p.setInt(5, sp.getNamSX());
                p.setString(6, sp.getHangSanXuat());
                p.setString(7, sp.getMaSanPham());
                p.setString(8, sp.getImg());
                p.executeUpdate();
                if(p.executeUpdate() >= 1){
                    result = true;
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return result;
    }
    
    public boolean suaSPIOS(iOS sp){
        boolean result = false;
        if(open()){
            try{
                String SQL = "UPDATE SanPhamIOS SET MaSP = ?, TenSP = ?, SoLuong = ?, DonGia = ?, NamSX = ?, PhienBan = ? , Hinh =? WHERE MaSP = ? ";
                p = c.prepareStatement(SQL);
                p.setString(1, sp.getMaSanPham());
                p.setString(2, sp.getTenSanPham());
                p.setInt(3, sp.getSoLuong());
                p.setFloat(4, sp.getDonGia());
                p.setInt(5, sp.getNamSX());
                p.setFloat(6, sp.getPhienbanios());
                p.setString(7, sp.getMaSanPham());
                p.setString(8, sp.getImg());
                p.executeUpdate();
                if(p.executeUpdate() >= 1){
                    result = true;
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return result;
    }
    
    public boolean suaSLSPIOS(iOS sp,int sl){
        boolean result = false;
        if(open()){
            try{
                String SQL = "UPDATE SanPhamIOS SET SoLuong = ? WHERE MaSP = ? ";
                p = c.prepareStatement(SQL);
                p.setInt(1, sl);
                p.setString(2, sp.getMaSanPham());
                p.executeUpdate();
                if(p.executeUpdate() >= 1){
                    result = true;
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return result;
    }
    
    public boolean suaSLSPAND(Android sp,int sl){
        boolean result = false;
        if(open()){
            try{
                String SQL = "UPDATE SanPhamAndroid SET SoLuong = ? WHERE MaSP = ? ";
                p = c.prepareStatement(SQL);
                p.setInt(1, sl);
                p.setString(2, sp.getMaSanPham());
                p.executeUpdate();
                if(p.executeUpdate() >= 1){
                    result = true;
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return result;
    }
    
    public boolean themctsp(ChiTietSanPham sp){
        boolean result = false;
        if(open()){
            try{
                String sql = "INSERT INTO ChiTietSanPham VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                p = c.prepareStatement(sql);
                p.setString(1, sp.getMaSP());
                p.setString(2, sp.getBaoHanh());
                p.setString(3, sp.getMauSac());
                p.setString(4,sp.getIMEI());
                p.setString(5, sp.getManHinh());
                p.setString(6, sp.getRam());
                p.setString(7, sp.getRom());
                p.setString(8, sp.getPin());
                p.setString(9, sp.getThietKe());
                p.setString(10, sp.getCamera());
                p.setString(11, sp.getXuatXu());
                p.setFloat(12, sp.getKhoiLuong());
                if(p.executeUpdate() >= 0){
                    result = true;
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return result;
    }
    
    public ArrayList<ChiTietSanPham> getallctsplist(){
        if(open()){
            try{
                
                ctspList.clear();
                String sql = "SELECT * FROM ChiTietSanPham";
                stm = c.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    ChiTietSanPham ctsp = new ChiTietSanPham();
                    ctsp.setMaSP(rs.getString("MaSP"));
                    ctsp.setBaoHanh(rs.getString("BaoHanh"));
                    ctsp.setMauSac(rs.getString("MauSac"));
                    ctsp.setIMEI(rs.getString("IMEI"));
                    ctsp.setManHinh(rs.getString("ManHinh"));
                    ctsp.setRam(rs.getString("RAM"));
                    ctsp.setRom(rs.getString("ROM"));
                    ctsp.setPin(rs.getString("Pin"));
                    ctsp.setThietKe(rs.getString("ThietKe"));
                    ctsp.setCamera(rs.getString("Camera"));
                    ctsp.setXuatXu(rs.getString("XuatXu"));
                    ctsp.setKhoiLuong(rs.getFloat("KhoiLuong"));
                    ctspList.add(ctsp);
                }
                return ctspList;
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return null;
    }

    public boolean suaCTSP(ChiTietSanPham ctsp, String MaSP){
        boolean result = false;
        if(open()){
            try{
                String SQL = "UPDATE ChiTietSanPham SET MaSP = ?, BaoHanh = ?, MauSac = ?, IMEI = ?, ManHinh = ?, RAM = ?, ROM = ?, Pin = ?, ThietKe = ?, Camera = ?,XuatXu = ?, KhoiLuong = ? WHERE MaSP = ? ";
                p = c.prepareStatement(SQL);
                p.setString(1, ctsp.getMaSP());
                p.setString(2, ctsp.getBaoHanh());
                p.setString(3, ctsp.getMauSac());
                p.setString(4, ctsp.getIMEI());
                p.setString(5, ctsp.getManHinh());
                p.setString(6, ctsp.getRam());
                p.setString(7, ctsp.getRom());
                p.setString(8, ctsp.getPin());
                p.setString(9, ctsp.getThietKe());
                p.setString(10, ctsp.getCamera());
                p.setString(11, ctsp.getXuatXu());
                p.setFloat(12, ctsp.getKhoiLuong());
                p.setString(13, MaSP);
                if(p.executeUpdate() >= 1){
                    result = true;
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return result;
    }
    
    public ChiTietSanPham timctsptheomasp(String MaSP){
        if(open()){
            try{
                    String sql = "SELECT * FROM ChiTietSanPham WHERE MaSP=?";
                    p = c.prepareStatement(sql);
                    p.setString(1, MaSP);
                    ResultSet rs = p.executeQuery();
                    if(rs.next()){
                        String BaoHanh = rs.getString("BaoHanh");
                        String MauSac = rs.getString("MauSac");
                        String IMEI = rs.getString("IMEI");
                        String ManHinh = rs.getString("ManHinh");
                        String RAM = rs.getString("RAM");
                        String ROM = rs.getString("ROM");
                        String Pin = rs.getString("Pin");
                        String ThietKe = rs.getString("ThietKe");
                        String Camera = rs.getString("Camera");
                        String XuatXu = rs.getString("XuatSu");
                        Float KhoiLuong = rs.getFloat("KhoiLuong");
                        ChiTietSanPham ctsp = new ChiTietSanPham(MaSP,BaoHanh,MauSac,IMEI,ManHinh,RAM,ROM,Pin,ThietKe,Camera,XuatXu,KhoiLuong);
                        return ctsp;
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return null;
    }
    
    public boolean xoaCTSP(String masp){
        boolean result = false;
        if(open()){
            try{
                String sql = "DELETE FROM ChiTietSanPham WHERE MaSP = ?";
                p = c.prepareStatement(sql);
                p.setString(1, masp);
                if(p.executeUpdate() >= 1){
                    result = true;
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return result;
    }
}
