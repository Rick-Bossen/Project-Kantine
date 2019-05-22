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
    public void setCreditLimit(String limit){
        creditLimit = parseString(limit);
    }

    /**
     * Pay a set amount if possible.
     *
     * @param amount Amount to pay.
     * @return If the payment was successful.
     */
    public boolean pay(String amount){
        BigDecimal paymentAmount = parseString(amount);
        if(getBalance().subtract(paymentAmount).compareTo(creditLimit.negate()) > -1){
            subtractAmount(paymentAmount);
            return true;
        }
        return false;
    }

}
