package services;

import JDBC.JDBCConnect;
import info.OrderBuyingCar;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrderBuyingCarServices implements Initializable {
    public ArrayList<OrderBuyingCar> arrOrderBuyingCar = new ArrayList<>();
    public JDBCConnect jdbcConnect = new JDBCConnect();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void addOrderBuying(String status, String idCar, String idCus, String Price, String day) throws SQLException {
        jdbcConnect.addOrderBuying(status,idCar,idCus,Price,day);
    }

    public void updateOrderBuying(String status, String idCar, String idCus, String Price, String day, String id) throws SQLException {
        jdbcConnect.updateOrderBuying(status,idCar,idCus,Price,day,id);
    }

    public void deleteOrderBuying(String id) throws SQLException {
        jdbcConnect.deleteOrderBuying(id);
    }

    public ArrayList<OrderBuyingCar> getArrDefault() throws SQLException, ClassNotFoundException {
        arrOrderBuyingCar = jdbcConnect.getDefaultOrderBuying();
        return arrOrderBuyingCar;
    }
}
