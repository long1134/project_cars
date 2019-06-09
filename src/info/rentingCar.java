package info;

public class rentingCar {
    public String nameRent;
    public String brandRent;
    public String priceRent;
    public String kmRent;
    public String dayRent;
    public String dayReturnRent;
    public String conditionRent;
    public rentingCar(String name,String brand,String price ,String km,String rent, String unrent, String trangThai){

        this.nameRent=name;
        this.brandRent=brand;
        this.priceRent=price;
        this.kmRent=km;
        this.dayRent=rent;
        this.dayReturnRent=unrent;
        this.conditionRent=trangThai;
    }
}
