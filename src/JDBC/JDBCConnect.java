package JDBC;

import info.Car;
import info.CarAdmin;
import info.CarOld;

import java.sql.*;
import java.util.ArrayList;

public class JDBCConnect {

    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String driver = "oracle.jdbc.driver.OracleDriver";

    public ArrayList<CarAdmin> arrNewCar = new ArrayList<>();
    public ArrayList<CarOld> arrOldCar = new ArrayList<>();

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
        System.out.println("Long");
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

    public void addNewCarOld(CarOld car, int id) throws SQLException {
        Connection con = DriverManager.getConnection(url,"proj","123");
        Statement stat = con.createStatement();
        String sql = "insert into XE"+" values (XE_ID_SEQ.nextVal,'"+car.CarName+"','"+car.CarBrand+"')";
        System.out.println(sql);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.execute();
        System.out.println("Long");
        String sql1 = "insert into XEBAN values('"+id+"','Old','"+car.Price+"',null ,'"+car.Quantity+"','"+car.KMOld+"',sysdate,'"+car.guarantee+"')";
        PreparedStatement pes = con.prepareStatement(sql1);
        pes.execute();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ArrayList<CarAdmin> arrNewCar = new ArrayList<>();
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String driver = "oracle.jdbc.driver.OracleDriver";
        Class.forName(driver);
        CarAdmin car = new CarAdmin("BMW c10", "BMW", "1000.99", "21-10-1999", "23", "19");
        car.id = "17";
        Connection con = DriverManager.getConnection(url,"proj","123");
//        Statement stat = con.createStatement();
//        String sql = "select * from xe inner join XEBAN on xe.ID = XEBAN.ID where TINHTRANG = 'OLD'";
//        ResultSet rs = stat.executeQuery(sql);
//        while (rs.next())
//        {
//            String name = rs.getString("TEN");
//            String brand = rs.getString("HANG");
//            String price = rs.getString("GIA");
//            String quanlity = rs.getString("SOLUONG");
//            String grant = rs.getString("GHICHU");
//            String day = rs.getString("NGNHAP");
//            String id = rs.getString("ID");
//            String Km = rs.getString("SOKM");
//            CarOld car = new CarOld(name,brand,price,day,grant,quanlity,Km);
//            car.id = id;
//            arrOldCar.add(car);
//        }
//        return arrOldCar;
    }
}
