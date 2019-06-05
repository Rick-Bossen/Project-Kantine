package kantinesimulatie.klant;

import kantinesimulatie.utility.Datum;

import java.math.BigDecimal;

public class KantineMedewerker extends Persoon implements KortingskaartHouder {

    String medewerkersnummer;
    boolean magAchterKassa;

    public KantineMedewerker(String BSN, String voornaam, String achternaam, Datum geboorteDatum, char geslacht, String medewerkersnummer, boolean magAchterKassa) {
        super(BSN,voornaam,achternaam,geboorteDatum,geslacht);
        this.medewerkersnummer = medewerkersnummer;
        this.magAchterKassa = magAchterKassa;
    }

    public KantineMedewerker(){
        super();
    }

    /**
     * Haal het medewerker nummer.
     * @return Het medewerker nummer.
     */
    public String getMedewerkersnummer() {
        return medewerkersnummer;
    }

    /**
     * Zet het medewerker nummer.
     * @param medewerkersnummer Medewerker nummer.
     */
    public void setMedewerkersnummer(String medewerkersnummer) {
        this.medewerkersnummer = medewerkersnummer;
    }

    /**
     * Kijk als de medewerker de kassa mag bedienen.
     * @return Als de medewerker de kassa mag bedienen.
     */
    public boolean magAchterKassa() {
        return magAchterKassa;
    }

    /**
     * Zet als de medewerker achter de kassa mag staan.
     * @param magAchterKassa Boolean als de medewerker achter de kassa mag.
     */
    public void setMagAchterKassa(boolean magAchterKassa) {
        this.magAchterKassa = magAchterKassa;
    }

    /**
     * Methode om kortingspercentage op te vragen
     */
    @Override
    public BigDecimal geefKortingsPercentage() {
        return BigDecimal.valueOf(0.35);
    }

    /**
     * Methode om op te vragen of er maximum per keer aan de korting zit
     */
    @Override
    public boolean heeftMaximum() {
        return false;
    }

    /**
     * Methode om het maximum kortingsbedrag op te vragen
     */
    @Override
    public BigDecimal geefMaximum() {
        return null;
    }
}
