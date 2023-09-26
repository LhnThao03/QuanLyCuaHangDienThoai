package DAL;

import DTO.ChiTietPhieuNhap;
import DTO.DTOPhieuNhap;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.*;

public class DALPhieuNhap {
    private Connection c;
    private PreparedStatement p = null;
    private java.sql.Statement stm = null;
    public ArrayList<DTOPhieuNhap> pnList = new ArrayList<DTOPhieuNhap>();
    public ArrayList<ChiTietPhieuNhap> ctpnList = new ArrayList<ChiTietPhieuNhap>();

    public DALPhieuNhap() {
        this.p = null;
    }
    
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
    
    public ArrayList<DTOPhieuNhap> getallPNlist(){
        if(open()){
            try{
                pnList.clear();
                String sql = "SELECT * FROM PhieuNhap";
                stm = c.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    DTOPhieuNhap pn = new DTOPhieuNhap();
                    pn.setMaPhieuNhap(rs.getString("MaPN"));
                    pn.setNgayNhap(rs.getString("NgayNhap"));
                    pn.setGioNhap(rs.getInt("GioNhap"));
                    pn.setTongTien(rs.getFloat("TongTien"));
                    pn.setMaNCC(rs.getString("MaNCC"));
                    pn.setMaNV(rs.getString("MaNV"));
                    pnList.add(pn);
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return pnList;
    }
    
    public boolean hasPN(String MaPN){
        boolean result = false;
        if(open()){
            try{
                String sql = "SELECT * FROM PhieuNhap WHERE MaPN=?";
                p = c.prepareStatement(sql);
                p.setString(1, MaPN);
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
    
    public DTOPhieuNhap timtheomapn(String MaPN){
        try{
            if(open()){
                String sql = "SELECT * FROM PhieuNhap WHERE MaPN=?";
                p = c.prepareStatement(sql);
                p.setString(1, MaPN);
                ResultSet rs = p.executeQuery();
                if(rs.next()){
                    String ngaynhap = rs.getString("NgayNhap");
                    int gionhap = rs.getInt("GioNhap");
                    String mncc = rs.getString("MaNCC");
                    String mnv = rs.getString("MaNV");
                    float tien = rs.getFloat("TongTien");
                    DTOPhieuNhap pn = new DTOPhieuNhap(MaPN,ngaynhap,gionhap,mncc,mnv,tien);
                    return pn;
                }
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }finally{
            close();
        }
        return null;
    }
    
    public boolean themPN(DTOPhieuNhap pn){
        boolean result = false;
        if(open()){
            try{
                String sql = "INSERT INTO PhieuNhap VALUES(?, ?, ?, ?, ?, ?)";
                p = c.prepareStatement(sql);
                p.setString(1, pn.getMaPhieuNhap());
                p.setString(2, pn.getNgayNhap());
                p.setInt(3, pn.getGioNhap());
                p.setFloat(4, pn.getTongTien());
                p.setString(5, pn.getMaNCC());
                p.setString(6, pn.getMaNV());
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
    
    public boolean xoaPN(DTOPhieuNhap pn){
        boolean result = false;
        if(open()){
            try{
                String sql = "DELETE FROM PhieuNhap WHERE MaPN = ?";
                p = c.prepareStatement(sql);
                p.setString(1, pn.getMaPhieuNhap());
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
    
    public boolean suaPN(DTOPhieuNhap pn){
        boolean result = false;
        if(open()){
            try{
                String SQL = "UPDATE PhieuNhap SET MaPN = ?, NgayNhap = ?, GioNhap = ?, MaNCC = ?,MaNV = ?, TongTien = ? WHERE MaPN = ? ";
                p = c.prepareStatement(SQL);
                p.setString(1, pn.getMaPhieuNhap());
                p.setString(2,pn.getNgayNhap());
                p.setInt(3, pn.getGioNhap());
                p.setString(4, pn.getMaNCC());
                p.setString(5, pn.getMaNV());
                p.setFloat(6, pn.getTongTien());
                p.setString(7, pn.getMaPhieuNhap());
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
    
     public boolean themctpn(ChiTietPhieuNhap pn){
        boolean result = false;
        if(open()){
            try{
                String sql = "INSERT INTO ChiTietPhieuNhap VALUE(?, ?, ?, ?, ?, ?)";
                p = c.prepareStatement(sql);
                p.setString(1, pn.getMaPN());
                p.setString(2, pn.getMaSP());
                p.setInt(3, pn.getSoLuong());
                p.setFloat(4,pn.getDonGia());
                p.setDouble(5, pn.getThanhTien());
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
    
    public ArrayList<ChiTietPhieuNhap> getallctpnlist(){
        if(open()){
            try{
                ctpnList.clear();
                String sql = "SELECT * FROM ChiTietPhieuNhap";
                stm = c.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    ChiTietPhieuNhap cthd = new ChiTietPhieuNhap();
                    cthd.setMaPN(rs.getString("MaPN"));
                    cthd.setMaSP(rs.getString("MaSP"));
                    cthd.setSoLuong(rs.getInt("SoLuong"));
                    cthd.setDonGia(rs.getFloat("DonGia"));
                    cthd.setThanhTien(rs.getDouble("ThanhTien"));
                    ctpnList.add(cthd);
                }
                return ctpnList;
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return null;
    }

    public boolean suaCTPN(ChiTietPhieuNhap ctpn, String MaPN){
        boolean result = false;
        if(open()){
            try{
                String SQL = "UPDATE ChiTietPhieuNhap SET MaPN = ?, MaSP = ?, SoLuong = ?, DonGia = ?, ThanhTien = ? WHERE MaPN = ? ";
                p = c.prepareStatement(SQL);
                p.setString(1, ctpn.getMaPN());
                p.setString(2, ctpn.getMaSP());
                p.setInt(3, ctpn.getSoLuong());
                p.setFloat(4, ctpn.getDonGia());
                p.setDouble(5, ctpn.getThanhTien());
                p.setString(6, MaPN);
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
    
    public ChiTietPhieuNhap timctpntheomapn(String MaPN){
        if(open()){
            try{
                    String sql = "SELECT * FROM ChiTietPhieuNhap WHERE MaPN=?";
                    p = c.prepareStatement(sql);
                    p.setString(1, MaPN);
                    ResultSet rs = p.executeQuery();
                    if(rs.next()){
                        String MaSP = rs.getString("MaSP");
                        int SoLuong = rs.getInt("SoLuong");
                        float DonGia = rs.getFloat("DonGia");
                        double ThanhTien = rs.getDouble("ThanhTien");
                        ChiTietPhieuNhap cthd = new ChiTietPhieuNhap(MaPN,MaSP,SoLuong,DonGia,ThanhTien);
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
    
    public boolean xoaCTPN(String mapn){
        boolean result = false;
        if(open()){
            try{
                String sql = "DELETE FROM ChiTietPhieuNhap WHERE MaPN = ?";
                p = c.prepareStatement(sql);
                p.setString(1, mapn);
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

