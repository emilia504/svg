import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

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
        this(firstName, lastName, birthDate);

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

    public static Person fromCsvLine(String line) {
        String name;
        String surname;
        String foundBdate;
        String foundDdate;
        String parent1name;
        String parent1surname;
        String parent2name;
        String parent2surname;

        while(line.contains(",,")){
            line = line.substring(0, line.indexOf(",,")) + ",   ," + line.substring(line.indexOf(",,")+2);
        }
        line = line + " ";

        String[] arr = line.split(",");
        // Anna Dąbrowska,07.02.1930,22.12.1991,Ewa Kowalska,Marek Kowalski
        // Anna Dąbrowska | 07.02.1930 | 22.12.1991 | Ewa Kowalska | Marek Kowalski

        String[] nameAndSurname = arr[0].split(" ");

        name = nameAndSurname[0];
        surname = nameAndSurname[1];

        foundBdate = arr[1];
        foundDdate = arr[2];

        if(!arr[3].isBlank()) {
            nameAndSurname = arr[3].split(" ");
            parent1name = nameAndSurname[0];
            parent1surname = nameAndSurname[1];
        }



        if(!arr[4].isBlank())
        {
            nameAndSurname = arr[4].split(" ");

            parent2name = nameAndSurname[0];
            parent2surname = nameAndSurname[1];
        }

        if(foundDdate.isBlank()){
            return new Person(name, surname, LocalDate.parse(foundBdate, pattern));
        }
        else{
            try{
                if (LocalDate.parse(foundDdate, pattern).isBefore(LocalDate.parse(foundBdate, pattern))) throw new NegativeLifespanException("negative lifespan");
                return new Person(name, surname,
                        LocalDate.parse(foundBdate, pattern), LocalDate.parse(foundDdate, pattern));
            }
            catch (NegativeLifespanException exception){
                exception.getMessage();
                System.exit(-1);
                return new Person(name, surname, LocalDate.parse(foundBdate, pattern));
            }

        }
    }

    public static Person methodSubstring(String line) throws NegativeLifespanException {
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
    public static List<Person> fromCsv(String path) throws FileNotFoundException, IOException {
        File f = new File(path);

        BufferedReader fr = new BufferedReader(new FileReader(f));
        List<Person> ret = new ArrayList<Person>();

        fr.readLine();
        String line = fr.readLine();
        while (line != null && !line.isBlank())
        {
            ret.add(fromCsvLine(line));

            line = fr.readLine();
        }

        return ret;
    }
}
