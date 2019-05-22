package canteensimulation.main;

import canteensimulation.canteen.Canteen;
import canteensimulation.canteen.Inventory;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Creates a basic canteen class and runs it for a set amount of days
 *
 * @version 22.05.2019
 */
public class RandomCanteenSimulation {

    private Canteen canteen;

    private Inventory inventory;

    private Random random;

    private static final int AMOUNT_OF_ITEMS = 4;

    private static final String[] itemNames = new String[]{
            "Coffee", "Bread with peanut butter", "Bread with cheese", "Apple juice"
    };

    private static BigDecimal[] itemPrices = new BigDecimal[]{
            new BigDecimal("1.50"),
            new BigDecimal("2.10"),
            new BigDecimal("1.65"),
            new BigDecimal("1.65")
    };

    private static final int MIN_AMOUNT_PER_ITEM = 10000;
    private static final int MAX_AMOUNT_PER_ITEM = 20000;

    private static final int MIN_CUSTOMER_PER_DAY = 50;
    private static final int MAX_CUSTOMER_PER_DAY = 100;

    private static final int MIN_ITEMS_PER_CUSTOMER = 1;
    private static final int MAX_ITEMS_PER_CUSTOMER = 4;

    private static final int DAYS = 7;

    public static void main(String[] args) {
        int days = DAYS;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]);
        }

        RandomCanteenSimulation simulation = new RandomCanteenSimulation();
        simulation.run(days);
    }

    /**
     *  Constructor
     */
    private RandomCanteenSimulation(){
        canteen = new Canteen();
        random = new Random();

        int[] amounts = getRandomArray(AMOUNT_OF_ITEMS, MIN_AMOUNT_PER_ITEM, MAX_AMOUNT_PER_ITEM);
        inventory = new Inventory(itemNames, itemPrices, amounts);

        canteen.setInventory(inventory);
    }

    /**
     * Method to get an array with random amount between the min and max.
     * min en max van de gegeven lengte te genereren
     *
     * @param length Amount of numbers
     * @param min Minimum value
     * @param max Maximum value
     * @return Array with random numbers
     */
    private int[] getRandomArray(int length, int min, int max) {
        int[] temp = new int[length];
        for(int i = 0; i < length ;i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Method to get a random amount between min and max
     *
     * @param min Minimum value
     * @param max Maximum value
     *
     * @return Random number
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array
     * artikelnamen de bijhorende array van artikelnamen te maken
     *
     * @param indices
     * @return De array met artikelnamen
     */
    private String[] giveItemsNames(int[] indices) {
        String[] items = new String[indices.length];
        for(int i = 0; i < indices.length; i++) {
            items[i] = itemNames[indices[i]];
        }
        return items;
    }

    /**
     * Run the simulation of the canteen for an x amount of days.
     *
     * @param days Amount of days the simulation should be run.
     */
    private void run(int days){
        for(int day = 0; day < days; day++){

            // @TODO Temporary amount of customers
            int customerAmount = 10 + day;
            for(int customer = 0; customer < customerAmount; customerAmount++){
                // @TODO Handle customer
            }

            // @TODO Process queue

            // @ TODO Show totals

            // @TODO Reset cash register

        }
    }

}
