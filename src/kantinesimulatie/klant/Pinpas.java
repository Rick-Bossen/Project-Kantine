package kantinesimulatie.klant;

import java.math.BigDecimal;

public class Pinpas extends Betaalwijze {

    private BigDecimal kredietLimiet;

    /**
     * Methode om kredietLimiet te zetten
     * @param kredietlimiet
     */
    public void setKredietLimiet(BigDecimal kredietlimiet) {
        this.kredietLimiet = kredietlimiet;
    }

    /**
     * Return als de er betaalt kan warden met de huidige betaalwijze.
     *
     * @param bedrag Bedrag wat er betaald moet worden.
     * @return Als er betaalt kan worden. Bedrag moet meer zijn dan het saldo + kredietLimiet
     */
    @Override
    protected boolean kanBetalen(BigDecimal bedrag) {
        return getSaldo().add(kredietLimiet).compareTo(bedrag) >= 0;
    }
}
