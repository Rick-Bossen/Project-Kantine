package canteensimulation.canteen;

import canteensimulation.customer.Tray;

import java.util.LinkedList;

/**
 * Represents a queue filled with customers.
 *
 * @version 22.05.2019
 */
public class Queue {

    private LinkedList<Tray> customers;

    /**
     * Constructor
     */
    public Queue(){
        customers = new LinkedList<>();
    }

    /**
     * Join the end of the queue.
     *
     * @param customer Tray representing the customer joining the queue.
     */
    public void joinQueue(Tray customer){
        customers.add(customer);
    }

    /**
     * First customer leaves queue if the queue is not empty.
     *
     * @return Tray representing the first customer.
     */
    public Tray leaveQueue(){
        return isNotEmpty() ? customers.removeFirst() : null;
    }

    /**
     *  Check if the queue is not empty.
     *
     * @return Boolean representing if the queue is not empty
     */
    public boolean isNotEmpty(){
        return !customers.isEmpty();
    }

}
