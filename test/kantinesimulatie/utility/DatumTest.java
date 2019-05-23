package kantinesimulatie.utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatumTest {

    @Test
    void bestaatDatum() {
        Datum datum = new Datum();

        // Out of range years
        assertFalse(datum.bestaatDatum(1, 1, 1899));
        assertFalse(datum.bestaatDatum(1, 1, 2101));

        // Out of range months
        assertFalse(datum.bestaatDatum(1, 0, 2000));
        assertFalse(datum.bestaatDatum(1, 13, 2000));

        // Normal dates
        assertTrue(datum.bestaatDatum(31, 1, 2000));
        assertFalse(datum.bestaatDatum(31, 4, 2000));

        // Schikkeljaren
        assertTrue(datum.bestaatDatum(29, 2, 2000));
        assertTrue(datum.bestaatDatum(29, 2, 2004));

        // Geen schikkeljaren
        assertFalse(datum.bestaatDatum(29, 2, 1900));
        assertFalse(datum.bestaatDatum(29, 2, 2001));

    }
}