package services;

import info.OrderBuyingCar;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrderBuyingCarServices implements Initializable {
    public ArrayList<OrderBuyingCar> arrOrderBuyingCar = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public ArrayList<OrderBuyingCar> getArrDefault(){
        arrOrderBuyingCar.add( new OrderBuyingCar("123","Long","0933341473","23/1/1","dauan6969@gmail.com","1000","23-10-1999","123","mercedes 320","New","111"));
        arrOrderBuyingCar.add(new OrderBuyingCar("124","Ha","0933341473","23/1/1","dauan6969@gmail.com","1000","23-10-1999","123","mercedes 320","New","111"));
        return arrOrderBuyingCar;
    }
}
