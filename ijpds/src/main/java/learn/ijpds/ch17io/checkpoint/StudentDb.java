package learn.ijpds.ch17io.checkpoint;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * The simplest example of RandomAccessFile usage for implementing student database
 * where you can add new students or read existing students info by index.
 */
public class StudentDb implements AutoCloseable {
    private static class IndexRecord {
        private final long start;
        private final long end;

        public IndexRecord(long start, long end) {
            this.start = start;
            this.end = end;
        }

        public long getStart() {
            return start;
        }

        public long getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "IndexRecord{start=" + start + ", end=" + end +'}';
        }
    }

    private static final String DEFAULT_PATH = "io/data/student_db.dat";
    private static final int INDEX_SIZE = 10;

    private final IndexRecord[] index = new IndexRecord[INDEX_SIZE];
    private int numRecords = 0;
    private RandomAccessFile dbFile;
    private boolean changed = false;

    public StudentDb() throws IOException {
        initDbFile();
    }

    private void initDbFile() throws IOException {
        File file = new File(DEFAULT_PATH);
        if (file.exists()) {
            openDbFile(file);
            readIndex();
        } else {
            openDbFile(file);
            writeEmptyIndex();
        }
    }

    private void openDbFile(File file) throws FileNotFoundException {
        dbFile = new RandomAccessFile(file, "rw");
    }

    private void readIndex() throws IOException {
        dbFile.seek(0);
        numRecords = dbFile.readInt();
        for (int i = 0; i < numRecords; i++) {
            long start = dbFile.readLong();
            long end = dbFile.readLong();
            index[i] = new IndexRecord(start, end);
        }
    }

    private void writeEmptyIndex() throws IOException {
        dbFile.writeInt(0);
        for (int i = 0; i < INDEX_SIZE; i++) {
            dbFile.writeLong(0L);
            dbFile.writeLong(0L);
        }
    }

    private void saveIndex() throws IOException {
        dbFile.seek(0);
        dbFile.writeInt(numRecords);
        for (int i = 0; i < numRecords; i++) {
            IndexRecord record = index[i];
            dbFile.writeLong(record.getStart());
            dbFile.writeLong(record.getEnd());
        }
    }

    public int size() {
        return numRecords;
    }

    public void addStudent(Student student) throws IOException {
        dbFile.seek(dbFile.length());
        long start = dbFile.getFilePointer();
        dbFile.writeUTF(student.getName());
        dbFile.writeUTF(student.getMajor());
        long end = dbFile.getFilePointer();
        index[numRecords++] = new IndexRecord(start, end);
        changed = true;
    }

    public Student readStudent(int i) throws IOException {
        IndexRecord record = index[i];
        dbFile.seek(record.getStart());
        String name = dbFile.readUTF();
        String major = dbFile.readUTF();
        return new Student(name, major);
    }

    @Override
    public void close() throws IOException {
        if (changed) {
            saveIndex();
        }
        dbFile.close();
    }

    public static void main(String[] args) throws IOException {
        try (StudentDb db = new StudentDb()) {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;
            while (running) {
                System.out.print("a - add, r - read, v - view info, x - exit: ");
                String answer = scanner.nextLine();
                if ("a".equalsIgnoreCase(answer)) {
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Major: ");
                    String major = scanner.nextLine();
                    db.addStudent(new Student(name, major));
                } else if ("r".equalsIgnoreCase(answer)) {
                    System.out.print("Enter index of student: ");
                    int indexOfStudent = scanner.nextInt();
                    scanner.nextLine();
                    Student student = db.readStudent(indexOfStudent);
                    System.out.println(student);
                } else if ("v".equalsIgnoreCase(answer)) {
                    int dbSize = db.size();
                    System.out.println("size of db = " + dbSize);
                } else if ("x".equalsIgnoreCase(answer)){
                    running = false;
                } else {
                    System.out.println("Invalid option. Try again.");
                }
            }
        }
    }
}
