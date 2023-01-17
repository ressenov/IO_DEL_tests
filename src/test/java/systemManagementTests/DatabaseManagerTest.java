package systemManagementTests;

import Data.SampleData;
import dataElementsTests.ArchiveEntry;
import dataElementsTests.Person;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;


public class DatabaseManagerTest {

    DatabaseManager databaseManager = new DatabaseManager();

    @Test
    public void generatePESELTest(){
        Person person = SampleData.returnSamplePerson();

        assertEquals("00300700000", databaseManager.generatePESEL(person));
    }

    @Test
    public void addToArchiveTest(){
        Person person = SampleData.returnSamplePerson();
        Person changedInfoPerson = SampleData.returnSamplePerson();

        changedInfoPerson.setDateOfDeath(LocalDate.of(2022, 12, 31));

        ArchiveEntry archiveEntry = new ArchiveEntry(person, changedInfoPerson,
                LocalDate.of(2023, 1, 1), "Urzednik", "DEATH");

        databaseManager.addToArchive(archiveEntry);

        assertTrue(DatabaseManager.getArchive().contains(archiveEntry));
    }

    @Test
    public void editPersonalDataTest(){
        Person person = SampleData.returnSamplePerson();
        Person changedInfoPerson = SampleData.returnSamplePerson();

        changedInfoPerson.setFirstName("Nowe imie");
        changedInfoPerson.setSurname("Nowe nazwisko");

        databaseManager.editPersonalData(person, changedInfoPerson,
                LocalDate.of(2023, 1, 15), "Urzednik", "CHANGE");

        assertEquals("Nowe imie", person.getFirstName());
        assertEquals("Nowe nazwisko", person.getSurname());

        DatabaseManager.getDatabase().clear();
    }

    @Test
    public void addNewPersonTest(){
        Person person = SampleData.returnSamplePerson();
        databaseManager.addNewPerson(person, LocalDate.of(2023, 1, 15), "Urzednik");

        assertTrue(DatabaseManager.getDatabase().contains(person));

        DatabaseManager.getDatabase().clear();
    }

    @Test
    public void searchPersonTestSuccess(){
        Person person = SampleData.returnSamplePerson();
        databaseManager.addNewPerson(person, LocalDate.of(2023, 1, 15), "Urzednik");

        assertNotNull(databaseManager.searchPerson("00300700000"));

        DatabaseManager.getDatabase().clear();
    }

    @Test
    public void searchPersonTestFail(){
        Person person = SampleData.returnSamplePerson();
        databaseManager.addNewPerson(person, LocalDate.of(2023, 1, 15), "Urzednik");

        assertNull(databaseManager.searchPerson("00000000000"));

        DatabaseManager.getDatabase().clear();
    }
}
