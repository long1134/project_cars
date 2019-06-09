package services;

import info.OrderRentingCar;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrderRentingCarServices implements Initializable {

    public ArrayList<OrderRentingCar> arrOrderRentingCar = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public ArrayList<OrderRentingCar> getArrDefault(){
        arrOrderRentingCar.add( new OrderRentingCar("123","Long","0933341473","23/1/1","dauan6969@gmail.com","1000","20","123","mercedes 320","23-10-1999","111"));
        arrOrderRentingCar.add(new OrderRentingCar("124","Ha","0933341473","23/1/1","dauan6969@gmail.com","1000","13","123","mercedes 320","23-10-1999","111"));
        return arrOrderRentingCar;
    }
}
