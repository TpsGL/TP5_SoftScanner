package productApp.entities;

import java.util.HashMap;
import java.util.Map;

public class Product extends Entity {

    private String name;
    private float price;
    private String expirationDate;



    /*public Product(String id, String name, float price, String expirationDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
    }*/

    /*public Product(String name, float price, String expirationDate) {
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
    }*/


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public float getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }

    public Map<String, String> toMap() {

        Map<String, String> maps = new HashMap<>();

        maps.put("id", getId());
        maps.put("name", getName());
        maps.put("price", getPrice() + "");
        maps.put("expiration", getExpirationDate() );

        return maps;
    }
}
