package canteensimulation.customer;

import canteensimulation.utility.Date;

/**
 * Class representing a person.
 *
 * @version 22.5.2019
 */
public class Person {

    private String BSN;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    private char gender;

    private static final char MALE = 'M';
    private static final char FEMALE = 'F';
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

    /**
     * Sets the BSN of the person
     *
     * @param BSN the BSN to be set
     */
    public void setBSN(String BSN) {
        this.BSN = BSN;
    }

    /**
     * Sets the first name of the person
     *
     * @param firstName the name to be set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of the person
     *
     * @param lastName the name to be set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the date of birth of the person
     *
     * @param dateOfBirth the date of birth to be set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Sets the gender of the person
     *
     * @param gender the gender to be set (M/F/O)
     */
    public void setGender(char gender) {
        if(gender == MALE || gender == FEMALE){
            this.gender = gender;
        }else{
            this.gender = OTHER;
        }
    }

    /**
     * Gets the BSN of the person
     *
     * @return the BSN of the person
     */
    public String getBSN() {
        return BSN;
    }

    /**
     * Gets the first name of the person
     *
     * @return the first name of the person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the person
     *
     * @return the last name of the person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the date of birth of the person
     *
     * @return the date of birth of the person as a String
     */
    public String getDateOfBirth() {
        return dateOfBirth.toString();
    }

    /**
     * Gets the gender of the person
     *
     * @return the gender of the person
     */
    public String getGender() {
        switch (gender){
            case MALE:
                return "Male";
            case FEMALE:
                return "Female";
            default:
                return "Other";
        }
    }

    /**
     * Returns all data about the person in one String
     *
     * @return all personal details
     */
    public String toString(){
        return String.format("%s %s, %s.\n%s\n%s", firstName, lastName, BSN, getDateOfBirth(), getGender());
    }

}
