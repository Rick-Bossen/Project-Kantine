package kantinesimulatie.klant;

import org.junit.Test;

import java.math.BigDecimal;

public class ContantTest {

    @Test(expected = TeWeinigGeldException.class)
    public void betaalTeVeel() throws TeWeinigGeldException {
        Contant portemonnee = new Contant();
        portemonnee.setSaldo(new BigDecimal(100));
        portemonnee.betaal(new BigDecimal(100.1));
    }

    @Test()
    public void betaalVoldoende() throws TeWeinigGeldException {
        Contant portemonnee = new Contant();
        portemonnee.setSaldo(new BigDecimal(130));
        portemonnee.betaal(new BigDecimal(120));
    }

}