package kantinesimulatie.klant;

import org.junit.Test;

import java.math.BigDecimal;

public class PinpasTest {

    @Test(expected = TeWeinigGeldException.class)
    public void betaalTeVeel() throws TeWeinigGeldException {
       Pinpas pinpas = new Pinpas();
       pinpas.setSaldo(new BigDecimal(100));
       pinpas.setKredietLimiet(new BigDecimal(20));
       pinpas.betaal(new BigDecimal(120.1));
    }

    @Test()
    public void betaalVoldoende() throws TeWeinigGeldException {
        Pinpas pinpas = new Pinpas();
        pinpas.setSaldo(new BigDecimal(100));
        pinpas.setKredietLimiet(new BigDecimal(30));
        pinpas.betaal(new BigDecimal(120.1));
    }
}