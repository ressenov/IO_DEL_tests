package dataElementsTests;

import Data.SampleData;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;


public class PersonTest {
    Person person = SampleData.returnSamplePerson();


    @Test
    public void getFirstNameTest(){
        assertEquals("Imie", person.getFirstName());
    }

    @Test
    public void setFathersNameTest(){
        person.setFirstName("Nowe imie");
        assertEquals("Nowe imie", person.getFirstName());
    }

    @Test
    public void getDateOfDeathTest(){
        assertNull(person.getDateOfDeath());
    }

    @Test
    public void setDateOfDeathTest(){
        LocalDate dateOfDeath = LocalDate.of(2022, 12, 31);

        person.setDateOfDeath(dateOfDeath);

        assertEquals(dateOfDeath, person.getDateOfDeath());
    }

}
