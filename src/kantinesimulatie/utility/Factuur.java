package kantinesimulatie.utility;

import kantinesimulatie.kantine.Artikel;
import kantinesimulatie.klant.Dienblad;
import kantinesimulatie.klant.KortingskaartHouder;
import kantinesimulatie.klant.TeWeinigGeldException;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
public class Factuur implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;

    @Column(name = "datum", nullable = false)
    private LocalDate datum;

    @Column(name = "korting", nullable = false, precision = 4, scale = 2)
    private BigDecimal korting;

    @Column(name = "totaal", nullable = false, precision = 4, scale = 2)
    private BigDecimal totaal;

    @Column(name = "aantal_artikelen", nullable = false, length = 2)
    private int aantalArtikelen;

    @OneToMany()
    @JoinColumn(name="factuur_id")
    private List<FactuurRegel> factuurRegels;

    public Factuur() {
        factuurRegels = new ArrayList<>();
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


    private void verwerkBestelling(Dienblad dienblad) throws TeWeinigGeldException{
        Iterator<Artikel> artikelen = dienblad.getArtikelen();

        while (artikelen.hasNext()) {
            Artikel artikel = artikelen.next();
            totaal = totaal.add(artikel.getPrijs());
            totaal = totaal.subtract(artikel.getKorting());

            if (artikel.getKorting().doubleValue() > 0) {
                korting = korting.add(artikel.getKorting());
                totaal = totaal.subtract(artikel.getKorting());
            } else if (dienblad.getKlant() instanceof KortingskaartHouder) {
                KortingskaartHouder houder = (KortingskaartHouder) dienblad.getKlant();
                BigDecimal kaartKorting = totaal.multiply(houder.geefKortingsPercentage());
                kaartKorting = kaartKorting.setScale(2, RoundingMode.HALF_EVEN);

                if (houder.heeftMaximum() && houder.geefMaximum().compareTo(kaartKorting) > 0) {
                    kaartKorting = houder.geefMaximum();
                }
                totaal = totaal.subtract(kaartKorting);
                korting = korting.add(kaartKorting);
            }

            FactuurRegel factuurRegel = new FactuurRegel(this, artikel);
            factuurRegels.add(factuurRegel);
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

    public List<FactuurRegel> getFactuurRegels(){
        return factuurRegels;
    }

    @Override
    public String toString() {
        BigDecimal artikelKorting = BigDecimal.ZERO;
        String factuur = "\n\nFactuur: " + id + "\n\n";
        for (FactuurRegel regel: factuurRegels) {
            artikelKorting = artikelKorting.add(regel.getArtikel().getKorting());
            factuur += regel.toString();
        }

        BigDecimal kaartKorting = korting.subtract(artikelKorting);
        if(kaartKorting.compareTo(BigDecimal.ZERO) > 0){
            factuur += "---------------------------------\n";
            factuur += String.format("%-25s%8s\n", "Kortingskaart", "- € " + kaartKorting);
        }

        factuur += "---------------------------------\n";
        factuur += String.format("%-25s%8s", "Totaal", "€ " + getTotaal());
        return factuur;
    }
}
