package by.tms.listFiles.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RootOperation {

  private List<String> listFile = new ArrayList<>();
  private List<File> listDir = Arrays.asList(new File("D:\\Anna").listFiles());

  public void listFileInDir() {
    for (File dir : listDir) {
      if (dir.isDirectory()) {
        for (File file : dir.listFiles()) {
          if (file.isFile()) {
            listFile.add(file.getAbsoluteFile().getPath());
          } else {
            listDir = Arrays.asList(file.listFiles());
            listFileInDir();
          }
        }
      } else {
        listFile.add(dir.getAbsoluteFile().getPath());
      }
    }
  }

  public void printFiles() {
    for (String path : listFile) {
      System.out.println(path);
    }
  }

  public List<File> getListDir() {
    return listDir;
  }
}
