package IO.OptionalTask;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

//-------------------------------------------------------
//1. Создать и заполнить файл случайными целыми числами.
//Отсортировать содержимое файла по возрастанию.
//-------------------------------------------------------

    public class OptionalTask1 {
        public static void main(String[] args) throws IOException {
            File file = new File("src/main/java/IO/OptionalTask/Results/OptionalTask1.txt");
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

