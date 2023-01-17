package dataElementsTests;

import java.time.LocalDate;

public class Person {

    private String firstName;
    private String secondName;
    private String surname;
    private char gender;
    private String PESEL;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private String fathersName;
    private String mothersName;
    private Address residenceAddress;
    private Address registeredAddress;
    private LocalDate dateOfDeath;

    public Person(String firstName, String secondName, String surname, char gender,
                  LocalDate dateOfBirth, String placeOfBirth, String fathersName, String mothersName, Address residenceAddress,
                  Address registeredAddress) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.fathersName = fathersName;
        this.mothersName = mothersName;
        this.residenceAddress = residenceAddress;
        this.registeredAddress = registeredAddress;
        this.dateOfDeath = null;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getFirstName() { return firstName; }

    public String getSecondName() {
        return secondName;
    }

    public String getSurname() {
        return surname;
    }

    public char getGender() {
        return gender;
    }

    public String getPESEL() {
        return PESEL;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFathersName() {
        return fathersName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public Address getResidenceAddress() {
        return residenceAddress;
    }

    public Address getRegisteredAddress() {
        return registeredAddress;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setResidenceAddress(Address residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public void setRegisteredAddress(Address registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getPlaceOfBirth() { return placeOfBirth; }
}
