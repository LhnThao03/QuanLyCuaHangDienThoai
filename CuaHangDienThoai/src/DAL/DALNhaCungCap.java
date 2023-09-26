package DAL;

import DTO.DTONhaCungCap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;;

public class DALNhaCungCap {
    public  ArrayList <DTONhaCungCap> nccList = new ArrayList<>();
    private Connection c;
    private PreparedStatement p = null;
    private Statement stm = null;
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
    public ArrayList<DTONhaCungCap> getAllNCC(){
     if(openConnection()){
        try{
        nccList.clear();
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("select *from NhaCungCap");
        while(rs.next()){
           nccList.add(new DTONhaCungCap(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }
        return nccList;
        }catch (SQLException ex) {
          ex.printStackTrace();
         }finally {
           closeConnection();
          } 
        }
     return nccList;
    }
    public boolean AddNCC(DTONhaCungCap NCC){
    boolean result = false;
    if (openConnection()) {
        try{
        PreparedStatement stmt  = c.prepareStatement("insert into NhaCungCap values(?,?,?,?)");
        stmt.setString(1, NCC.getMaNCC());
        stmt.setString(2, NCC.getTenNCC());
        stmt.setString(4, NCC.getSDT());
        stmt.setString(3, NCC.getDiaChi());
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
    
    public boolean xoaNCC(DTONhaCungCap NCC){
        boolean result = false;
        if(openConnection()){
            try{
                PreparedStatement stmt  = c.prepareStatement("delete from NhaCungCap where MaNCC = (?)");
               stmt.setString(1, NCC.getMaNCC());
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

        public boolean hasNCC(String MaNCC){
        boolean result = false;
        if(openConnection()){
            try{
                Statement stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("Select *from NhaCungCap where MaNCC = '"+MaNCC+"'");
                result = rs.next();
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
        public DTONhaCungCap timtheomaNCC(String MaNCC){
        try{
            if(openConnection()){
                Statement stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("Select *from NhaCungCap where MaNCC = '"+MaNCC+"'");
                if(rs.next()){
                    String ten = rs.getString(2);
                    String diachi = rs.getString(3);
                    String sdt = rs.getString(4);
                    DTONhaCungCap NCC = new DTONhaCungCap(MaNCC, ten, diachi, sdt);
                    return NCC;
                }
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }finally{
            closeConnection();
        }
        return null;
        }
        
       public boolean suaNCC(DTONhaCungCap NCC){
        boolean result = false;
        if(openConnection()){
            try{
                String SQL = "Update NhaCungCap set MaNCC = ? ,TenNCC = ?,DiaChi=?,SDT =? where MaNCC = ?";
                p = c.prepareStatement(SQL);
                p.setString(1, NCC.getMaNCC());
                p.setString(2, NCC.getTenNCC());
                p.setString(3, NCC.getDiaChi());
                p.setString(4, NCC.getSDT());
                p.setString(5, NCC.getMaNCC());
                p.executeUpdate();
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
