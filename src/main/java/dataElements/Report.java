package dataElements;

import systemManagement.DatabaseManager;

import java.time.LocalDate;
import java.util.List;

public class Report {

    private int numberOfBirths;
    private int numberOfDeaths;
    private String birthToDeathRatio;
    private float meanDeathAge;
    private LocalDate fromDate;
    private LocalDate toDate;
    private LocalDate dateOfCreation;

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public Report(LocalDate fromDate, LocalDate toDate, LocalDate dateOfCreation) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.dateOfCreation = dateOfCreation;
        this.numberOfBirths = calculateNumberOfBirths();
        this.numberOfDeaths = calculateNumberOfDeaths();
        this.meanDeathAge = calculateMeanDeathAge();
        this.birthToDeathRatio = calculateBirthToDeathRatio();
    }

    public int getNumberOfBirths() {
        return numberOfBirths;
    }

    public int getNumberOfDeaths() {
        return numberOfDeaths;
    }

    public String getBirthToDeathRatio() {
        return birthToDeathRatio;
    }

    public float getMeanDeathAge() {
        return meanDeathAge;
    }

    private int calculateNumberOfBirths(){
        List<ArchiveEntry> archive = DatabaseManager.getArchive();

        int births = 0;
        for (ArchiveEntry entry:archive) {
            if(entry.getType().equals("BIRTH") && entry.getDateOfChange().isAfter(fromDate) && entry.getDateOfChange().isBefore(toDate))
                births++;
        }
        return births;
    }

    private int calculateNumberOfDeaths(){
        List<ArchiveEntry> archive = DatabaseManager.getArchive();

        int deaths = 0;
        for (ArchiveEntry entry:archive) {
            if(entry.getType().equals("DEATH") && entry.getDateOfChange().isAfter(fromDate) && entry.getDateOfChange().isBefore(toDate))
                deaths++;
        }
        return deaths;
    }

    private float calculateMeanDeathAge(){
        List<ArchiveEntry> archive = DatabaseManager.getArchive();

        int sumOfAge = 0;
        int amount = 0;
        for (ArchiveEntry entry:archive) {
            if(entry.getType().equals("DEATH") && entry.getDateOfChange().isAfter(fromDate) && entry.getDateOfChange().isBefore(toDate)) {
                amount++;
                sumOfAge += ( entry.getNewData().getDateOfDeath().getYear() - entry.getNewData().getDateOfBirth().getYear() );
            }
        }
        float meanDeathAge = sumOfAge/amount;
        if (amount == 0)
            return 0;
        else
            return meanDeathAge;
    }

    private String calculateBirthToDeathRatio(){
        String ratio = "";
        ratio = numberOfBirths + " : " + numberOfDeaths;
        return ratio;
    }

}
