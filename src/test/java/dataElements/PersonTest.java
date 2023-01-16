package dataElements;

import Data.Data;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PersonTest {
    Person person = Data.returnSamplePerson();

    @Test
    void getFirstNameTest(){
        assertEquals("Imie", person.getFirstName());
    }

    @Test
    void setFathersNameTest(){
        person.setFirstName("Nowe imie");
        assertEquals("Nowe imie", person.getFirstName());
    }

    @Test
    void getDateOfDeathTest(){
        assertNull(person.getDateOfDeath());
    }

    @Test
    void setDateOfDeathTest(){
        LocalDate dateOfDeath = LocalDate.of(2022, 12, 31);

        person.setDateOfDeath(dateOfDeath);

        assertEquals(dateOfDeath, person.getDateOfDeath());
    }
}
