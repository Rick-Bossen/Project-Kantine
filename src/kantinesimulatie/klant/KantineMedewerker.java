package kantinesimulatie.klant;

import kantinesimulatie.utility.Datum;

public class KantineMedewerker extends Persoon {

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

    public String getMedewerkersnummer() {
        return medewerkersnummer;
    }

    public void setMedewerkersnummer(String medewerkersnummer) {
        this.medewerkersnummer = medewerkersnummer;
    }

    public boolean isMagAchterKassa() {
        return magAchterKassa;
    }

    public void setMagAchterKassa(boolean magAchterKassa) {
        this.magAchterKassa = magAchterKassa;
    }
}
