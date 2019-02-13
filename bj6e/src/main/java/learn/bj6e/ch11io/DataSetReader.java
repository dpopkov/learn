package learn.bj6e.ch11io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Reads a data set from a file. The file must have the format:
 * numberOfValues
 * value1
 * value2
 * ...
 */
public class DataSetReader {
    /**
     * Reads a data set.
     * @param filename the name of the file holding the data
     * @return the data in the file
     * @throws FileNotFoundException if file opening failed
     * @throws BadDataException if the format of the data is invalid
     */
    public double[] readFile(String filename) throws FileNotFoundException, BadDataException {
        try (Scanner in = new Scanner(new File(filename))) {
            return readData(in);
        }
    }

    private double[] readData(Scanner in) throws BadDataException {
        if (!in.hasNextInt()) {
            throw new BadDataException("Length expected");
        }
        int numberOfValues = in.nextInt();
        double[] data = new double[numberOfValues];
        for (int i = 0; i < numberOfValues; i++) {
            if (!in.hasNextDouble()) {
                throw new BadDataException("Data value expected");
            }
            data[i] = in.nextDouble();
        }
        if (in.hasNext()) {
            throw new BadDataException("End of file expected");
        }
        return data;
    }
}
