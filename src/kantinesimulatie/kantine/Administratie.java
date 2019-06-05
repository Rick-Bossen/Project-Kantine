package kantinesimulatie.kantine;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Administratie {

    private static final int DAYS_IN_WEEK = 7;

    private  Administratie(){

    }

    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return het gemiddelde
     */
    public static double berekenGemiddeldAantal(int[] aantal) {
        int numberCount = aantal.length;
        double total = 0;

        for(int i = 0; i < numberCount; i++){
            total += aantal[i];
        }
        return total / numberCount;
    }

    /**
     * Deze methode berekent van de BigDecimal array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public static BigDecimal berekenGemiddeldeOmzet(BigDecimal[] omzet) {
        int numberCount = omzet.length;
        BigDecimal total = BigDecimal.ZERO;
        total = total.setScale(2, RoundingMode.HALF_EVEN);

        for(int i = 0; i < numberCount; i++){
            total = total.add(omzet[i]);
        }
        return total.divide(BigDecimal.valueOf(numberCount),2 , RoundingMode.HALF_EVEN);
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static BigDecimal[] berekenDagOmzet(BigDecimal[] omzet) {
        BigDecimal[] temp = new BigDecimal[DAYS_IN_WEEK];

        for(int dagVanWeek = 0; dagVanWeek < DAYS_IN_WEEK; dagVanWeek++) {
            temp[dagVanWeek] = BigDecimal.ZERO;
            temp[dagVanWeek] = temp[dagVanWeek].setScale(2, RoundingMode.HALF_EVEN);

            int weekOffset = 0;

            while (omzet.length > (weekOffset + dagVanWeek)) {
                temp[dagVanWeek] = temp[dagVanWeek].add(omzet[weekOffset + dagVanWeek]);

                weekOffset += DAYS_IN_WEEK;
            }
        }
        return temp;
    }
}
