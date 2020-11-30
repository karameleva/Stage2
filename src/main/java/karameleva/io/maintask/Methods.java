package karameleva.io.maintask;

import java.io.*;

public class Methods {
    public static void writeListOfFilesAndFoldersInDirectoryToFile(File dir, int indent, BufferedWriter writer) {
        try {
            for (int i = 1; i < indent; i += 3) {
                writer.write("  |");
            }
            writer.write("--" + dir.getName());
            writer.newLine();
            indent += 3;
            for (File current : dir.listFiles()) {
                if (current.isFile()) {
                    for (int i = 1; i < indent - 3; i += 3) {
                        writer.write("  |");
                    }
                    writer.write("  |  " + current.getName());
                    writer.newLine();
                }
            }
            for (File current : dir.listFiles()) {
                if (current.isDirectory()) {

                    Methods.writeListOfFilesAndFoldersInDirectoryToFile(current, indent, writer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printRequiredDataForSpecifiedFile(File dir) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dir));
            boolean fileContainsFileStructure = true;
            String line;
            while ((line = reader.readLine()) != null && fileContainsFileStructure) {
                if (!line.contains("|  ") && !line.contains("--")) {
                    fileContainsFileStructure = false;
                }
            }
           reader.close();
            if (fileContainsFileStructure) {

                reader = new BufferedReader(new FileReader(dir));
                int amountOfFolders = 0;
                int amountOfFiles = 0;
                double amountOfFoldersWithFiles = 0;
                double totalNameLengthOfAllFiles = 0;
                String previousLine = null;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("--")) {
                        amountOfFolders++;
                    } else {
                        for (char element : line.toCharArray()) {
                            if (element != ' ' && element != '|' && element != '-') {
                                totalNameLengthOfAllFiles++;
                            }
                        }
                        if (previousLine.contains("--")) {
                            amountOfFiles++;
                            amountOfFoldersWithFiles++;
                        } else {
                            amountOfFiles++;
                        }
                    }
                    previousLine = line;
                }
                System.out.println("Количествово папок " + amountOfFolders);
                System.out.println("Количество файлов " + amountOfFiles);
                System.out.println("Среднее количество файлов в папке " + Math.round((amountOfFiles / amountOfFoldersWithFiles)));
                System.out.println("Средняя длина названия файла " + Math.round(totalNameLengthOfAllFiles / amountOfFiles));
            } else {
                System.out.println("Файл не содержит файловую структуру");
            }
        reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
