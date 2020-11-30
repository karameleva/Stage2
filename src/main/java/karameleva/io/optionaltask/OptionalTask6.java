package karameleva.io.optionaltask;

import java.io.*;

public class OptionalTask6 {
    public static void main (String [] args) {
        File file = new File ("src/main/resources/InitialDataOptionalTask6.txt");
        String requiredDataType = args [0];
        String requiredDataTypeToLowerCase = requiredDataType.toLowerCase();
        String line;
        System.out.println("Тип данных " + requiredDataType + ": ");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine())!= null) {
                String [] array = line.split(" ");
                for (String element : array) {
                    if (getDataType(element).equals(requiredDataTypeToLowerCase)) {
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
             else return "string";
         } else return "double";
     } else return "integer";
}
}
