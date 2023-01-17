package systemManagementTests;

import Data.SampleData;
import dataElementsTests.ArchiveEntry;
import dataElementsTests.Person;
import dataElementsTests.Report;
import org.junit.Test;
import static org.junit.Assert.*;
import mockit.Expectations;
import mockit.Mocked;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DocumentManagerTest {
    DocumentManager documentManager = new DocumentManager();

    @Mocked
    DatabaseManager databaseManager;

    @Test
    public void generateReportTest(){
        List<ArchiveEntry> archiveMock = new ArrayList<>();

        Person personBorn = SampleData.returnSamplePerson();

        ArchiveEntry entryBirth = new ArchiveEntry(personBorn, personBorn,
                LocalDate.of(2022, 6, 6), "Urzednik", "BIRTH");
        archiveMock.add(entryBirth);

        Person personDead1 = SampleData.returnSamplePerson();

        personDead1.setDateOfDeath(LocalDate.of(2060, 1, 1));
        ArchiveEntry entryDeath1 = new ArchiveEntry(personDead1, personDead1,
                LocalDate.of(2022, 6, 6), "Urzednik", "DEATH");
        archiveMock.add(entryDeath1);

        Person personDead2 = SampleData.returnSamplePerson();

        personDead2.setDateOfDeath(LocalDate.of(2070, 1, 1));
        ArchiveEntry entryDeath2 = new ArchiveEntry(personDead2, personDead2,
                LocalDate.of(2022, 6, 6), "Urzednik", "DEATH");
        archiveMock.add(entryDeath2);


        new Expectations(){
            {
                DatabaseManager.getArchive(); result= archiveMock;
            }
        };

        Report report = documentManager.generateReport(LocalDate.of(2022, 1, 1),
                LocalDate.of(2023, 1, 1), LocalDate.of(2022, 1, 17));

        assertEquals(1, report.getNumberOfBirths());
        assertEquals(2, report.getNumberOfDeaths());
        assertEquals(65, report.getMeanDeathAge(), 0.01);
        assertEquals("1 : 2", report.getBirthToDeathRatio());
    }

}
