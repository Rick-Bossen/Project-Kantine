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
}