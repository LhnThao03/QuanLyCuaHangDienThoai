package DAL;

import DTO.DTONhanVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.ArrayList;
import java.sql.*;


public class DALNhanVien{
    private Connection c;
    private PreparedStatement p = null;
    private Statement stm = null;
    private ArrayList<DTONhanVien> nvList = new ArrayList<>();
    public DALNhanVien() {
    }

    transient Scanner sc = new Scanner(System.in);
     public boolean openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyCuaHangDienThoai;encrypt=false";
            String username = "sa"; String password= "123";
            c = DriverManager.getConnection(dbUrl, username, password);
            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }
     
    public void closeConnection() {
        try {
            if (c!=null)
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex); 
        }
    }
    
    public ArrayList<DTONhanVien> getAllNV(){
     if(openConnection()){
        try{
            nvList.clear();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from NhanVien");
            while(rs.next()){
                DTONhanVien nv = new DTONhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("HoTen"));
                nv.setSex(rs.getString("GioiTinh"));
                nv.setNgaySinh(rs.getString("NgaySinh"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setSDT(rs.getString("SDT"));
                nv.setLuong(rs.getFloat("Luong"));
                nvList.add(nv);
        }
        }catch (SQLException ex) {
          ex.printStackTrace();
         }finally {
           closeConnection();
          } 
        }
     return nvList;
     }
    
    public boolean addNV(DTONhanVien nv){
    boolean result = false;
    if (openConnection()) {
        try{
        PreparedStatement stmt  = c.prepareStatement("insert into NhanVien values(?,?,?,?,?,?,?)");
        stmt.setString(1, nv.getMaNV());
        stmt.setString(2, nv.getTenNV());
        stmt.setString(3, nv.getSDT());
        stmt.setString(4, nv.getDiaChi());
        stmt.setString(5, nv.getSex());
        stmt.setFloat(6, nv.getLuong());
        stmt.setString(7, nv.getNgaySinh());
        if (stmt.executeUpdate()>=1)
          result = true;
        }catch (SQLException ex) {
          ex.printStackTrace();
         }finally {
           closeConnection();
          } 
    }
    return result;
    }
    public boolean xoaNV(DTONhanVien nv){
        boolean result = false;
        if(openConnection()){
            try{
                PreparedStatement stmt  = c.prepareStatement("delete from NhanVien where MaNV = (?)");
                stmt.setString(1, nv.getMaNV());
                if(stmt.executeUpdate() >= 1){
                    result = true;
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return result;
    }

        public boolean hasNV(String MaNV){
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "Select * from NhanVien where MaNV =?";
                p = c.prepareStatement(sql);
                p.setString(1, MaNV);
                ResultSet rs = p.executeQuery();
                result = rs.next();
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
        public DTONhanVien timtheomaNV(String MaNV){
        try{
            if(openConnection()){
                String sql = "Select *from NhanVien where MaNV =? ";
                p = c.prepareStatement(sql);
                p.setString(1, MaNV);
                ResultSet rs = p.executeQuery();
                if(rs.next()){
                    String ten = rs.getString("HoTen");
                    String diachi = rs.getString("DiaChi");
                    String sdt = rs.getString("SDT");
                    String gender = rs.getString("GioiTinh");
                    float luong = rs.getFloat("Luong");
                    String ngaysinh = rs.getString("NgaySinh");
                    DTONhanVien nv = new DTONhanVien(MaNV, ten, gender,ngaysinh,diachi, sdt, luong);
                    return nv;
                }
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }finally{
            closeConnection();
        }
        return null;
        }
       public boolean suaNV(DTONhanVien nv){
        boolean result = false;
        if(openConnection()){
            try{
                String SQL = "Update NhanVien set MaNV = ? ,HoTen = ?,SDT =?,DiaChi=?,GioiTinh=?,Luong=?,NgaySinh=? where MaNV = ?";
                p = c.prepareStatement(SQL);
                p.setString(1, nv.getMaNV());
                p.setString(2, nv.getTenNV());
                p.setString(3, nv.getSDT());
                p.setString(4, nv.getDiaChi());
                p.setString(5, nv.getSex());
                p.setFloat(6, nv.getLuong());
                p.setString(7, nv.getNgaySinh());
                p.setString(8, nv.getMaNV());
                if(p.executeUpdate() >= 1){
                    result = true;
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
}

