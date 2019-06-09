package services;

import info.Store;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StoreServices implements Initializable {
    public ArrayList<Store> arrStore = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public ArrayList<Store> getArrDefault(){
        arrStore.add( new Store("123","Long","0933341473","23/1/1","dauan6969@gmail.com"));
        arrStore.add(new Store("124","Ha","0933341473","23/1/1","dauan6969@gmail.com"));
        return arrStore;
    }
}
