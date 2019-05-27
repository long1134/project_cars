package info;

import javafx.scene.control.Button;

public class CarAdmin extends Car {
    public Button Update;
    public Button Delete;
    public CarAdmin(String name, String brand, Double price, String daycare, String gaunt, Integer quantity){
        super(name,brand,price,daycare,gaunt,quantity);
        this.Delete = new Button("Delete");
        this.Update = new Button("Update");
    };
}
