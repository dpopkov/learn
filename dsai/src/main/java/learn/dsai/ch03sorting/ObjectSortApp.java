package learn.dsai.ch03sorting;

import learn.dsai.ch02arrays.array4.Person;

import java.util.Comparator;

@SuppressWarnings("SpellCheckingInspection")
public class ObjectSortApp {
    public static void main(String[] args) {
        ArrayInOb<Person> arr = new ArrayInOb<>(10);
        arr.insert(new Person("Evans", "Patty", 24));
        arr.insert(new Person("Smith", "Doc", 59));
        arr.insert(new Person("Smith", "Lorraine", 37));
        arr.insert(new Person("Smith", "Paul", 37));
        arr.insert(new Person("Yee", "Tom", 43));
        arr.insert(new Person("Hashimoto", "Sato", 21));
        arr.insert(new Person("Stimson", "Henry", 29));
        arr.insert(new Person("Velasquez", "Jose", 72));
        arr.insert(new Person("Vang", "Minh", 22));
        arr.insert(new Person("Creswell", "Lucinda", 18));

        System.out.println("Before sorting:");
        arr.display();

        System.out.println("\nAfter sorting:");
        arr.insertionSort(Comparator.comparing(Person::getLastName));
        arr.display();
    }
}
