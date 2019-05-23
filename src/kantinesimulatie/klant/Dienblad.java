package kantinesimulatie.klant;

import kantinesimulatie.kantine.Artikel;

import java.util.Iterator;
import java.util.Stack;

public class Dienblad {

    private Stack<Artikel> artikelen;
    private Persoon klant;

    /**
     * Constructor
     */
    public Dienblad() {
        artikelen = new Stack<>();
    }

    public Dienblad(Persoon klant) {
        this();
        this.klant = klant;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen.
     * @param artikel Artikel om toe te voegen.
     */
    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);
    }

    /**
     * Haal alle artikelen die op het dienblad staan.
     * @return De artikelen.
     */
    public Iterator<Artikel> getArtikelen() {
        return artikelen.iterator();
    }

    /**
     * Haal de klant op die het dienblad vast houd.
     * @return De klant.
     */
    public Persoon getKlant() {
        return klant;
    }

    /**
     * Voeg de klant toe die het dienblad vast houd.
     * @param klant De klant.
     */
    public void setKlant(Persoon klant) {
        this.klant = klant;
    }
}

