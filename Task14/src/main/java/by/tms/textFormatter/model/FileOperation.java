package by.tms.textFormatter.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileOperation {

  private static final String DIRECTORY = "Task14/src/main/resources/";

  private static boolean checkExistsFile(String nameFile) {
    return Files.exists(Path.of(DIRECTORY + nameFile));
  }

  private static void listFileInDir() {
    List<File> listFiles = Arrays.asList(new File(DIRECTORY).listFiles());
    for (File file : listFiles) {
      System.out.println(file.getName());
    }
  }

  public static class FileRead {

    public List<String> readTextFileToList() throws InputError, IOException {
      listFileInDir();
      System.out.println("Введите интересующий вас файл");
      Scanner scanner = new Scanner(System.in);
      String nameFile = scanner.nextLine().trim();
      if (checkExistsFile(nameFile)) {
        return Files.readAllLines(Path.of(DIRECTORY + nameFile));
      } else {
        throw new InputError("Файл " + nameFile + " не существует");
      }
    }
  }

  public static class FileWrite {

    public void writeListInFile(List<String> listString, String nameFile) throws IOException {
      System.out.println("Заполнение файла.");
      if (checkExistsFile(nameFile)) {
        Files.delete(Path.of(DIRECTORY + nameFile));
        writeDataToFile(listString, nameFile);
      } else {
        writeDataToFile(listString, nameFile);
      }
    }

    private void writeDataToFile(List<String> listString, String nameFile) throws IOException {
      Path path = Files.createFile(Path.of(DIRECTORY + nameFile));
      try (FileWriter stringWriter = new FileWriter(String.valueOf(path))) {
        for (String value : listString) {
          stringWriter.append(value + "\n");
        }
        stringWriter.flush();
      }
    }
  }
}
