package kantinesimulatie.klant;

import java.math.BigDecimal;

public class Contant extends Betaalwijze {

    /**
     * Return als de er betaalt kan warden met de huidige betaalwijze.
     *
     * @param bedrag Bedrag wat er betaald moet worden.
     * @return Als er betaalt kan worden. Bedrag moet meer dan 0 zijn.
     */
    @Override
    protected boolean kanBetalen(BigDecimal bedrag) {
        return getSaldo().compareTo(bedrag) >= 0;
    }
}