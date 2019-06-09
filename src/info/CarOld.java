package info;

public class CarOld extends Car{
    public String KMOld;
    public String id;

    public CarOld(String name,String brand,String price,String daycare,String gaunt,String quantity, String km){
        super(name,brand,price,daycare,gaunt,quantity);
        this.KMOld = km;
    }
}
