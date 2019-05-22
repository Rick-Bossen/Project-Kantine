package canteensimulation.customer;

import java.math.BigDecimal;

/**
 * Class representing the customer's cash balance
 */
public class CardBalance extends PaymentBalance {

    private BigDecimal creditLimit = BigDecimal.ZERO;

    /**
     * Set the credit limit.
     *
     * @param limit Limit of the negative amount.
     */
    public void setCreditLimit(BigDecimal limit){
        creditLimit = limit;
    }

    /**
     * Pay a set amount if possible.
     *
     * @param amount Amount to pay.
     * @return If the payment was successful.
     */
    public boolean pay(BigDecimal amount){
        if(getBalance().subtract(amount).compareTo(creditLimit.negate()) > -1){
            subtractAmount(amount);
            return true;
        }
        return false;
    }

}
