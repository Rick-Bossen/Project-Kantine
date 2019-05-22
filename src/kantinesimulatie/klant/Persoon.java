package kantinesimulatie.klant;

import kantinesimulatie.utility.Datum;

public class Persoon {

    private String BSN;
    private String voornaam;
    private String achternaam;
    private Datum geboorteDatum;
    private char geslacht;

    private static final char MAN = 'M';
    private static final char VROUW = 'V';
    private static final char ANDERS = 'A';
    private static final char ONBEKEND = 'O';

    public Persoon(String BSN, String voornaam, String achternaam, Datum geboorteDatum, char geslacht) {
        this.BSN = BSN;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboorteDatum = geboorteDatum;
        setGeslacht(geslacht);
    }

    public Persoon() {
        BSN = null;
        voornaam = null;
        achternaam = null;
        geboorteDatum = new Datum();
        geslacht = ONBEKEND;
    }

    public String getBSN() {
        return BSN;
    }

    public void setBSN(String BSN) {
        this.BSN = BSN;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getGeboorteDatum() {
        return geboorteDatum.getDatumAsString();
    }

    public void setGeboorteDatum(Datum geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public String getGeslacht() {
        switch(geslacht) {
            case MAN:
                return "Man";
            case VROUW:
                return "Vrouw";
            case ANDERS:
                return "Anders";
            default:
                return "Onbekend";
        }
    }

    public void setGeslacht(char geslacht) {
        if(geslacht == MAN || geslacht == VROUW || geslacht == ANDERS) {
            this.geslacht = geslacht;
        }else{
            this.geslacht = ONBEKEND;
        }
    }

    public String toString(){
        return String.format("%s %s, %s.\n%s\n%s", voornaam, achternaam, BSN, getGeboorteDatum(), getGeslacht());
    }
}
