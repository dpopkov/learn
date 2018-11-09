package learn.dsai.ch02arrays.array4;

public class PersonArrayApp {
    public static void main(String[] args) {
        PersonArray arr = new PersonArray(10);
        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Adams", "Henry", 63);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Lamarque", "Henry", 54);
        arr.insert("Vang", "Minh", 22);
        arr.insert("Creswell", "Lucinda", 18);
        arr.display();

        String key = "Stimson";
        Person found = arr.find(key);
        if (found != null) {
            System.out.println("Found " + found);
        } else {
            System.out.println("Can't fine " + key);
        }

        System.out.println("Deleting 3 persons.");
        arr.delete("Smith");
        arr.delete("Yee");
        arr.delete("Creswell");
        arr.display();
    }
}
