package dataElements;

import application.App;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ReportTest {

    @Mocked
    Person person;
    @Injectable
    Address adresZamieszkania;

    @Test
    void getMeanDeathAge() {
        List<ArchiveEntry> test = new ArrayList<>();

    new Expectations(){
        {
            adresZamieszkania.getPostalCode(); result= test;
        }
    };
        System.out.println(person.getFathersName());
        System.out.println(person.getResidenceAddress().getPostalCode());
        System.out.println(person.getRegisteredAddress().getPostalCode());
    assertEquals(person.getResidenceAddress().getPostalCode(), "97-400");
    }
}