package kantinesimulatie.kantine;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

public class AdministratieTest {

    @Test
    public void berekenGemiddeldAantal() {
        int[] aantal = {45, 56, 34, 39, 40, 31};
        assertEquals(40.8333, Administratie.berekenGemiddeldAantal(aantal),0.0001);
    }

    @Test
    public void berekenGemiddeldeOmzet() {
        BigDecimal[] totaal = {BigDecimal.valueOf(567.70), BigDecimal.valueOf(498.25), BigDecimal.valueOf(458.90)};
        assertEquals(BigDecimal.valueOf(508.28), Administratie.berekenGemiddeldeOmzet(totaal));
    }

    @Test
    public void berekendDagOmzet() {
        BigDecimal[] omzet = {BigDecimal.valueOf(321.35), BigDecimal.valueOf(450.50), BigDecimal.valueOf(210.45), BigDecimal.valueOf(190.85), BigDecimal.valueOf(193.25), BigDecimal.valueOf(159.90), BigDecimal.valueOf(214.25), BigDecimal.valueOf(220.90), BigDecimal.valueOf(201.90), BigDecimal.valueOf(242.70), BigDecimal.valueOf(260.35)};
        BigDecimal[] berekendeOmzet = Administratie.berekenDagOmzet(omzet);

        assertEquals(BigDecimal.valueOf(542.25), berekendeOmzet[0]);
        assertEquals(BigDecimal.valueOf(652.40).setScale(2, RoundingMode.HALF_EVEN), berekendeOmzet[1]);
        assertEquals(BigDecimal.valueOf(453.15), berekendeOmzet[2]);
        assertEquals(BigDecimal.valueOf(451.20).setScale(2, RoundingMode.HALF_EVEN), berekendeOmzet[3]);
        assertEquals(BigDecimal.valueOf(193.25), berekendeOmzet[4]);
        assertEquals(BigDecimal.valueOf(159.90).setScale(2, RoundingMode.HALF_EVEN), berekendeOmzet[5]);
        assertEquals(BigDecimal.valueOf(214.25), berekendeOmzet[6]);
    }
}