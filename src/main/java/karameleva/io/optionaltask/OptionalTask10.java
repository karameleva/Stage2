package karameleva.io.optionaltask;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class OptionalTask10 {
    public static void main (String [] args)  {
        String line;
        File resultDirectory = new File ("src/main/resources/results");
        if (!resultDirectory.exists()) {
            try {
                Files.createDirectory(Path.of("src/main/resources/results"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(
                "src/main/resources/InitialDataOptionalTask10.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter(
                     "src/main/resources/results/OptionalTask10.txt"))) {
            while ((line = reader.readLine()) != null) {
                String [] lineAsArray = line.split(" ");
                String buf = lineAsArray [0];
                lineAsArray [0] = lineAsArray [lineAsArray.length-1];
                lineAsArray [lineAsArray.length-1] = buf;
                for (String element : lineAsArray) {
                    writer.write(element + " ");
                }
                writer.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}