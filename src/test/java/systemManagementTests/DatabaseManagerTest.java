package systemManagementTests;

import Data.Data;
import dataElementsTests.ArchiveEntry;
import dataElementsTests.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseManagerTest {

    DatabaseManager databaseManager = new DatabaseManager();

    @Test
    void generatePESELTest(){
        Person person = Data.returnSamplePerson();

        assertEquals("00300700000", databaseManager.generatePESEL(person));
    }

    @Test
    void addToArchiveTest(){
        Person person = Data.returnSamplePerson();
        Person changedInfoPerson = Data.returnSamplePerson();

        changedInfoPerson.setDateOfDeath(LocalDate.of(2022, 12, 31));

        ArchiveEntry archiveEntry = new ArchiveEntry(person, changedInfoPerson,
                LocalDate.of(2023, 1, 1), "Urzednik", "DEATH");

        databaseManager.addToArchive(archiveEntry);

        assertTrue(DatabaseManager.getArchive().contains(archiveEntry));
    }

    @Test
    void editPersonalDataTest(){
        Person person = Data.returnSamplePerson();
        Person changedInfoPerson = Data.returnSamplePerson();

        changedInfoPerson.setFirstName("Nowe imie");
        changedInfoPerson.setSurname("Nowe nazwisko");

        databaseManager.editPersonalData(person, changedInfoPerson,
                LocalDate.of(2023, 1, 15), "Urzednik", "CHANGE");

        assertEquals("Nowe imie", person.getFirstName());
        assertEquals("Nowe nazwisko", person.getSurname());

        DatabaseManager.getDatabase().clear();
    }

    @Test
    void addNewPersonTest(){
        Person person = Data.returnSamplePerson();
        databaseManager.addNewPerson(person, LocalDate.of(2023, 1, 15), "Urzednik");

        assertTrue(DatabaseManager.getDatabase().contains(person));

        DatabaseManager.getDatabase().clear();
    }

    @Test
    void searchPersonTestSuccess(){
        Person person = Data.returnSamplePerson();
        databaseManager.addNewPerson(person, LocalDate.of(2023, 1, 15), "Urzednik");

        assertNotNull(databaseManager.searchPerson("00300700000"));

        DatabaseManager.getDatabase().clear();
    }

    @Test
    void searchPersonTestFail(){
        Person person = Data.returnSamplePerson();
        databaseManager.addNewPerson(person, LocalDate.of(2023, 1, 15), "Urzednik");

        assertNull(databaseManager.searchPerson("00000000000"));

        DatabaseManager.getDatabase().clear();
    }
}
