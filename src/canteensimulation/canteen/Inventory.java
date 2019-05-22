package canteensimulation.canteen;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

    private HashMap<String, ArrayList<Item>> stock;
    private HashMap<String, Integer> originalStock;
    private HashMap<String, BigDecimal> prices;

    /**
     * Create an inventory with multiple articles and
     */
    public Inventory(String[] itemNames, BigDecimal[] prices, int[] amount) {
        stock = new HashMap<>();
        originalStock = new HashMap<>();
        this.prices = new HashMap<>();

        for (int i = 0; i < itemNames.length; i++) {
            if(i < prices.length) {
                ArrayList<Item> items = new ArrayList<>();

                for (int j = 0; j < amount[i]; j++) {
                    items.add(new Item(itemNames[i], prices[i]));
                }
                originalStock.put(itemNames[i], amount[i]);
                this.prices.put(itemNames[i], prices[i]);
                stock.put(itemNames[i], items);
            }
        }
    }

    /**
     * Fill stock back to the original amount of items.
     *
     * @param itemName Item to refill.
     */
    private void refillStock(String itemName){
        ArrayList<Item> currentStock = stock.get(itemName);
        BigDecimal price = prices.get(itemName);

        for (int amount = currentStock.size(); amount < originalStock.get(itemName); amount++) {
            currentStock.add(new Item(itemName, price));
        }

        stock.put(itemName, currentStock);
    }

    /**
     * Get item or null of not available
     */
    private Item getItem(ArrayList<Item> stack) {
        if (stack == null || stack.size() == 0) {
            return null;
        } else {
            Item item = stack.get(0);
            stack.remove(0);
            if (stack.size() <= 10) {
                refillStock(item.getName());
            }
            return item;
        }
    }

    /**
     * Method for a customer to get an item.
     * @param itemName (van artikel)
     * @return Item (or null)
     */
    public Item getItem(String itemName) {
        return getItem(stock.get(itemName));
    }

}
