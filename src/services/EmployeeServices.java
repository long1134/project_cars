package services;

import JDBC.JDBCConnect;
import info.employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeServices {
    public ArrayList<employee> arrCustomer = new ArrayList<>();
    JDBCConnect jdbcConnect = new JDBCConnect();
    public ArrayList<employee> getArrDefault() throws SQLException, ClassNotFoundException {
        arrCustomer = jdbcConnect.getDefaultEmployee();
        return  arrCustomer;
    }

    public void addNEmployee(employee cus) throws SQLException {
        jdbcConnect.addNEmployee(cus);
    }

    public void updateEmployee(employee emp) throws SQLException {
        jdbcConnect.updateEmployee(emp);
    }
}
