package services;

import JDBC.JDBCConnect;
import info.OrderRentingCar;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrderRentingCarServices implements Initializable {

    public ArrayList<OrderRentingCar> arrOrderRentingCar = new ArrayList<>();
    public JDBCConnect jdbcConnect = new JDBCConnect();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public ArrayList<OrderRentingCar> getArrDefault() throws SQLException, ClassNotFoundException {
        arrOrderRentingCar = jdbcConnect.getDefaultOrderRenting();
        return arrOrderRentingCar;
    }

    public void deleteOrderRenting(String id) throws SQLException {
        jdbcConnect.deleteOrderRenting(id);
    }

    public void updateOrderRenting(String idCar, String idCus, String Price, String dayRent, String dayCome, String id) throws SQLException
    {
        jdbcConnect.updateOrderRenting(idCar,idCus,Price,dayRent,dayCome,id);
    }

    public void addOrderRenting(String idCar, String idCus, String Price, String dayRent, String dayCome) throws SQLException {
        jdbcConnect.addOrderRenting(idCar,idCus,Price,dayRent,dayCome);
    }
}
