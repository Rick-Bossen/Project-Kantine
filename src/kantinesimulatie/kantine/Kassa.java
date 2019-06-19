package kantinesimulatie.kantine;

import kantinesimulatie.klant.Dienblad;
import kantinesimulatie.klant.TeWeinigGeldException;
import kantinesimulatie.utility.Factuur;
import kantinesimulatie.utility.FactuurRegel;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Kassa {

    private KassaRij kassaRij;
    private int aantalArtikelen;
    private BigDecimal balans;
    private BigDecimal toegepasteKorting;

    private EntityManager manager;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassaRij, EntityManager manager) {
        this.kassaRij = kassaRij;
        leegKassa();

        this.manager = manager;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op.
     * Tel deze gegevens op bij de controletotalen die voor
     * de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param dienblad die moet afrekenen
     */
    public void rekenAf(LocalDate datum, Dienblad dienblad) {
        EntityTransaction transaction = null;
        try {
            Factuur factuur = new Factuur(dienblad, datum);
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(factuur);

            for (FactuurRegel regel: factuur.getFactuurRegels()){
                manager.persist(regel);
            }

            transaction.commit();

            this.aantalArtikelen += factuur.getAantalArtikelen();
            balans = balans.add(factuur.getTotaal());
            toegepasteKorting = factuur.getKorting();
        } catch (TeWeinigGeldException e) {
            if (transaction != null) {
                transaction.rollback();
            }
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

    public BigDecimal hoeveelheidKortingGerekend() {
        return toegepasteKorting;
    }

    /**
     * Leeg de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
    public void leegKassa() {
        aantalArtikelen = 0;
        balans = BigDecimal.ZERO;
        balans = balans.setScale(2, RoundingMode.HALF_EVEN);
        toegepasteKorting = BigDecimal.ZERO;
        toegepasteKorting = toegepasteKorting.setScale(2,RoundingMode.HALF_EVEN);
    }
}