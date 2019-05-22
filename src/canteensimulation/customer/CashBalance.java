package canteensimulation.customer;

import java.math.BigDecimal;

/**
 * Class representing the customer's cash balance
 */
public class CashBalance extends PaymentBalance {

    /**
     * Pay a set amount if possible.
     *
     * @param amount Amount to pay.
     * @return If the payment was successful.
     */
    public boolean pay(BigDecimal amount){
        if(getBalance().subtract(amount).compareTo(BigDecimal.ZERO) > -1){
            subtractAmount(amount);
            return true;
        }
        return false;
    }

}
