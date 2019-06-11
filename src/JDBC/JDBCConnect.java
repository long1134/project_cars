package JDBC;

import info.*;

import java.sql.*;
import java.util.ArrayList;

public class JDBCConnect {

    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String driver = "oracle.jdbc.driver.OracleDriver";

    public ArrayList<CarAdmin> arrNewCar = new ArrayList<>();
    public ArrayList<CarOld> arrOldCar = new ArrayList<>();
    public ArrayList<OrderBuyingCar> arrOrderBuying = new ArrayList<>();
    public ArrayList<OrderRentingCar> arrOrderRenting = new ArrayList<>();

    public ArrayList<CarAdmin> getDefaultCarNew() throws SQLException, ClassNotFoundException {
        System.out.println("hello");
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,"proj","123");
        Statement stat = con.createStatement();
        String sql = "select * from xe inner join XEBAN on xe.ID = XEBAN.ID where TINHTRANG = 'New'";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next())
        {
            String name = rs.getString("TEN");
            String brand = rs.getString("HANG");
            String price = rs.getString("GIA");
            String quanlity = rs.getString("SOLUONG");
            String grant = rs.getString("GHICHU");
            String day = rs.getString("NGNHAP");
            String id = rs.getString("ID");
            CarAdmin car = new CarAdmin(name,brand,price,day,grant,quanlity);
            car.id = id;
            arrNewCar.add(car);
        }
        System.out.println("long"+arrNewCar);
        return arrNewCar;
    }

    public void addNewCarNew(CarAdmin car, int id) throws SQLException {
        Connection con = DriverManager.getConnection(url,"proj","123");
        System.out.println("Long");
        Statement stat = con.createStatement();
        String sql = "insert into XE"+" values (XE_ID_SEQ.nextVal,'"+car.CarName+"','"+car.CarBrand+"')";
        System.out.println(sql);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.execute();
        sql = "select max(id) from xe";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next())
        {
            id = Integer.parseInt(rs.getString("ID")) ;
        }
        String sql1 = "insert into XEBAN values('"+id+"','New','"+car.Price+"',null ,'"+car.Quantity+"','0',sysdate,'"+car.guarantee+"')";
        PreparedStatement pes = con.prepareStatement(sql1);
        pes.execute();
    }

    public void updateNewCar(CarAdmin car) throws SQLException {
        Connection con = DriverManager.getConnection(url,"proj","123");
        String sql = "UPDATE XEBAN set GIA = '"+car.Price+"' , SOLUONG = '"+car.Quantity+"',NGNHAP = to_date('"+car.DayCar+"','yyyy-mm-dd'), GHICHU = '"+car.guarantee+"' WHERE ID='"+car.id+"'";
        String sql1 = "UPDATE XE"+" SET TEN = '"+car.CarName+"',HANG = '"+car.CarBrand+"' WHERE ID= '"+car.id+"'";
        System.out.println(car.DayCar);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.execute();
        PreparedStatement pes = con.prepareStatement(sql1);
        pes.execute();

    }

    public void DeleteCarNew(String id) throws SQLException {
        Connection con = DriverManager.getConnection(url,"proj","123");
        String sql = "DELETE FROM XEBAN WHERE ID = '"+id+"'";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.execute();
        String sql1 = "DELETE FROM XE WHERE ID = '"+id+"'";
        PreparedStatement pes = con.prepareStatement(sql1);
        pes.execute();
    }

    //Car Old
    public ArrayList<CarOld> getDefaultCarOld() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,"proj","123");
        Statement stat = con.createStatement();
        String sql = "select * from xe inner join XEBAN on xe.ID = XEBAN.ID where TINHTRANG = 'Old'";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next())
        {
            String name = rs.getString("TEN");
            String brand = rs.getString("HANG");
            String price = rs.getString("GIA");
            String quanlity = rs.getString("SOLUONG");
            String grant = rs.getString("GHICHU");
            String day = rs.getString("NGNHAP");
            String id = rs.getString("ID");
            String Km = rs.getString("SOKM");
            CarOld car = new CarOld(name,brand,price,day,grant,quanlity,Km);
            car.id = id;
            arrOldCar.add(car);
        }
        return arrOldCar;
    }

    public void addNewCarOld(CarOld car) throws SQLException {
        Connection con = DriverManager.getConnection(url,"proj","123");
        Statement stat = con.createStatement();
        String sql = "insert into XE"+" values (XE_ID_SEQ.nextVal,'"+car.CarName+"','"+car.CarBrand+"')";
        System.out.println(sql);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.execute();
        sql = "select max(id) from xe";
        ResultSet rs = stat.executeQuery(sql);
        int id = 0;
        while (rs.next())
        {
            id = Integer.parseInt(rs.getString("MAX(ID)")) ;
            System.out.println("id"+id);
        }
        String sql1 = "insert into XEBAN values('"+id+"','Old','"+car.Price+"',null ,'"+car.Quantity+"','"+car.KMOld+"',sysdate,'"+car.guarantee+"')";
        System.out.println(sql1);
        PreparedStatement pes = con.prepareStatement(sql1);
        pes.execute();
    }

    public void updateOldCar(CarOld car) throws SQLException {
        Connection con = DriverManager.getConnection(url,"proj","123");
        String sql = "UPDATE XEBAN set GIA = '"+car.Price+"' , SOLUONG = '"+car.Quantity+"',NGNHAP = to_date('"+car.DayCar+"','yyyy-mm-dd'), GHICHU = '"+car.guarantee+"',SOKM='"+car.KMOld+"' WHERE ID='"+car.id+"'";
        String sql1 = "UPDATE XE"+" SET TEN = '"+car.CarName+"',HANG = '"+car.CarBrand+"' WHERE ID= '"+car.id+"'";
        System.out.println(sql);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.execute();
        PreparedStatement pes = con.prepareStatement(sql1);
        pes.execute();
    }

    //order buying
    public ArrayList<OrderBuyingCar> getDefaultOrderBuying() throws SQLException, ClassNotFoundException {
        arrOrderBuying = new ArrayList<>();
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,"proj","123");
        Statement stat = con.createStatement();
        String sql = "select HOADON.id as idHD , KHACHHANG.ID , KHACHHANG.HOTEN, KHACHHANG.EMAIL, KHACHHANG.SDT, KHACHHANG.DCHI, XE.ID as idcar, XE.TEN, CTHD.TINHTRANG, HOADON.TONGGIA, HOADON.NGNHAP from CTHD inner join XE on CTHD.ID_XE = XE.ID inner join HOADON on CTHD.ID_HD = HOADON.ID inner join KHACHHANG on KHACHHANG.ID = HOADON.ID_KH";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next())
        {
            String idOrder = rs.getString("IDHD");
            String idCus = rs.getString("ID");
            String idCar = rs.getString("IDCAR");
            String price = rs.getString("TONGGIA");
            String name = rs.getString("HOTEN");
            String email = rs.getString("EMAIL");
            String phone = rs.getString("SDT");
            String address = rs.getString("DCHI");
            String nameCar = rs.getString("TEN");
            String carStatus = rs.getString("TINHTRANG");
            String dayCome = rs.getString("NGNHAP");

            OrderBuyingCar order = new OrderBuyingCar(idCus,name,phone,address,email,price,dayCome,idCar,nameCar,carStatus,idOrder);
            arrOrderBuying.add(order);

        }
        System.out.println("long"+arrNewCar);
        return arrOrderBuying;
    }

    public void addOrderBuying(String status, String idCar, String idCus, String Price, String day) throws SQLException {
        Connection con = DriverManager.getConnection(url,"proj","123");
        Statement stat = con.createStatement();
        String idEm = "1";
        String sql0 = "select max(id) as max from NHANVIEN";
        ResultSet rs = stat.executeQuery(sql0);
        while (rs.next())
        {
            idEm = rs.getString("max");
        }
        String sql1 = "insert into HOADON"+" values (HOADON_ID_SEQ.nextVal,'"+idCus+"','"+idEm+"',to_date('"+day+"','yyyy-mm-dd'),'"+Price+"',"+null+")";
        System.out.println(sql1);
        PreparedStatement pes = con.prepareStatement(sql1);
        pes.execute();
        sql1 = "select max(id) as max from HOADON";
        rs = stat.executeQuery(sql1);
        int idOrder = 0;
        while (rs.next())
        {
            idOrder = Integer.parseInt(rs.getString("max"));
        }
        String sql = "insert into CTHD"+" values ('"+idOrder+"','"+idCar+"','"+status+"',"+null+","+null+")";
        System.out.println(sql);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.execute();
    }

    public void updateOrderBuying(String status, String idCar, String idCus, String Price, String day, String id) throws SQLException {
        Connection con = DriverManager.getConnection(url,"proj","123");
        String sql = "UPDATE HOADON set ID_KH = '"+idCus+"' , NGNHAP = to_date('"+day+"','yyyy-mm-dd'),TONGGIA = '"+Price+"' WHERE ID= '"+id+"'";
        System.out.println(sql);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.execute();
        String sql1 = "UPDATE CTHD"+" set ID_XE='"+idCar+"',TINHTRANG='"+status+"' where ID_HD='"+id+"'";
        PreparedStatement pes = con.prepareStatement(sql1);
        pes.execute();
    }

    public void deleteOrderBuying(String id) throws SQLException {
        Connection con = DriverManager.getConnection(url,"proj","123");
        String sql1 = "delete from CTHD  where ID_HD='"+id+"'";
        PreparedStatement pes = con.prepareStatement(sql1);
        pes.execute();
        String sql = "delete from HOADON  WHERE ID= '"+id+"'";
        System.out.println(sql);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.execute();
    }

    //Order renting
    public ArrayList<OrderRentingCar> getDefaultOrderRenting() throws SQLException, ClassNotFoundException {
        arrOrderRenting = new ArrayList<>();
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,"proj","123");
        Statement stat = con.createStatement();
        String sql = "select THUEXE.id as idHD , KHACHHANG.ID , KHACHHANG.HOTEN, KHACHHANG.EMAIL, KHACHHANG.SDT, KHACHHANG.DCHI, XE.ID as idcar, XE.TEN, CTTX.NGTHUE, THUEXE.TONGGIA, CTTX.SOLUONG from CTTX inner join XE on CTTX.ID_XE = XE.ID inner join THUEXE on CTTX.ID_TX = THUEXE.ID inner join KHACHHANG on KHACHHANG.ID = THUEXE.ID_KH";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next())
        {
            String idOrder = rs.getString("IDHD");
            String idCus = rs.getString("ID");
            String idCar = rs.getString("IDCAR");
            String price = rs.getString("TONGGIA");
            String name = rs.getString("HOTEN");
            String email = rs.getString("EMAIL");
            String phone = rs.getString("SDT");
            String address = rs.getString("DCHI");
            String nameCar = rs.getString("TEN");
            String dayCome = rs.getString("NGTHUE");
            String dayRent = rs.getString("SOLUONG");

            OrderRentingCar order = new OrderRentingCar(idCus,name,phone,address,email,price,dayRent,idCar,nameCar,dayCome,idOrder);
            arrOrderRenting.add(order);

        }
        System.out.println("long"+arrNewCar);
        return arrOrderRenting;
    }

    public void addOrderRenting(String idCar, String idCus, String Price, String dayRent, String dayCome) throws SQLException {
        Connection con = DriverManager.getConnection(url,"proj","123");
        Statement stat = con.createStatement();
        String idEm = "1";
        String sql0 = "select max(id) as max from NHANVIEN";
        ResultSet rs = stat.executeQuery(sql0);
        while (rs.next())
        {
            idEm = rs.getString("max");
        }
        String sql1 = "insert into THUEXE"+" values (HOADON_ID_SEQ.nextVal,'"+idCus+"','"+idEm+"',"+null+",'"+Price+"',"+null+")";
        System.out.println(sql1);
        PreparedStatement pes = con.prepareStatement(sql1);
        pes.execute();
        sql1 = "select max(id) as max from THUEXE";
        rs = stat.executeQuery(sql1);
        int idOrder = 0;
        while (rs.next())
        {
            idOrder = Integer.parseInt(rs.getString("max"));
        }
        String sql = "insert into CTTX"+" values ('"+idOrder+"','"+idCar+"',to_date('"+dayCome+"','yyyy-mm-dd'),"+null+","+dayRent+","+null+")";
        System.out.println(sql);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.execute();
    }

    public void updateOrderRenting(String idCar, String idCus, String Price, String dayRent, String dayCome, String id) throws SQLException {
        Connection con = DriverManager.getConnection(url,"proj","123");
        String sql = "UPDATE THUEXE set ID_KH = '"+idCus+"' , NGNHAP = to_date('"+dayCome+"','yyyy-mm-dd'),TONGGIA = '"+Price+"' WHERE ID= '"+id+"'";
        System.out.println(sql);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.execute();
        String sql1 = "UPDATE CTTX"+" set ID_XE='"+idCar+"', SOLUONG = '"+dayRent+"' where ID_TX='"+id+"'";
        PreparedStatement pes = con.prepareStatement(sql1);
        pes.execute();
    }

    public void deleteOrderRenting(String id) throws SQLException {
        Connection con = DriverManager.getConnection(url,"proj","123");
        String sql1 = "delete from CTTX  where ID_TX='"+id+"'";
        PreparedStatement pes = con.prepareStatement(sql1);
        pes.execute();
        String sql = "delete from THUEXE  WHERE ID= '"+id+"'";
        System.out.println(sql);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.execute();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ArrayList<CarAdmin> arrNewCar = new ArrayList<>();
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String driver = "oracle.jdbc.driver.OracleDriver";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,"proj","123");
        Statement stat = con.createStatement();
        String idCus = "1";
        String day = "2019-12-22";
        String Price = "2000";
        String idCar = "1";
        String status = "Old";
        String idEm = "1";
        String id = "8";
        String sql = "UPDATE HOADON set ID_KH = '"+idCus+"' , NGNHAP = to_date('"+day+"','yyyy-mm-dd'),TONGGIA = '"+Price+"' WHERE ID= '"+id+"'";
        System.out.println(sql);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.execute();
        String sql1 = "UPDATE CTHD"+" set ID_XE='"+idCar+"',TINHTRANG='"+status+"' where ID_HD='"+id+"'";
        PreparedStatement pes = con.prepareStatement(sql1);
        pes.execute();

    }
}
