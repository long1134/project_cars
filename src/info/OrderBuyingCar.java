package info;

public class OrderBuyingCar {
    public String idOrder;
    public String idCus;
    public String nameCus;
    public String phoneCus;
    public String addressCus;
    public String emailCus;
    public String Price;
    public String dayCome;
    public String idCar;
    public String nameCar;
    public String statusCar;

    public OrderBuyingCar(String id, String name, String phone, String address,String email, String price, String comeDay, String carId, String nameCar, String statusCar, String idOrder)
    {
        this.idOrder = idOrder;
        this.idCus = id;
        this.nameCus = name;
        this.phoneCus = phone;
        this.addressCus = address;
        this.emailCus = email;
        this.Price = price;
        this.dayCome = comeDay;
        this.idCar = carId;
        this.nameCar = nameCar;
        this.statusCar = statusCar;
    }
}
