package models;

public class Car {
    int id;
    String name;
    String brand;
    String platenumber;
    int quantity;
    int space;
    String gearbox;
    double price;

    public Car(int id, String name, String brand, String platenumber, int quantity, int space, String gearbox,
            double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.platenumber = platenumber;
        this.quantity = quantity;
        this.space = space;
        this.gearbox = gearbox;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPlatenumber() {
        return platenumber;
    }

    public void setPlatenumber(String platenumber) {
        this.platenumber = platenumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
