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

    public String getStudentnummer() {
        return studentnummer;
    }

    public void setStudentnummer(String studentnummer) {
        this.studentnummer = studentnummer;
    }

    public String getStudierichting() {
        return studierichting;
    }

    public void setStudierichting(String studierichting) {
        this.studierichting = studierichting;
    }
}
