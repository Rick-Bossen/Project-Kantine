package canteensimulation.customer;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Abstract class representing a payment balance for a specific payment method.
 *
 * @version 22.05.2019
 */
abstract class PaymentBalance {

    private BigDecimal balance = BigDecimal.ZERO;

    /**
     * Return parsed object based on string.
     *
     * @return Parsed BigDecimal
     */
    BigDecimal parseString(String amount){
        return new BigDecimal(amount)
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    /**
     * Set the balance of the payment method.
     * @param balance dInitial balance.
     */
    void setBalance(String balance){
        this.balance = parseString(balance);
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
    abstract boolean pay(String amount);

}
