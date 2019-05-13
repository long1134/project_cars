package info;

public class Car {
    public String CarName;
    public String CarBrand;
    public Double Price;
    public String DayCar;
    public String guarantee;
    public Integer Quantity;

    public Car(String name,String brand,Double price,String daycare,String gaunt,Integer quantity)
    {
        this.CarName = name;
        this.CarBrand = brand;
        this.Price = price;
        this.DayCar = daycare;
        this.guarantee = gaunt;
        this.Quantity = quantity;
    }

}
