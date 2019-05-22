package kantinesimulatie.klant;

import kantinesimulatie.kantine.Artikel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.LinkedList;


public class Dienblad {

    private LinkedList<Artikel> artikelen;
    private Persoon klant;

    /**
     * Constructor
     */
    public Dienblad() {
        artikelen = new LinkedList<>();
    }

    public Dienblad(Persoon klant) {
        this();
        this.klant = klant;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
        return artikelen.size();
    }

    /**
     * Methode om de totaalprijs van de artikelen
     * op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public BigDecimal getTotaalPrijs() {
        Iterator iterator = artikelen.iterator();
        BigDecimal price = BigDecimal.ZERO;
        price = price.setScale(2, RoundingMode.HALF_EVEN);

        while (iterator.hasNext()){
            Artikel artikel = (Artikel) iterator.next();
            price = price.add(artikel.getPrijs());
        }
        return price;
    }

    public Persoon getCustomer() {
        return klant;
    }

    public void setCustomer(Persoon customer) {
        this.klant = customer;
    }
}

