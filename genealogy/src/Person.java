import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Person implements Comparable<Person> {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private SortedSet<Person> children;

    private static DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Person(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.children = new TreeSet<>();
    }

    public Person(String firstName, String lastName, LocalDate birthDate, LocalDate deathDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.children = new TreeSet<>();
        this.deathDate = deathDate;
    }

    public boolean adopt(Person child) {
        return this.children.add(child);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDate +
                ", children=" + children +
                '}';
    }

    public Person getYoungestChild() {
        if (children.isEmpty())
            return null;

        return children.last();
    }

    @Override
    public int compareTo(Person o) {
        return this.birthDate.compareTo(o.birthDate);
    }

    public List<Person> getChildren() {
        List<Person> sortedChildren = new ArrayList<>(children);
        Collections.sort(sortedChildren);
        return sortedChildren;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public static Person fromCsvLine(String line){
        String name;
        String surname;
        String foundBdate;
        String foundDdate;
        String parent1name;
        String parent1surname;
        String parent2name;
        String parent2surname;

        String[] arr = line.split(",");
        // Anna Dąbrowska,07.02.1930,22.12.1991,Ewa Kowalska,Marek Kowalski
        // Anna Dąbrowska | 07.02.1930 | 22.12.1991 | Ewa Kowalska | Marek Kowalski

        String[] nameAndSurname = arr[0].split(" ");

        name = nameAndSurname[0];
        surname = nameAndSurname[1];

        foundBdate = arr[1];
        foundDdate = arr[2];

        nameAndSurname = arr[3].split(" ");

        parent1name = nameAndSurname[0];
        parent1surname = nameAndSurname[1];

        nameAndSurname = arr[4].split(" ");

        parent2name = nameAndSurname[0];
        parent2surname = nameAndSurname[1];

        if(foundDdate.isEmpty()){
            return new Person(name, surname, LocalDate.parse(foundBdate, pattern));
        }
        else{
            return new Person(name, surname,
                    LocalDate.parse(foundBdate, pattern), LocalDate.parse(foundDdate, pattern));
        }
    }

    public static Person methodSubstring(String line) {
        String name;
        String surname;
        String foundBDate;
        String foundDDate;
        String parent1name;
        String parent1surname;
        String parent2name;
        String parent2surname;

        name = line.substring(0, line.indexOf(" "));
        surname = line.substring(line.indexOf(" ") + 1, line.indexOf(","));
        line = line.substring(line.indexOf(",") + 1);
        foundBDate = line.substring(0, line.indexOf(","));
        line = line.substring(line.indexOf(",") + 1);
        foundDDate = line.substring(0, line.indexOf(","));
        line = line.substring(line.indexOf(",") + 1);
        parent1name = line.substring(0, line.indexOf(" "));
        parent1surname = line.substring(line.indexOf(" ") + 1, line.indexOf(","));
        line = line.substring(line.indexOf(",") + 1);
        parent2name = line.substring(0, line.indexOf(" "));
        parent2surname = line.substring(line.indexOf(" ") + 1);

        if(foundDDate.isEmpty()){
            return new Person(name, surname, LocalDate.parse(foundBDate, pattern));
        }
        else{
            return new Person(name, surname,
                    LocalDate.parse(foundBDate, pattern), LocalDate.parse(foundDDate, pattern));
        }
    }

}
