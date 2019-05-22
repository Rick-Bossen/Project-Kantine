package canteensimulation.customer;

import canteensimulation.canteen.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Tray representing the items the customer is holding.
 *
 * @version 22.05.2019
 */
public class Tray {

    private ArrayList<Item> items;

    /**
     * Create a new tray.
     */
    public Tray(){
        items = new ArrayList<>();
    }

    /**
     * Add a item to the tray.
     *
     * @param item Item to add.
     */
    public void add(Item item){
        items.add(item);
    }

    /**
     * Get the amount of items on the tray.
     *
     * @return The amount of items.
     */
    public int getAmountOfItems(){
        return items.size();
    }

    /**
     * Sum the price of the items and return it.
     *
     * @return Total price of the items.
     */
    public BigDecimal getTotalPrice(){
        Iterator iterator = items.iterator();
        BigDecimal price = BigDecimal.ZERO;
        price = price.setScale(2, RoundingMode.HALF_EVEN);

        while (iterator.hasNext()){
            Item item = (Item) iterator.next();
            price = price.add(item.getPrice());
        }
        return price;
    }

}
