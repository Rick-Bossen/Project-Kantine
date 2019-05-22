package canteensimulation.main;

import canteensimulation.canteen.Canteen;

/**
 * Creates a basic canteen class and runs it for a set amount of days
 *
 * @version 22.05.2019
 */
public class CanteenSimulation {

    private Canteen canteen;

    private static final int DAYS = 7;

    public static void main(String[] args) {
        int days = DAYS;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]);
        }

        CanteenSimulation simulation = new CanteenSimulation();
        simulation.run(days);
    }

    /**
     *  Constructor
     */
    private CanteenSimulation(){
        canteen = new Canteen();
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
