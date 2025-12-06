package year2025;

import utilities.FileUtils;
import java.util.ArrayList;

public class dayone {
  public static void main(String[] args) {
      int dialPosition = 50;
      String filePath = "data/2025_01.txt";
      ArrayList<String> testData = FileUtils.readToArrayList(filePath);

      for(String item : testData) {
        char direction = item.charAt(0);
        int distance = Integer.parseInt(item.substring(1));
        String message = String.format("Direction: %s, Distance: %s", direction, distance);
        System.out.println(message);
      }
  }
}
