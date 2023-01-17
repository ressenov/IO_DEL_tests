package Data;

import dataElementsTests.Address;
import dataElementsTests.Person;

import java.time.LocalDate;

public class Data {

    public static Person returnSamplePerson(){
         Person person = new Person("Imie", "DrugieImie",
                "Nazwisko", 'M', LocalDate.of(2000, 10, 7),
                "Miasto", "Ojciec", "Matka", returnSampleAddress(), returnSampleAddress() );
         person.setPESEL("00300700000");
        return person;
    }

    public static Address returnSampleAddress(){
        return new Address("Ulica", "Numer domu", "Numer mieszkania", "100-10", "Miasto");
    }
}
