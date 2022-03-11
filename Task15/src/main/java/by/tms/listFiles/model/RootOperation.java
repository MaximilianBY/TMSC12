package by.tms.listFiles.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RootOperation {

  private String directory = "D:\\Anna";
  private List<String> listFile = new ArrayList<>();
  private List<File> listDir = Arrays.asList(new File(directory).listFiles());

  public void listFileInDir(List<File> directory) {
    for (File dir : directory) {
      if (dir.isDirectory()) {
        for (File file : dir.listFiles()) {
          if (file.isFile()) {
            listFile.add(file.getAbsoluteFile().getPath());
          } else {
            listFileInDir(Arrays.asList(file.listFiles()));
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
