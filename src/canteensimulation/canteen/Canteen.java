package canteensimulation.canteen;

import canteensimulation.customer.Tray;

import java.math.BigDecimal;

/**
 * Creates a canteen containing a single cash register with queue.
 *
 * @version 22.05.2019
 */
public class Canteen {

    private CashRegister register;
    private Queue queue;
    private Inventory inventory;

    public Canteen(){
        queue = new Queue();
        register = new CashRegister(queue);
    }

    /**
     * Create a new customer with tray.
     * Add 2 items to the tray.
     * Get in line.
     */
    public void newCustomer(){
        // @TODO week 2
    }

    /**
     * Process the next customer in queue.
     */
    public void handleQueue(){
        while (queue.isNotEmpty()){
            Tray customer = queue.leaveQueue();
            register.payOff(customer);
        }
    }

    /**
     * Return the amount in the register.
     * @return amount
     */
    public BigDecimal amountInRegister() {
        return register.amountInRegister();
    }

    /**
     * Return the amount of items that passed the register.
     * @return amount of items.
     */
    public int amountOfItems(){
        return register.amountOfItems();
    }

    /**
     * Reset the cash register.
     */
    public void reset(){
        register.reset();
    }

    /**
     * Set the inventory for the canteen.
     *
     * @param inventory Inventory of the canteen.
     */
    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }

}
