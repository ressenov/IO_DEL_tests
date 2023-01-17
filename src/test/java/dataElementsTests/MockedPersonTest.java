package dataElementsTests;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockedPersonTest {
    @Mocked
    Person mockedPerson;
    @Injectable
    Address injectedAddress;

    @Test
    public void getResidencePostalCodeTest(){
        new Expectations() {
            {
                injectedAddress.getPostalCode(); result = "123-45";
            }
        };
        assertEquals("123-45", mockedPerson.getResidenceAddress().getPostalCode());
    }

    @Test
    public void getResidenceTownTest(){
        new Expectations() {
            {
                injectedAddress.getTown(); result = "Wroclaw";
            }
        };
        assertEquals("Wroclaw", mockedPerson.getResidenceAddress().getTown());
    }

    @Test
    public void getRegisteredStreetTest(){
        new Expectations() {
            {
                injectedAddress.getStreet(); result = "Grunwaldzka";
            }
        };
        assertEquals("Grunwaldzka", mockedPerson.getRegisteredAddress().getStreet());
    }

    @Test
    void getRegisteredHouseNumberTest(){
        new Expectations() {
            {
                injectedAddress.getHouseNumber(); result = "5";
            }
        };
        assertEquals("5", mockedPerson.getRegisteredAddress().getHouseNumber());
    }

    @Test
    void getRegisteredApartamentNumberTest(){
        new Expectations() {
            {
                injectedAddress.getApartamentNumber(); result = "11";
            }
        };
        assertEquals("11", mockedPerson.getRegisteredAddress().getApartamentNumber());
    }
}
