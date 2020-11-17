package IO.MainTask;

import java.io.*;


public class Main {
    public static void main (String [] args) throws Exception {
        File dir = new File (args [0]);
           if (dir.exists()){
               if (dir.isDirectory()) {
                   int indent = 1;
                   try (BufferedWriter writer = new BufferedWriter(new FileWriter
                           ("src/main/java/IO/MainTask/FileStructureInSpecifiedDirectory.txt"))) {
                       Methods.writeListOfFilesAndFoldersInDirectoryToFile(dir, indent, writer);
                   }
               } else {
                   Methods.printRequiredDataForSpecifiedFile(dir);
               }
           } else {
                System.out.println("Директория или файл не существуют");
           }
    }
}