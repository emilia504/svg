import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("Adam", "Nowak", LocalDate.of(2000, 5, 21));
        List<Person> people = new ArrayList<>();
        people.add(person);
        people.add(new Person("Pawel", "Kowalski", LocalDate.of(2003, 2, 10)));
        for (Person value : people) {
            System.out.println(value);
        }

        Person parent = new Person("Piotr", "Nowakowski", LocalDate.of(2000, 5, 21));
        Person child = new Person("Anna", "Kowal", LocalDate.of(2003, 2, 10));
        System.out.println(parent.adopt(child));
        System.out.println(parent.adopt(child));
        System.out.println("Rodzic: " + parent);
        Person child1 = new Person("Jan", "Nowak", LocalDate.of(2010, 6, 13));
        Person child2 = new Person("Daniel", "Nowak", LocalDate.of(2025, 7, 18));
        Person child3 = new Person("Marcin", "Nowak", LocalDate.of(2020, 8, 25));
        parent.adopt(child);
        parent.adopt(child1);
        parent.adopt(child2);
        parent.adopt(child3);
        System.out.println("Rodzic: " + parent);
        System.out.println("Najmłodsze dziecko: " + parent.getYoungestChild());

        System.out.println("\nLista posortowana");
        System.out.println(parent.getChildren());
        for (Person kid : parent.getChildren()) {
            System.out.println(kid);
        }

        System.out.println("Rodzina");
        Family family = new Family();
        family.add(person);
        family.add(child1);
        System.out.println("get Adam Nowak " + family.get("Adam Nowak"));
        System.out.println("get Jan Nowak " + family.get("Jan Nowak"));
        System.out.println("get Piotr Nowakowski " + family.get("Piotr Nowakowski"));

        family.add(parent, child, child1, child2, child3);
        System.out.printf("%s",family.get("Adam Nowak"));
    }

}
