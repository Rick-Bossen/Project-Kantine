package kantinesimulatie.kantine;

import kantinesimulatie.klant.Dienblad;

import java.math.BigDecimal;

public class Kantine {

    private Kassa kassa;
    private KassaRij kassaRij;
    private KantineAanbod kantineAanbod;

    /**
     * Constructor
     */
    public Kantine() {
        kassaRij = new KassaRij();
        kassa = new Kassa(kassaRij);
    }

    public void setKantineAanbod(KantineAanbod kantineAanbod) {
        this.kantineAanbod = kantineAanbod;
    }

    /**
     * In deze methode wordt een Persoon en src.kantinesimulatie.klant.Dienblad gemaakt
     * en aan elkaar gekoppeld. Maak twee Artikelen aan
     * en plaats deze op het dienblad. Tenslotte sluit de
     * Persoon zich aan bij de rij voor de kassa.
     */
    public void loopPakSluitAan(Dienblad dienblad, String[] artikelNamen) {
        for (String itemName : artikelNamen){
            Artikel artikel = kantineAanbod.getArtikel(itemName);
            if(artikel != null){
                dienblad.voegToe(artikel);
            }
        }
        kassaRij.sluitAchteraan(dienblad);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while (kassaRij.isNietLeeg()){
            Dienblad customer = kassaRij.eerstePersoonInRij();
            kassa.rekenAf(customer);
        }
    }

    /**
     * Deze methode telt het geld uit de kassa
     *
     * @return hoeveelheid geld in kassa
     */
    public BigDecimal hoeveelheidGeldInKassa() {
        return kassa.hoeveelheidGeldInKassa();
    }

    /**
     * Deze methode geeft het aantal gepasseerde artikelen.
     *
     * @return het aantal gepasseerde artikelen
     */
    public int aantalArtikelen() {
       return kassa.aantalArtikelen();
    }

    /**
     * Deze methode reset de bijgehouden telling van
     * het aantal artikelen en "leegt" de inhoud van de kassa.
     */
    public void resetKassa() {
        kassa.resetKassa();
    }
}