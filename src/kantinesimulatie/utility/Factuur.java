package kantinesimulatie.utility;

import kantinesimulatie.kantine.Artikel;
import kantinesimulatie.klant.Dienblad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;

@Entity
public class Factuur implements Serializable {

    @Id
    @Column(name = "id", unique = true)
    private long id;

    @Column(name = "datum")
    private LocalDate datum;

    @Column(name = "korting")
    private BigDecimal korting;

    @Column(name = "totaal")
    private BigDecimal totaal;

    @Column(name = "aantal_artikelen")
    private int aantalArtikelen;

    public Factuur() {
        totaal = BigDecimal.ZERO;
        totaal = totaal.setScale(2,RoundingMode.HALF_EVEN);
        korting = BigDecimal.ZERO;
        korting = korting.setScale(2,RoundingMode.HALF_EVEN);
    }

    public Factuur(Dienblad klant, LocalDate datum) {
        this();
        this.datum = datum;

        verwerkBestelling(klant);
    }

    private void verwerkBestelling(Dienblad dienblad) {
        Iterator<Artikel> artikelen = dienblad.getArtikelen();

        while (artikelen.hasNext()){
            Artikel artikel = artikelen.next();
            totaal = totaal.add(artikel.getPrijs());
            totaal = totaal.subtract(artikel.getKorting());
            korting = korting.add(artikel.getKorting());
            aantalArtikelen++;
        }
    }

    public BigDecimal getTotaal() {
        return totaal;
    }

    public BigDecimal getKorting() {
        return  korting;
    }

    public int getAantalArtikelen() {
        return  aantalArtikelen;
    }

    public String toString() {
        return "Subtotaal: €" + totaal.add(korting).doubleValue() + "\n"
                + "Korting: €" + korting.doubleValue() + "\n"
                + "Totaal: €" + totaal.doubleValue();
    }
}
