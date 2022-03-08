package by.tms.textFormatter.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileOperation {

  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  public FileRead fileRead = new FileRead();
  public FileWrite fileWrite = new FileWrite();
  private String directory = "Task14/src/main/resources/";

  private boolean checkFile(String nameFile) {
    return Files.exists(Path.of(directory + nameFile));
  }

  public class FileRead {

    private void listFileInDir() {
      List<File> listFiles = Arrays.asList(new File(directory).listFiles());
      for (File file : listFiles) {
        System.out.println(file.getName());
      }
    }

    public List<String> readTextFileToList() throws InputError, IOException {
      listFileInDir();
      System.out.println("Введите интересующий вас файл");
      String nameFile = reader.readLine().trim();
      if (checkFile(nameFile)) {
        return Files.readAllLines(Path.of(directory + nameFile));
      } else {
        reader.close();
        throw new InputError("Файл не существует");
      }
    }
  }

  public class FileWrite {

    private void writeFile(List<String> listString, String path) throws IOException {
      FileWriter stringWriter = new FileWriter(String.valueOf(path));
      for (String value : listString) {
        stringWriter.append(value + "\n");
      }
      stringWriter.flush();
      stringWriter.close();
    }

    public void writeListInFile(List<String> listString, String nameFile) throws IOException {
      System.out.println("Заполнение файла.");
      if (checkFile(nameFile)) {
        Files.delete(Path.of(directory + nameFile));
        Path path = Files.createFile(Path.of(directory + nameFile));
        writeFile(listString, String.valueOf(path));
      } else {
        Path path = Files.createFile(Path.of(directory + nameFile));
        writeFile(listString, String.valueOf(path));
      }
    }
  }
}
