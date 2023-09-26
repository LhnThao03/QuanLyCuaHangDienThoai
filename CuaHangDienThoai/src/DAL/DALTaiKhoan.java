package DAL;

import DTO.DTOKhachHang;
import DTO.DTOTaiKhoan;
import java.util.ArrayList;
import java.sql.*;

public class DALTaiKhoan {
    private Connection c;
    private PreparedStatement p = null;
    private Statement stm = null;
    //int n;
    public ArrayList <DTOTaiKhoan> tkList = new ArrayList<DTOTaiKhoan>();
    public DALTaiKhoan(){
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
    
        public ArrayList<DTOTaiKhoan> getallTKlist(){
        if(open()){
            try{
                tkList.clear();
                String sql = "SELECT * FROM TaiKhoan";
                stm = c.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    DTOTaiKhoan tk = new DTOTaiKhoan();
                    tk.setTaikhoan(rs.getString("TaiKhoan"));
                    tk.setMatkhau(rs.getString("MatKhau"));
                    tkList.add(tk);
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return tkList;
    }
    
    public boolean hasTK(String TaiKhoan){
        boolean result = false;
        if(open()){
            try{
                String sql = "SELECT * FROM TaiKhoan WHERE TaiKhoan=?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, TaiKhoan);
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
    
    public boolean hasMK(String MatKhau){
        boolean result = false;
        if(open()){
            try{
                String sql = "SELECT * FROM TaiKhoan WHERE MatKhau=?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, MatKhau);
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
    
    public DTOTaiKhoan timtheotk(String TaiKhoan){
        try{
            if(open()){
                String sql = "SELECT * FROM TaiKhoan WHERE TaiKhoan=?";
                p = c.prepareStatement(sql);
                p.setString(1, TaiKhoan);
                ResultSet rs = p.executeQuery();
                if(rs.next()){
                    String taikhoan = rs.getString("TaiKhoan");
                    String MatKhau = rs.getString("MatKhau");
                    DTOTaiKhoan tk = new DTOTaiKhoan(taikhoan,MatKhau);
                    return tk;
                }
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }finally{
            close();
        }
        return null;
    }
    
    public boolean themTK(DTOTaiKhoan tk){
        boolean result = false;
        if(open()){
            try{
                String sql = "INSERT INTO TaiKhoan VALUES(?, ?)";
                p = c.prepareStatement(sql);
                p.setString(1,tk.getTaikhoan());
                p.setString(2, tk.getMatkhau());
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
    
    public boolean xoaTK(String TK){
        boolean result = false;
        if(open()){
            try{
                String sql = "DELETA FROM TaiKhoan WHERE TaiKhoan = ?";
                p = c.prepareStatement(sql);
                p.executeUpdate();
                p.setString(1, TK);
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
    
    public boolean suaTK(DTOTaiKhoan tk, String TaiKhoan){
        boolean result = false;
        if(open()){
            try{
                String SQL = "UPDATE KhachHang SET  TaiKhoan = ?, MatKhau = ? WHERE TaiKhoan = ? ";
                p = c.prepareStatement(SQL);
                p.setString(1, tk.getTaikhoan());
                p.setString(2, tk.getMatkhau());
                p.setString(3, TaiKhoan);
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
    
    public boolean dangnhap(String TaiKhoan, String MatKhau){
        if(hasTK(TaiKhoan) == false || hasMK(MatKhau) == false){
            return false;
        }
        return true;
    }
    
    public boolean hasTKMK(String TaiKhoan,String MatKhau){
        boolean result = false;
        if(open()){
            try{
                Statement stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("Select *from TaiKhoan where TaiKhoan = '"+TaiKhoan+"'and MatKhau = '"+MatKhau+"'");
                if(rs.next())
                    result = true;
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return result;
    }
}