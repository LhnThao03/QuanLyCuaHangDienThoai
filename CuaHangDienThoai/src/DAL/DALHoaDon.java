package DAL;

import DTO.ChiTietHoaDon;
import DTO.DTOHoaDon;
import java.util.ArrayList;
import java.sql.*;

public class DALHoaDon {
    private Connection c;
    private PreparedStatement p = null;
    private Statement stm = null;
    public ArrayList<DTOHoaDon> hdList = new ArrayList<DTOHoaDon>();
    public ArrayList<ChiTietHoaDon> cthdList = new ArrayList<ChiTietHoaDon>();
    
    public boolean open(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName = QuanLyCuaHangDienThoai;encrypt=false";
            String usename = "sa";
            String password = "123";
            c = DriverManager.getConnection(dbUrl,usename,password);
            return true;
        }catch(Exception ex){
            System.out.println(ex);
            return false;
        }
    }
    
    public void close(){
        try{
            if(c!=null){
                c.close();
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public ArrayList<DTOHoaDon> getallHDlist(){
        if(open()){
            try{
                hdList.clear();
                String sql = "SELECT * FROM HoaDon";
                stm = c.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    DTOHoaDon hd = new DTOHoaDon();
                    hd.setMaHoaDon(rs.getString("MaHD"));
                    hd.setMaNhanVien(rs.getString("MaNV"));
                    hd.setMaKhachHang(rs.getString("MaKH"));
                    hd.setGioLap(rs.getString("NgayLap"));
                    hd.setTongTien(rs.getFloat("TongTien"));
                    hdList.add(hd);
                }
                return hdList;
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return null;
    }
    
    public boolean hasHD(String MaHD){
        boolean result = false;
        if(open()){
            try{
                String sql = "SELECT * FROM HoaDon WHERE MaHD=?";
                p = c.prepareStatement(sql);
                p.setString(1, MaHD);
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
    
    public DTOHoaDon timtheomahd(String MaHD){
        try{
            if(open()){
                String sql = "SELECT * FROM HoaDon WHERE MaHD=?";
                p = c.prepareStatement(sql);
                p.setString(1, MaHD);
                ResultSet rs = p.executeQuery();
                if(rs.next()){
                    String mnv = rs.getString("MaNV");
                    String mkh = rs.getString("MaKH");
                    String NgayLap = rs.getString("NgayLap");
                    float tien = rs.getFloat("TongTien");
                    DTOHoaDon hd = new DTOHoaDon(MaHD,mnv,mkh,NgayLap,tien);
                    return hd;
                }
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }finally{
            close();
        }
        return null;
    }
    
    public boolean themHD(DTOHoaDon hd){
        boolean result = false;
        if(open()){
            try{
                String sql = "INSERT INTO HoaDon VALUES(?, ?, ?, ?, ?)";
                p = c.prepareStatement(sql);
                p.setString(1, hd.getMaHoaDon());
                p.setString(2,hd.getMaNhanVien());
                p.setString(3, hd.getMaKhachHang());
                p.setString(4, hd.getGioLap());
                p.setFloat(5, hd.getTongTien());
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
    
public boolean xoaHD(DTOHoaDon hd){
        boolean result = false;
        if(open()){
            try{
                String sql = "DELETE FROM HoaDon WHERE MaHD = ?";
                p = c.prepareStatement(sql);
                p.setString(1, hd.getMaHoaDon());
                xoaCTHD(hd.getMaHoaDon());
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
    
    public boolean suaHD(DTOHoaDon hd, String MaHD){
        boolean result = false;
        if(open()){
            try{
                String SQL = "UPDATE HoaDon SET MaHD = ?, MaNV = ?, MaKH = ?, NgayLap = ?, TongTien = ? WHERE MaHD = ? ";
                p = c.prepareStatement(SQL);
                p.setString(1, hd.getMaHoaDon());
                p.setString(2, hd.getMaNhanVien());
                p.setString(3, hd.getMaKhachHang());
                p.setString(4, hd.getGioLap());
                p.setFloat(5, hd.getTongTien());
                p.setString(6, MaHD);
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
    
     public boolean themcthd(ChiTietHoaDon hd){
        boolean result = false;
        if(open()){
            try{
                String sql = "INSERT INTO ChiTietHoaDon VALUE(?, ?, ?, ?, ?)";
                p = c.prepareStatement(sql);
                p.setString(1, hd.getMaHD());
                p.setString(2, hd.getMaSP());
                p.setInt(3, hd.getSoLuong());
                p.setFloat(4,hd.getDonGia());
                p.setFloat(5, hd.getTongTien());
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
    
    public ArrayList<ChiTietHoaDon> getallcthdlist(){
        if(open()){
            try{
                cthdList.clear();
                String sql = "SELECT * FROM ChiTietHoaDon";
                stm = c.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    ChiTietHoaDon cthd = new ChiTietHoaDon();
                    cthd.setMaHD(rs.getString("MaHD"));
                    cthd.setMaSP(rs.getString("MaSP"));
                    cthd.setSoLuong(rs.getInt("SoLuong"));
                    cthd.setDonGia(rs.getFloat("DonGia"));
                    cthd.setTongTien(rs.getFloat("TongTien"));
                    cthdList.add(cthd);
                }
                return cthdList;
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return null;
    }

    public boolean suaCTHD(ChiTietHoaDon cthd, String MaHD){
        boolean result = false;
        if(open()){
            try{
                String SQL = "UPDATE ChiTietHoaDon SET MaHD = ?, MaSP = ?, SoLuong = ?, DonGia = ?, TongTien = ? WHERE MaHD = ? ";
                p = c.prepareStatement(SQL);
                p.setString(1, cthd.getMaHD());
                p.setString(2, cthd.getMaSP());
                p.setInt(3, cthd.getSoLuong());
                p.setFloat(4, cthd.getDonGia());
                p.setFloat(5, cthd.getTongTien());
                p.setString(6, MaHD);
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
    
    public ChiTietHoaDon timcthdtheomahd(String MaHD){
        if(open()){
            try{
                    String sql = "SELECT * FROM ChiTietHoaDon WHERE MaHD=?";
                    p = c.prepareStatement(sql);
                    p.setString(1, MaHD);
                    ResultSet rs = p.executeQuery();
                    if(rs.next()){
                        String MaSP = rs.getString("MaSP");
                        int SoLuong = rs.getInt("SoLuong");
                        float DonGia = rs.getFloat("DonGia");
                        float TongTien = rs.getFloat("TongTien");
                        ChiTietHoaDon cthd = new ChiTietHoaDon(MaHD,MaSP,SoLuong,DonGia,TongTien);
                        return cthd;
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return null;
    }
    
    public boolean xoaCTHD(String mahd){
        boolean result = false;
        if(open()){
            try{
                String sql = "DELETE FROM ChiTietHoaDon WHERE MaHD = ?";
                p = c.prepareStatement(sql);
                p.setString(1, mahd);
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