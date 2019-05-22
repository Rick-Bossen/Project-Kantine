package canteensimulation.canteen;

import canteensimulation.customer.Tray;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Cash register the customer can use to pay for the items on the tray.
 *
 * @version 22.05.2019
 */
public class CashRegister {

    private Queue queue;
    private int amountOfItems;
    private BigDecimal balance;

    /**
     * Create a new cash register.
     */
    public CashRegister(Queue queue){
        this.queue = queue;
        reset();
    }

    /**
     * Pay for the tray of the customer
     */
    public void payOff(Tray customer){
        amountOfItems += customer.getAmountOfItems();
        balance = balance.add(customer.getTotalPrice());
    }

    /**
     * @return The amount of articles that has passed this register.
     */
    public int amountOfItems() {
        return amountOfItems;
    }
    /**
     * @return amount in the register.
     */
    public BigDecimal amountInRegister() {
        return balance;
    }

    /**
     * Reset the values of the register.
     */
    public void reset() {
        amountOfItems = 0;
        balance = BigDecimal.ZERO;
        balance = balance.setScale(2, RoundingMode.HALF_EVEN);
    }

}
