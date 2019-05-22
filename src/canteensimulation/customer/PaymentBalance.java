package canteensimulation.customer;

import java.math.BigDecimal;

/**
 * Abstract class representing a payment balance for a specific payment method.
 *
 * @version 22.05.2019
 */
abstract class PaymentBalance {

    private BigDecimal balance = BigDecimal.ZERO;

    /**
     * Set the balance of the payment method.
     * @param balance dInitial balance.
     */
    void setBalance(BigDecimal balance){
        this.balance = balance;
    }

    /**
     * Return the balance of the payment method.
     *
     * @return Current balance;
     */
    BigDecimal getBalance(){
        return balance;
    }

    /**
     * Subtract amount of the balance.
     * @param amount Amount representing the amount being subtracted from the balance.
     */
    void subtractAmount(BigDecimal amount){
        balance = balance.subtract(amount);
    }

    /**
     * Pay a set amount if possible.
     *
     * @param amount Amount to pay.
     * @return If the payment was successful.
     */
    abstract boolean pay(BigDecimal amount);

}
