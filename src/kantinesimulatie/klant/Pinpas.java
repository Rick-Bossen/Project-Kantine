package kantinesimulatie.klant;

import java.math.BigDecimal;

public class Pinpas extends Betaalwijze {

    private double kredietlimiet;

    /**
     * Methode om kredietlimiet te zetten
     * @param kredietlimiet
     */
    public void setKredietLimiet(BigDecimal kredietlimiet) {
        // method body omitted
    }

    /**
     * Methode om betaling af te handelen
     */
    public boolean betaal(BigDecimal tebetalen) {
        // method body omitted
        return false;
    }
}
