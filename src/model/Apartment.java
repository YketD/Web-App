package model;

/**
 * Created by yketd on 1-9-2016.
 */
public class Apartment
{
    double size, price;
    String location;

    public Apartment(double size, double price, String location)
    {
        this.size = size;
        this.price = price;
        this.location = location;
    }

    public double getSize()
    {
        return size;
    }

    public void setSize(double size)
    {
        this.size = size;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }
}
