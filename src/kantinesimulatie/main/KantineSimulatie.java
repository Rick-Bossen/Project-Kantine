package kantinesimulatie.main;

import kantinesimulatie.kantine.Administratie;
import kantinesimulatie.kantine.Kantine;
import kantinesimulatie.kantine.KantineAanbod;
import kantinesimulatie.kantine.Kassa;
import kantinesimulatie.klant.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    private static final int MIN_ARTIKELEN_PER_SOORT = 10;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("KantineSimulatie");
    private EntityManager manager;


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
        int[] aantal = new int[dagen];
        BigDecimal[] omzet = new BigDecimal[dagen];

        for (int dag = 1; dag <= dagen; dag++) {
            int aantalKlanten = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);
            for (int klant = 1; klant < aantalKlanten; klant++){
                Dienblad dienblad;
                int type = random.nextInt(100) + 1;
                // Kans 1 op 100
                if(type == 1){
                    dienblad = new Dienblad(new KantineMedewerker());
                // Kans 10 op 100 (2 - 11)
                }else if(type <= 11){
                    dienblad = new Dienblad(new Docent());
                // Kans 89 op 100 (> 11)
                }else{
                    dienblad = new Dienblad(new Student());
                }


                int aantalArtikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
                int[] artikelIndexes = getRandomArray(aantalArtikelen, 0, AANTAL_ARTIKELEN - 1);
                String[] artikelen = geefArtikelNamen(artikelIndexes);

                kantine.loopPakSluitAan(dienblad, artikelen);
            }

            kantine.verwerkRijVoorKassa();

            aantal[dag - 1] = kassa.aantalVerkochteArtikelen();
            omzet[dag - 1] = kassa.hoeveelheidGeldInKassa();

            kassa.leegKassa();
        }

        outputAdministratie(dagen, aantal, omzet);
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

    /**
     * Output de berekende gemiddelden.
     * @param dagen Aantal dagen in de simulatie.
     * @param aantal Aantal verkochte producten per dag.
     * @param omzet Omzet per dag.
     */
    private void outputAdministratie(int dagen, int[] aantal, BigDecimal[] omzet){
        System.out.printf("Gemiddelden over %d dagen\n", dagen);
        System.out.printf("Gemmidelde verkochte artikelen: %.2f\n", Administratie.berekenGemiddeldAantal(aantal));
        System.out.printf("Gemiddelde omzet: \u20ac %.2f\n", Administratie.berekenGemiddeldeOmzet(omzet));
        BigDecimal[] omzetPerDag = Administratie.berekenDagOmzet(omzet);
        for (int dag = 0; dag < omzetPerDag.length; dag++){
            String dagVanDeWeek = "maandag";
            switch (dag){
                case 1:
                    dagVanDeWeek = "dinsdag";
                    break;
                case 2:
                    dagVanDeWeek = "woensdag";
                    break;
                case 3:
                    dagVanDeWeek = "donderdag";
                    break;
                case 4:
                    dagVanDeWeek = "vrijdag";
                    break;
                case 5:
                    dagVanDeWeek = "zaterdag";
                    break;
                case 6:
                    dagVanDeWeek = "zondag";
                    break;
            }
            BigDecimal dagOmzet = omzetPerDag[dag];
            System.out.printf("Gemiddelde omzet voor %s: \u20ac %.2f\n", dagVanDeWeek, dagOmzet);
        }
    }

}