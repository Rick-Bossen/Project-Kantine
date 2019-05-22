package canteensimulation.utility;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class representing the available dates.
 *
 * @version 22.05.2019
 */
public class Date {

    private final int MIN_YEAR = 1900;
    private final int MAX_YEAR = 2100;

    private int date;
    private int month;
    private int year;

    /**
     * Create a date and set it if valid
     *
     * @param date Date of the month
     * @param month Month of the year
     * @param year Year
     */
    public Date(int date, int month, int year){
        this();
        if(dateIsValid(date, month, year)){
            this.date = date;
            this.month = month;
            this.year = year;
        }
    }

    /**
     * Create a default date
     */
    public Date(){
        date = 0;
        month = 0;
        year = 0;
    }

    /**
     * Return the current year.
     *
     * @return the year.
     */
    public int getYear() {
        return year;
    }

    /**
     * Set the current year.
     * @param year int representing the current year.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Return the current month.
     *
     * @return the month.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Set the current month.
     * @param month int representing the current month.
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Return the current date.
     *
     * @return the date.
     */
    public int getDate() {
        return date;
    }

    /**
     * Set the current date.
     * @param date int representing the current month.
     */
    public void setDate(int date) {
        this.date = date;
    }

    /**
     * Validate date.
     * @param date Date of month to check.
     * @param month Month of year to check.
     * @param year Year to check.
     *
     * @return If the date is valid.
     */
    private boolean dateIsValid(int date, int month, int year){
        if(year < MIN_YEAR || year > MAX_YEAR || month < 1 || month > 12){
            return false;
        }

        int maxDate = 31;
        switch (month){
            case 2:
                if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
                    maxDate = 29;
                }else{
                    maxDate = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                maxDate = 30;
                break;
        }

        return date >= 1 && date <= maxDate;
    }

    /**
     * Return the date if valid.
     *
     * @return Date
     */
    public String toString(){
        if(dateIsValid(date, month, year)){
            return String.format("%d-%d-%d", date, month, year);
        }
        return "Unknown";
    }

}

