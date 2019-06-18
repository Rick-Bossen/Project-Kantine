package kantinesimulatie.kantine;

import kantinesimulatie.klant.Dienblad;

import java.time.LocalDate;

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

    /**
     * Geef de kassa terug uit de kantine.
     * @return De kassa.
     */
    public Kassa getKassa() {
        return kassa;
    }

    /**
     * Voeg het aanbod binnen de kantine toe.
     *
     * @param kantineAanbod Aanbod van de kantine.
     */
    public void setKantineAanbod(KantineAanbod kantineAanbod) {
        this.kantineAanbod = kantineAanbod;
    }

    /**
     * Voeg een dienblad toe met artikelen.
     * @param dienblad De klant die binnenkomt.
     * @param artikelNamen De artikelnamen van de klant.
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
    public void verwerkRijVoorKassa(LocalDate datum) {
        while (kassaRij.isNietLeeg()){
            Dienblad customer = kassaRij.eerstePersoonInRij();
            kassa.rekenAf(datum,customer);
        }
    }
}