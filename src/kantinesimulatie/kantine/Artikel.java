package kantinesimulatie.kantine;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Artikel {

    @Column(name = "naam")
    private String naam;

    @Column(name = "prijs")
    private BigDecimal prijs;

    @Column(name = "korting")
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
