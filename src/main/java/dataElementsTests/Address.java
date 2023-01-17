package dataElementsTests;

public class Address {

    private String street;
    private String houseNumber;
    private String apartamentNumber;
    private String postalCode;
    private String town;

    public Address(String street, String houseNumber, String apartamentNumber, String postalCode, String town) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartamentNumber = apartamentNumber;
        this.postalCode = postalCode;
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getApartamentNumber() {
        return apartamentNumber;
    }

    public void setApartamentNumber(String apartamentNumber) {
        this.apartamentNumber = apartamentNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
