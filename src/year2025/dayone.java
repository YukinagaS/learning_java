package year2025;

import utilities.FileUtils;
import java.util.ArrayList;

public class dayone {

  static void turnDial(ArrayList<String> data) {
    int dialPosition = 50;
    int count = 0;

    for(String item : data) {
      char direction = item.charAt(0);
      int distance = Integer.parseInt(item.substring(1));
      String message = String.format("Direction: %s, Distance: %s", direction, distance);
      System.out.println(message);

      if (direction == 'L') {
        int newPosition = (dialPosition - distance + 100) % 100;
        System.out.println("Move from " + dialPosition + " to " + newPosition);
        if (newPosition == 0) count += 1;
        dialPosition = newPosition;
      } else {
        int newPosition = (dialPosition + distance + 100) % 100;
        System.out.println("Move from " + dialPosition + " to " + newPosition);
        if (newPosition == 0) count += 1;
        dialPosition = newPosition;
      }
    }
    System.out.println("Final count: " + count);

  }
  public static void main(String[] args) {
      ArrayList<String> testData = FileUtils.readToArrayList("data/2025_01.txt");
      ArrayList<String> puzzleData = FileUtils.readToArrayList("puzzle/2025_01.txt");

      turnDial(testData);
      turnDial(puzzleData);
  }
}
