package kantinesimulatie.klant;

import kantinesimulatie.utility.Datum;

public class Student extends Persoon {

    String studentnummer;
    String studierichting;

    public Student(String BSN, String voornaam, String achternaam, Datum geboorteDatum, char geslacht, String studentnummer, String studierichting) {
        super(BSN,voornaam,achternaam,geboorteDatum,geslacht);
        this.studentnummer = studentnummer;
        this.studierichting = studierichting;
    }

    public Student(){
        super();
    }

    /**
     * Haal het student nummer van de student op.
     * @return Het student nummer.
     */
    public String getStudentnummer() {
        return studentnummer;
    }

    /**
     * Zet het student nummer van de student.
     * @param studentnummer Een string die de het student nummer weergeeft.
     */
    public void setStudentnummer(String studentnummer) {
        this.studentnummer = studentnummer;
    }

    /**
     * Haal de studierichting die de student volgt op.
     * @return De studierichting.
     */
    public String getStudierichting() {
        return studierichting;
    }

    /**
     * Voeg de studierichting die de student volgt toe.
     * @param studierichting De studierichting.
     */
    public void setStudierichting(String studierichting) {
        this.studierichting = studierichting;
    }
}
