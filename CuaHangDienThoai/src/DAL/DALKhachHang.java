package DAL;
import DTO.DTOKhachHang;
import java.util.ArrayList;
import java.sql.*;

public class DALKhachHang {
    private Connection c;
    private PreparedStatement p = null;
    private Statement stm = null;
    public static ArrayList <DTOKhachHang> khList = new ArrayList<DTOKhachHang>();
    
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
    
    public ArrayList<DTOKhachHang> getallKHlist(){
        if(open()){
            try{
                khList.clear();
                String sql = "SELECT * FROM KhachHang";
                stm = c.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    DTOKhachHang kh = new DTOKhachHang();
                    kh.setMaKH(rs.getString("MaKH"));
                    kh.setTenKH(rs.getString("TenKH"));
                    kh.setDiaChi(rs.getString("DiaChi"));
                    kh.setSDT(rs.getString("SDT"));
                    kh.setGender(rs.getString("Gender"));
                    khList.add(kh);
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                close();
            }
        }
        return khList;
    }
    
    public boolean hasKH(String MaKH){
        boolean result = false;
        if(open()){
            try{
                String sql = "SELECT * FROM KhachHang WHERE MaKH=?";
                p = c.prepareStatement(sql);
                p.setString(1, MaKH);
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
  
    public DTOKhachHang timtheomakh(String MaKH){
        try{
            if(open()){
                String sql = "SELECT * FROM KhachHang WHERE MaKH=?";
                p = c.prepareStatement(sql);
                p.setString(1, MaKH);
                ResultSet rs = p.executeQuery();
                if(rs.next()){
                    String ten = rs.getString("TenKH");
                    String diachi = rs.getString("DiaChi");
                    String sdt = rs.getString("SDT");
                    String gender = rs.getString("Gender");
                    DTOKhachHang kh = new DTOKhachHang(MaKH,ten,diachi,sdt,gender);
                    return kh;
                }
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }finally{
            close();
        }
        return null;
    }
    
    public boolean themKH(DTOKhachHang kh){
        boolean result = false;
        if(open()){
            try{
                String sql = "INSERT INTO KhachHang VALUES(?, ?, ?, ?, ?)";
                p = c.prepareStatement(sql);
                p.setString(1, kh.getMaKH());
                p.setString(2, kh.getTenKH());
                p.setString(3, kh.getDiaChi());
                p.setString(4, kh.getSDT());
                p.setString(5, kh.getGender());
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
    
    public boolean xoaKH(DTOKhachHang kh){
        boolean result = false;
        if(open()){
            try{
                String sql = "DELETE FROM KhachHang WHERE MaKH = ?";
                p = c.prepareStatement(sql);
                p.setString(1, kh.getMaKH());
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
    
    public boolean suaKH(DTOKhachHang kh){
        boolean result = false;
        if(open()){
            try{
                String SQL = "UPDATE KhachHang SET MaKH = ?, TenKH = ?, DiaChi = ?, SDT = ?, Gender = ? WHERE MaKH = ? ";
                p = c.prepareStatement(SQL);
                p.setString(1, kh.getMaKH());
                p.setString(2, kh.getTenKH());
                p.setString(3, kh.getDiaChi());
                p.setString(4, kh.getSDT());
                p.setString(5, kh.getGender());
                p.setString(6, kh.getMaKH());
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
}
    
//    public String LayMaCuoi(){
//        int j = 0;
//        for(DTOKhachHang kh:khList){
//            j++;
//            if(j == khList.size()){
//                return kh.getMaKH();
//            }
//        }
//        return null;
//    }
//
//    public void TimKHTheoTen(){
//        String c = "Y";
//        boolean check = false;
//        if(n==0){
//            System.out.println("Khong co khach hang de tim");
//            return;
//        }else if(n>=0){
//            while(c.equals("Y")){
//                System.out.print("Nhap ten khach hang muon tim: ");
//                String TENKH = sc.nextLine();
//                for(DTOKhachHang kh:khList){
//                    if(kh.getTenKH().lastIndexOf(TENKH)>=0){
//                        System.out.println(kh);
//                        check = true;
//                    }
//                }
//                if(check){
//                    break;
//                }
//                System.out.println("Khong tim thay khach hang co ten "+TENKH+" trong danh sach ban co muon nhap lai cho chinh xac?(Y/Ky tu bat ky)");
//                c = sc.nextLine();
//            }    
//        }
//    }
//        
//  
