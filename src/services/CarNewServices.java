package services;

import JDBC.JDBCConnect;
import info.CarAdmin;
import info.OrderBuyingCar;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CarNewServices implements Initializable {
    public ArrayList<CarAdmin> arrNewCar = new ArrayList<>();
    JDBCConnect jdbcConnect = new JDBCConnect();

    public ArrayList<CarAdmin> getArrDefault() throws SQLException, ClassNotFoundException {

        arrNewCar = jdbcConnect.getDefaultCarNew();
        return  arrNewCar;
    }

    public void addNewCar(CarAdmin car) throws SQLException {
        jdbcConnect.addNewCarNew(car, arrNewCar.size());
    }

    public void updateNewCar(CarAdmin car) throws SQLException {
        jdbcConnect.updateNewCar(car);
    }

    public void deleteNewCar(String id) throws SQLException {
        jdbcConnect.DeleteCarNew(id);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
