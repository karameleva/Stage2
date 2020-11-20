package IO.OptionalTask;

//Прочитать строки из файла и поменять местами
//первое и последнее слова в каждой строке.

import java.io.*;

public class OptionalTask10 {
    public static void main (String [] args) {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/IO/OptionalTask/" +
                "InitialData/InitialDataOptionalTask10.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/IO/OptionalTask/" +
                     "Results/OptionalTask10.txt"))) {
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