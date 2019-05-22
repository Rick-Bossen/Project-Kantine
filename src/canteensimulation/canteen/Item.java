package canteensimulation.canteen;

import java.math.BigDecimal;

/**
 * Represents the item a customer can buy.
 *
 * @version 22.05.2019
 */
public class Item {

    private String name;
    private BigDecimal price;

    Item(String name, BigDecimal price){
        this.name = name;
        this.price = price;
    }

    Item(){
        name = null;
        price = BigDecimal.ZERO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String toString(){
        return String.format("%s: %s", name, price.toString());
    }
}
