package info;

public class CarOld extends Car{
    public Double KMOld;

    public CarOld(String name,String brand,Double price,String daycare,String gaunt,Integer quantity, Double km){
        super(name,brand,price,daycare,gaunt,quantity);
        this.KMOld = km;
    }
}
