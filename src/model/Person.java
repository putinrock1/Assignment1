package model;

/**
 * Person Constructor
 */
public class Person {
    private String firstName;
    private String lastName;
    private String gender;
    private String dob;
    private String ssn;

    /**
     * Person Constructor
     */
    public Person() {
        this.firstName = "John";
        this.lastName = "Doe";
        this.gender = "";
        this.dob = "";
        this.ssn = "";
    }

    /**
     * Person Constructor
     *
     * @param firstName
     * @param lastName
     * @param gender
     * @param dob
     * @param ssn
     */
    public Person(String firstName, String lastName, String gender, String dob, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.ssn = ssn;
    }

    /**
     * @return String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return String
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender String
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return String
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob String
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return String
     */
    public String getSsn() {
        return ssn;
    }

    /**
     * @param ssn String
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
