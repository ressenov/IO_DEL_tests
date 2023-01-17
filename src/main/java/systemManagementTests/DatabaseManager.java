package systemManagementTests;

import dataElementsTests.ArchiveEntry;
import dataElementsTests.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static List<Person> database = new ArrayList<>();
    private static List<ArchiveEntry> archive = new ArrayList<>();

    public DatabaseManager() { }

    public static List<ArchiveEntry> getArchive() {
        return archive;
    }

    public static List<Person> getDatabase() { return database; }

    public void addNewPerson(Person newPerson, LocalDate dateOfChange, String personResponsible){
        newPerson.setPESEL(generatePESEL(newPerson));
        database.add(newPerson);
        addToArchive(new ArchiveEntry(newPerson, newPerson, dateOfChange, personResponsible, "BIRTH"));
    }

    public void editPersonalData(Person toBeChanged, Person newData, LocalDate dateOfChange, String personResponisble, String type){
        toBeChanged.setFirstName(newData.getFirstName());
        toBeChanged.setSecondName(newData.getSecondName());
        toBeChanged.setSurname(newData.getSurname());
        toBeChanged.setResidenceAddress(newData.getResidenceAddress());
        toBeChanged.setRegisteredAddress(newData.getRegisteredAddress());

        addToArchive(new ArchiveEntry(toBeChanged, newData, dateOfChange,personResponisble, type));
    }

    public Person searchPerson(String PESEL){
        for (Person person : database) {
            if(person.getPESEL().equals(PESEL)) return person;
        }
        return null;
    }

    public void printDatabase(){
        for (Person entry : database) {
            System.out.println(entry.getFirstName() + " " + entry.getSecondName() + " " +  entry.getSurname() + " " + entry.getPESEL());
        }
    }


    public String generatePESEL(Person person){
        String PESEL = "";
        LocalDate dateOfBirth = person.getDateOfBirth();
        String year = Integer.toString(dateOfBirth.getYear());
        year = year.substring(year.length() - 2);
        PESEL += year;

        String month;
        if (dateOfBirth.getMonth().getValue() >= 10){
            month = "3" + dateOfBirth.getMonth().getValue() % 10;
        }
        else {
            month = "2" + dateOfBirth.getMonth().getValue();
        }

        PESEL += month;

        String day = Integer.toString(dateOfBirth.getDayOfMonth());
        if (dateOfBirth.getDayOfMonth() < 10) PESEL += "0";

        PESEL += day;

        int index = 0;
        for (Person entry : database) {
            if(entry.getDateOfBirth().equals(dateOfBirth)) index++;
        }
        String ending = String.format("%05d", index);
        PESEL += ending;
        return PESEL;
    }

    public void addToArchive (ArchiveEntry entry){
        archive.add(entry);
    }

    public void printFullPersonalData(Person person){
        printPersonalInfo(person);

        System.out.println("Historia zmian danych dla osoby");
        for (ArchiveEntry entry:archive) {
            if (entry.getOldData().getPESEL().equals(person.getPESEL())){
                System.out.println("ID zmiany: " + entry.getId() +
                        "\nData zmiany: " + entry.getDateOfChange() +
                        "\nOsoba odpowiedzialna za zmiane: " + entry.getPersonResponsible() +
                        "\n Typ zmiany danych: " + entry.getType() + "\n");
            }

        }
    }

    private void printPersonalInfo(Person person){
        System.out.println("\nImie: " + person.getFirstName() +
                "\nDrugie imie: " + person.getSecondName() +
                "\nNazwisko: " + person.getSurname() +
                "\nPlec: " + person.getGender() +
                "\nPESEL: " + person.getPESEL() +
                "\nData urodzenia: " + person.getDateOfBirth() +
                "\nMiejsce urodzenia: " + person.getPlaceOfBirth() +
                "\nImie matki: " + person.getMothersName() +
                "\nImie ojca: " + person.getFathersName() +
                "\nAdres zamieszkania:\nNumer domu: " + person.getResidenceAddress().getHouseNumber() +
                "\nNumer lokalu: " + person.getResidenceAddress().getApartamentNumber() +
                "\nKod pocztowy: " + person.getResidenceAddress().getPostalCode() +
                "\nMiejscowosc: " + person.getResidenceAddress().getTown() +
                "\nAdres zameldowania:\nNumer domu: " + person.getRegisteredAddress().getHouseNumber() +
                "\nNumer lokalu: " + person.getRegisteredAddress().getApartamentNumber() +
                "\nKod pocztowy: " + person.getRegisteredAddress().getPostalCode() +
                "\nMiejscowosc: " + person.getRegisteredAddress().getTown());
        if(!(person.getDateOfDeath() == null)) System.out.println("Data smierci:" + person.getDateOfDeath() + "\n\n");
    }

    public static int getLatestID(){
        if (archive.isEmpty())
            return -1;
        else
            return archive.get(archive.size() - 1).getId();
    }

}
