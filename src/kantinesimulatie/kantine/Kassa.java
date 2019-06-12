package kantinesimulatie.kantine;

import kantinesimulatie.klant.Dienblad;
import kantinesimulatie.klant.KortingskaartHouder;
import kantinesimulatie.klant.Persoon;
import kantinesimulatie.klant.TeWeinigGeldException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;

public class Kassa {

    private KassaRij kassaRij;
    private int aantalArtikelen;
    private BigDecimal balans;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassaRij) {
        this.kassaRij = kassaRij;
        leegKassa();
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op.
     * Tel deze gegevens op bij de controletotalen die voor
     * de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param dienblad die moet afrekenen
     */
    public void rekenAf(Dienblad dienblad) {
        Persoon klant = dienblad.getKlant();
        Iterator<Artikel> artikelen = dienblad.getArtikelen();

        int aantalArtikelen = 0;
        BigDecimal price = BigDecimal.ZERO;
        price = price.setScale(2, RoundingMode.HALF_EVEN);

        while (artikelen.hasNext()){
            Artikel artikel = artikelen.next();
            price = price.add(artikel.getPrijs());
            aantalArtikelen++;
        }

        if(klant instanceof KortingskaartHouder){
            KortingskaartHouder houder = (KortingskaartHouder) klant;
            BigDecimal korting = price.multiply(houder.geefKortingsPercentage());

            if(houder.heeftMaximum() && houder.geefMaximum().compareTo(korting) > 0){
                korting = houder.geefMaximum();
            }
            price = price.subtract(korting);
        }

        try{
            klant.getBetaalwijze().betaal(price);
            this.aantalArtikelen += aantalArtikelen;
            balans = balans.add(price);
        }catch (TeWeinigGeldException exception){
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalVerkochteArtikelen() {
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
        return balans;
    }

    /**
     * Leeg de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
    public void leegKassa() {
        aantalArtikelen = 0;
        balans = BigDecimal.ZERO;
        balans = balans.setScale(2, RoundingMode.HALF_EVEN);
    }
}