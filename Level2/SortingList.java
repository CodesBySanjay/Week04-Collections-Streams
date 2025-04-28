import java.util.Collections;
import java.util.List;

class Person {
    String name;
    int age;
    double salary;

    Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}

public class SortingList {
    public static void sortByAge(List<Person> list) {
        Collections.sort(list, (a, b) -> a.age - b.age);
    }
}
