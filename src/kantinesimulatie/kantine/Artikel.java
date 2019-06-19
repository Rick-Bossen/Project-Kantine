package kantinesimulatie.kantine;

import java.math.BigDecimal;

public class Artikel {

    private String naam;
    private BigDecimal prijs;
    private BigDecimal korting;

    /**
     * Constructor
     */
    public Artikel(String naam, BigDecimal prijs){
        this.naam = naam;
        this.prijs = prijs;
        korting = BigDecimal.ZERO;
    }

    Artikel(String naam, BigDecimal prijs, BigDecimal korting){
        this(naam, prijs);
        this.korting = korting;
    }

    public Artikel() {
        naam = null;
        prijs = BigDecimal.ZERO;
        korting = BigDecimal.ZERO;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }

    public void setKorting(BigDecimal korting)
    {
        this.korting = korting;
    }

    public String getNaam() {
        return naam;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public BigDecimal getKorting()
    {
        return korting;
    }

    public String toString(){
        return String.format("%s: %s", naam, prijs.toString());
    }
}
