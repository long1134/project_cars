package test;

import java.sql.*;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String driver = "oracle.jdbc.driver.OracleDriver";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,"proj","123");
        Statement stat = con.createStatement();
        String sql = "SELECT * FROM XE";
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next())
        {
            String ten = rs.getString("TEN");
            System.out.println(ten);

        }
    }
}
