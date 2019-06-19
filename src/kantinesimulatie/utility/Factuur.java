package kantinesimulatie.utility;

import kantinesimulatie.kantine.Artikel;
import kantinesimulatie.klant.Dienblad;
import kantinesimulatie.klant.KortingskaartHouder;
import kantinesimulatie.klant.Persoon;
import kantinesimulatie.klant.TeWeinigGeldException;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Iterator;

@Entity
public class Factuur implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Factuur(Dienblad klant, LocalDate datum) throws TeWeinigGeldException{
        this();
        this.datum = datum;

        verwerkBestelling(klant);
    }


    private void verwerkBestelling(Dienblad dienblad) throws TeWeinigGeldException {
        Iterator<Artikel> artikelen = dienblad.getArtikelen();

        while (artikelen.hasNext()) {
            Artikel artikel = artikelen.next();
            totaal = totaal.add(artikel.getPrijs());
            totaal = totaal.subtract(artikel.getKorting());

            if (artikel.getKorting().doubleValue() > 0) {
                korting = korting.add(artikel.getKorting());
                totaal = totaal.subtract(artikel.getKorting());
            } else if (dienblad instanceof KortingskaartHouder) {
                KortingskaartHouder houder = (KortingskaartHouder) dienblad;
                BigDecimal kaardKorting = totaal.multiply(houder.geefKortingsPercentage());

                if (houder.heeftMaximum() && houder.geefMaximum().compareTo(kaardKorting) > 0) {
                    kaardKorting = houder.geefMaximum();
                }
                totaal = totaal.subtract(kaardKorting);
                korting = korting.add(kaardKorting);
            }

        }
        aantalArtikelen++;

        dienblad.getKlant().getBetaalwijze().betaal(totaal);
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

    @Override
    public String toString() {
        return "Subtotaal: €" + totaal.add(korting).doubleValue() + "\n"
                + "Korting: €" + korting.doubleValue() + "\n"
                + "Totaal: €" + totaal.doubleValue();
    }
}
