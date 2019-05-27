package kantinesimulatie.klant;

import kantinesimulatie.utility.Datum;

public class Docent extends Persoon {

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

    public String getAfkorting() {
        return afkorting;
    }

    public void setAfkorting(String afkorting) {
        if(afkorting.length() == 4) {
            this.afkorting = afkorting;
        }
    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }
}
