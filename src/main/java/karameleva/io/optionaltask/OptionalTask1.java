package karameleva.io.optionaltask;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class OptionalTask1 {
    public static void main(String[] args) throws IOException {
        File resultDirectory = new File ("src/main/resources/results");
        if (!resultDirectory.exists()) {

            new File("src/main/resources/results").mkdir();
        }
        File file = new File("src/main/resources/results/OptionalTask1.txt");
        Random random = new Random();
        int numberOfDigits = random.nextInt(100);
        Integer[] fileAsArray = new Integer[numberOfDigits];
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (int i = 0; i < numberOfDigits; i++) {
                writer.println(random.nextInt(1000));
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (int i = 0; i < numberOfDigits; i++) {
                fileAsArray[i] = Integer.valueOf(reader.readLine());
            }
            Arrays.sort(fileAsArray);
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (int i = 0; i < numberOfDigits; i++) {
                writer.println(fileAsArray[i]);
            }
        }
    }
}

