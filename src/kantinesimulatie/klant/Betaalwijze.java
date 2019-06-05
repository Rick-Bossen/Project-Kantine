package kantinesimulatie.klant;

import java.math.BigDecimal;

public abstract class Betaalwijze {

    private BigDecimal saldo;

    /**
     * Methode om krediet te initialiseren
     * @param saldo Saldo van de balans.
     */
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    /**
     * Krijg het saldo van de huidige balans.
     * @return het saldo
     */
    public BigDecimal getSaldo(){
        return this.saldo;
    }

    /**
     * Methode om betaling af te handelen
     * @param bedrag Bedrag wat er betaald moet worden.
     * @return Boolean als er betaald is.
     */
    public void betaal(BigDecimal bedrag) throws TeWeinigGeldException {
        if(kanBetalen(bedrag)){
           this.saldo = saldo.subtract(bedrag);
        }else{
            throw new TeWeinigGeldException("Klant heeft te weinig geld om te betalen.");
        }
    }

    /**
     * Return als de er betaalt kan warden met de huidige betaalwijze.
     * @param bedrag Bedrag wat er betaald moet worden.
     * @return Als er betaalt kan worden.
     */
    protected abstract boolean kanBetalen(BigDecimal bedrag);

}