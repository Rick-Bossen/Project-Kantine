package kantinesimulatie.utility;

import kantinesimulatie.kantine.Artikel;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class FactuurRegel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Factuur factuur;

    @Embedded()
    private Artikel artikel;

    public FactuurRegel(){}

    public FactuurRegel(Factuur factuur, Artikel artikel){
        this.factuur = factuur;
        this.artikel = artikel;
    }

    public Artikel getArtikel(){
        return artikel;
    }

    @Override
    public String toString(){
        String factuurRegel = String.format("%-25s%8s\n", artikel.getNaam(), "€ " + artikel.getPrijs());
        if(artikel.getKorting().compareTo(BigDecimal.ZERO) > 0){
            factuurRegel += String.format("%33s\n", "- € " + artikel.getKorting());
        }
        return factuurRegel;
    }

}
