package kantinesimulatie.kantine;

import java.math.BigDecimal;

public class Artikel {

    private String naam;
    private BigDecimal prijs;

    /**
     * Constructor
     */
    Artikel(String naam, BigDecimal prijs){
        this.naam = naam;
        this.prijs = prijs;
    }

    Artikel() {
        naam = null;
        prijs = BigDecimal.ZERO;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }

    public String getNaam() {
        return naam;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public String toString(){
        return String.format("%s: %s", naam, prijs.toString());
    }
}
