package kantinesimulatie.kantine;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AdministratieTest {

    @Test
    public void berekenGemiddeldAantal() {
        int[] aantal = {45, 56, 34, 39, 40, 31};
        assertEquals(Administratie.berekenGemiddeldAantal(aantal),40.8333,0.0001);
    }

    @Test
    public void berekenGemiddeldeOmzet() {
        BigDecimal[] totaal = {BigDecimal.valueOf(567.70), BigDecimal.valueOf(498.25), BigDecimal.valueOf(458.90)};
        assertEquals(Administratie.berekenGemiddeldeOmzet(totaal).doubleValue(),508.28,0.0001);
    }

    @Test
    public void berekendDagOmzet() {
        BigDecimal[] omzet = {BigDecimal.valueOf(321.35), BigDecimal.valueOf(450.50), BigDecimal.valueOf(210.45), BigDecimal.valueOf(190.85), BigDecimal.valueOf(193.25), BigDecimal.valueOf(159.90), BigDecimal.valueOf(214.25), BigDecimal.valueOf(220.90), BigDecimal.valueOf(201.90), BigDecimal.valueOf(242.70), BigDecimal.valueOf(260.35)};
        BigDecimal[] berekendeOmzet = Administratie.berekenDagOmzet(omzet);

        assertEquals(berekendeOmzet[0].doubleValue(),542.25,0.0001);
        assertEquals(berekendeOmzet[1].doubleValue(),652.40,0.0001);
        assertEquals(berekendeOmzet[2].doubleValue(),453.15,0.0001);
        assertEquals(berekendeOmzet[3].doubleValue(),451.20,0.0001);
        assertEquals(berekendeOmzet[4].doubleValue(),193.25,0.0001);
        assertEquals(berekendeOmzet[5].doubleValue(),159.90,0.0001);
        assertEquals(berekendeOmzet[6].doubleValue(),214.25,0.0001);
    }
}