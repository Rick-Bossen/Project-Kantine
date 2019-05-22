package kantinesimulatie.kantine;

import kantinesimulatie.klant.Dienblad;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Kassa {

    private KassaRij kassaRij;
    private int aantalArtikelen;
    private BigDecimal saldo;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassaRij) {
        this.kassaRij = kassaRij;
        resetKassa();
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op.
     * Tel deze gegevens op bij de controletotalen die voor
     * de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        aantalArtikelen += klant.getAantalArtikelen();
        saldo = saldo.add(klant.getTotaalPrijs());
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        return aantalArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass
     * zijn gepasseerd, vanaf het moment dat de methode
     * resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public BigDecimal hoeveelheidGeldInKassa() {
        return saldo;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        aantalArtikelen = 0;
        saldo = BigDecimal.ZERO;
        saldo = saldo.setScale(2, RoundingMode.HALF_EVEN);
    }
}