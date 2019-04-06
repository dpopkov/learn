package learn.jionio.ch03random;

import java.io.IOException;

public class PartsDbUsage {
    public static void main(String[] args) {
        String dbPath = "parts.db";
        if (args.length == 1) {
            dbPath = args[0];
        }
        try (PartsDb pdb = new PartsDb(dbPath)) {
            if (pdb.numRecords() == 0) {
                pdb.append(new Part("1-9009-3323-4x", "Wiper Blade Micro Edge", 30, 2468));
                pdb.append(new Part("1-3233-44923-7j", "Parking Brake Cable", 5, 1439));
                pdb.append(new Part("2-3399-6693-2m", "Halogen Bulb H4 55/60W", 22, 813));
                pdb.append(new Part("2-599-2029-6k", "Turbo Oil Line 0-Ring", 26, 155));
                pdb.append(new Part("3-1299-3299-9u", "Air Pump Electric", 9, 20200));
            }
            dumpRecords(pdb);
            pdb.update(1, new Part("1-3233-44923-7j", "Parking Brake Cable", 5, 1995));
            System.out.println();
            dumpRecords(pdb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dumpRecords(PartsDb pdb) throws IOException {
        for (int i = 0; i < pdb.numRecords(); i++) {
            Part part = pdb.select(i);
            System.out.println(part.format("%s | %s | %d | %d"));
        }
        System.out.println("Number of records = " + pdb.numRecords());
    }
}
