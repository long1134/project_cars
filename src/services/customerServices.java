package services;

import JDBC.JDBCConnect;
import info.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class customerServices {

    public ArrayList<Customer> arrCustomer = new ArrayList<>();
    JDBCConnect jdbcConnect = new JDBCConnect();
    public ArrayList<Customer> getArrDefault() throws SQLException, ClassNotFoundException {
        arrCustomer = jdbcConnect.getDefaultCustomer();
        return  arrCustomer;
    }

    public void addNewCus(Customer cus) throws SQLException {
        jdbcConnect.addNewCus(cus);
    }

    public void updateCus(Customer cus) throws SQLException {
        jdbcConnect.updateCustomer(cus);
    }

    public void deleteCus(String id) throws SQLException
    {
        jdbcConnect.deleteCustomer(id);
    }
}
