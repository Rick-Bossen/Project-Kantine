package canteensimulation.customer;

import canteensimulation.utility.Date;

public class Person {

    private String BSN;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    private char gender;

    private static final char MALE = 'M';
    private static final char FEMALE = 'V';
    private static final char OTHER = 'O';


    public Person(String BSN, String firstName, String lastName, Date dateOfBirth, char gender){
        this.BSN = BSN;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        setGender(gender);
    }

    public Person(){
        BSN = null;
        firstName = null;
        lastName = null;
        dateOfBirth = new Date();
        gender = OTHER;
    }

    public void setBSN(String BSN) {
        this.BSN = BSN;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(char gender) {
        if(gender == MALE || gender == FEMALE){
            this.gender = gender;
        }else{
            this.gender = OTHER;
        }
    }

    public String getBSN() {
        return BSN;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth.toString();
    }

    public String getGender() {
        switch (gender){
            case MALE:
                return "Female";
            case FEMALE:
                return "Male";
            default:
                return "Other";
        }
    }

    public String toString(){
        return String.format("%s %s, %s.\n%s\n%s", firstName, lastName, BSN, getDateOfBirth(), getGender());
    }

}
