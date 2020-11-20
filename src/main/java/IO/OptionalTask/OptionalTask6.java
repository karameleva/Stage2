package IO.OptionalTask;

// Файл содержит символы, слова, целые числа и числа с плавающей запятой.
// Определить все данные, тип которых вводится из командной строки.

import java.io.*;

public class OptionalTask6 {
    public static void main (String [] args) {
        File file = new File ("src/main/java/IO/OptionalTask/InitialData/InitialDataOptionalTask6.txt");
        String  requiredDataType = args [0];
        String line;
        System.out.println("Тип данных " + requiredDataType + ": ");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine())!= null) {
                String [] array = line.split(" ");
                for (String element : array) {
                    if (getDataType(element).equals(requiredDataType)) {
                        System.out.print(element + " ");
                    }
                }
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

public static String getDataType (String element) {
     Boolean dataTypeIsDefined = true;
     try {
         Integer.parseInt(element);
     } catch (NumberFormatException e) {
         dataTypeIsDefined = false;
     }
     if (!dataTypeIsDefined) {
         dataTypeIsDefined = true;
         try {
             Double.parseDouble(element);
         } catch (NumberFormatException e) {
             dataTypeIsDefined = false;
         }
         if (!dataTypeIsDefined) {
             if (element.length() == 1) return "char";
             else return "String";
         } else return "Double";
     } else return "Integer";
}
}
