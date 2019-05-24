package info;

public class OrderRentingCar  {
    public String idOrder;
    public String idCus;
    public String nameCus;
    public String phoneCus;
    public String addressCus;
    public String emailCus;
    public String Price;
    public String DayStart;
    public String DayRent;
    public String idCar;
    public String nameCar;

    public OrderRentingCar()
    {

    }

    public OrderRentingCar(String id, String name, String phone, String address,String email, String price, String DayRent, String carId, String nameCar, String DayStart, String idOrder)
    {
        this.idOrder = idOrder;
        this.idCus = id;
        this.nameCus = name;
        this.phoneCus = phone;
        this.addressCus = address;
        this.emailCus = email;
        this.Price = price;
        this.idCar = carId;
        this.nameCar = nameCar;
        this.DayRent = DayRent;
        this.DayStart = DayStart;
    }
}
