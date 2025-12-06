package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtils {

  public static ArrayList<String> readToArrayList(String filePath) {
    ArrayList<String> data = new ArrayList<>();

    try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        data.add(line);
      }
    } catch (IOException e) {
      System.err.println("Error reading file " + e.getMessage());
    }

    return data;
  }

  public static String readToString(String filePath) {
    StringBuilder data = new StringBuilder();

    try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        data.append(line).append("\n");
      }
    } catch (IOException e) {
      System.err.println("Error reading file " + e.getMessage());
    }

    return data.toString();
  }
}
