package kantinesimulatie.main;

import kantinesimulatie.kantine.Kantine;
import kantinesimulatie.kantine.KantineAanbod;
import kantinesimulatie.kantine.Kassa;
import kantinesimulatie.klant.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

public class KantineSimulatie {


    private Kantine kantine;
    private KantineAanbod aanbod;
    private Kassa kassa;

    private Random random;

    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelNamen = new String[]{
        "Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"
    };

    // prijzen
    private static BigDecimal[] artikelPrijzen = new BigDecimal[]{
        new BigDecimal("1.50"),
        new BigDecimal("2.10"),
        new BigDecimal("1.65"),
        new BigDecimal("1.65")
    };

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10000;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20000;

    // minimum en maximum aantal personen per dag
//    private static final int MIN_PERSONEN_PER_DAG = 50;
//    private static final int MAX_PERSONEN_PER_DAG = 100;

    // aantal personen per type (student,docent,medewerker)
    private static final int[] aantalPersonenPerType = {89, 10, 1};

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 10;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 20;

    /**
     * Constructor
     */
    public KantineSimulatie() {
        kantine = new Kantine();
        kassa = kantine.getKassa();
        random = new Random();

        int[] artikelHoeveelheden = getRandomArray(
            AANTAL_ARTIKELEN,
            MIN_ARTIKELEN_PER_SOORT,
            MAX_ARTIKELEN_PER_SOORT
        );

        aanbod = new KantineAanbod(artikelNamen, artikelPrijzen, artikelHoeveelheden);
        kantine.setKantineAanbod(aanbod);
    }

    /**
     * Deze methode simuleert een aantal dagen in het
     * verloop van de kantine
     *
     * @param dagen Aantal dagen die gesimuleert moeten worden.
     */
    public void simuleer(int dagen) {
        for (int dag = 1; dag <= dagen; dag++) {
            int type = 0;
            for (int aantalKlanten : aantalPersonenPerType) {
                for (int klant = 1; klant < aantalKlanten; klant++) {

                    Dienblad dienblad;

                    switch(type) {
                        case 0:
                            dienblad = new Dienblad(new Student());
                            break;
                        case 1:
                            dienblad = new Dienblad(new Docent());
                            break;
                        case 2:
                            dienblad = new Dienblad(new KantineMedewerker());
                            break;
                        default:
                            dienblad = new Dienblad(new Persoon());
                    }

                    int aantalArtikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
                    int[] artikelIndexes = getRandomArray(aantalArtikelen, 0, AANTAL_ARTIKELEN - 1);
                    String[] artikelen = geefArtikelNamen(artikelIndexes);

                    kantine.loopPakSluitAan(dienblad, artikelen);
                }

                kantine.verwerkRijVoorKassa();

                System.out.printf("Dag %d: %d artikelen verkocht met een opbrengst van \u20ac %.2f\n",
                        dag, kassa.aantalVerkochteArtikelen(), kassa.hoeveelheidGeldInKassa());

                kassa.leegKassa();
                type++;
            }
        }
    }

    /**
     * Methode om een array van random getallen liggend tussen
     * min en max van de gegeven lengte te genereren
     *
     * @param lengte Lengte van de array.
     * @param min Minimale waarde van de inidivudele waarde.
     * @param max Maximale waarde van de inidivudele waardes.
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        return random.ints(lengte, min, max).toArray();
    }

    /**
     * Methode om een random getal tussen min(incl)
     * en max(incl) te genereren.
     *
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array
     * artikelNamen de bijhorende array van artikelNamen te maken
     *
     * @param indexes Array met alle indexes.
     * @return De array met artikelNamen
     */
    private String[] geefArtikelNamen(int[] indexes) {
        return Arrays.stream(indexes)
                .mapToObj(integer -> artikelNamen[integer])
                .toArray(String[]::new);
    }

}