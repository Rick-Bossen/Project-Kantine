package kantinesimulatie.klant;

import kantinesimulatie.utility.Datum;

import java.math.BigDecimal;

public class Docent extends Persoon implements KortingskaartHouder{

    String afkorting;
    String afdeling;

    public Docent(String BSN, String voornaam, String achternaam, Datum geboorteDatum, char geslacht, String afkorting, String afdeling) {
        super(BSN,voornaam,achternaam,geboorteDatum,geslacht);
        setAfkorting(afkorting);
        this.afdeling = afdeling;
    }

    public Docent(){
        super();
    }

    /**
     * Haal de afkorting van de docent op.
     * @return De afkorting.
     */
    public String getAfkorting() {
        return afkorting;
    }

    /**
     * Voeg de afkorting toe van de docent.
     * De afkorting moet 4 karakters zijn.
     * Wanneer dit niet zo is wordt de afkorting niet gezet.
     * @param afkorting Afkorting van de docent.
     * @return Aals de afkorting is toegevoegd.
     */
    public boolean setAfkorting(String afkorting) {
        if(afkorting.length() == 4) {
            this.afkorting = afkorting;
            return true;
        }
        return false;
    }

    /**
     * Haal de afdeling op waar de docent werkt.
     * @return De afdeling van de docent.
     */
    public String getAfdeling() {
        return afdeling;
    }

    /**
     * Voeg de afdeling toe waar de docent werkt.
     * @param afdeling Afdeling van de docent.
     */
    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    /**
     * Methode om kortingspercentage op te vragen
     */
    @Override
    public BigDecimal geefKortingsPercentage() {
        return BigDecimal.valueOf(0.25);
    }

    /**
     * Methode om op te vragen of er maximum per keer aan de korting zit
     */
    @Override
    public boolean heeftMaximum() {
        return true;
    }

    /**
     * Methode om het maximum kortingsbedrag op te vragen
     */
    @Override
    public BigDecimal geefMaximum() {
        return BigDecimal.ONE;
    }
}
