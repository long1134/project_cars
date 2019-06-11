package services;

import JDBC.JDBCConnect;
import info.CarAdmin;
import info.CarOld;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CarOldServices implements Initializable {
    public ArrayList<CarOld> arrOldCar = new ArrayList<>();
    JDBCConnect jdbcConnect = new JDBCConnect();

    public ArrayList<CarOld> getArrDefault() throws SQLException, ClassNotFoundException {
        arrOldCar = jdbcConnect.getDefaultCarOld();
        System.out.println(arrOldCar.size());
        return  arrOldCar;
    }

    public void addOldCar(CarOld car) throws SQLException {
        jdbcConnect.addNewCarOld(car);
    }

    public void updateOldCar(CarOld car) throws SQLException {
        jdbcConnect.updateOldCar(car);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
