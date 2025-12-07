package year2025;

import utilities.FileUtils;
import java.util.ArrayList;

public class dayone {

  static void turnDial(ArrayList<String> data) {
    int dialPosition = 50;
    int count = 0;
    int zeroCount = 0; //P2

    for(String item : data) {
      char direction = item.charAt(0);
      int fullSpin = Integer.parseInt(item.substring(1));
      int distance = fullSpin % 100;
      int extraRevs = fullSpin / 100;

      String message = String.format(item + "=> Direction: %s, Distance: %s, Revs: %s", direction, distance, extraRevs);
      System.out.println(message);

      zeroCount += extraRevs; // P2

      if (direction == 'L') {
        int newPosition = (dialPosition - distance + 100) % 100;
        System.out.println("Move from " + dialPosition + " to " + newPosition);
        if (newPosition == 0) count += 1;
        if (dialPosition != 0 && distance >= dialPosition) zeroCount += 1; //P2
        dialPosition = newPosition;
      } else {
        int newPosition = (dialPosition + distance + 100) % 100;
        System.out.println("Move from " + dialPosition + " to " + newPosition);
        if (newPosition == 0) count += 1;
        if (distance + dialPosition >= 100) zeroCount += 1; // P2
        dialPosition = newPosition;
      }
      System.out.println("Zero count: " + zeroCount);
    }
    System.out.println("Final P1 count: " + count);
    System.out.println("Final P2 count: " + zeroCount); // P2
  }
  public static void main(String[] args) {
      ArrayList<String> testData = FileUtils.readToArrayList("data/2025_01.txt");
      ArrayList<String> puzzleData = FileUtils.readToArrayList("puzzle/2025_01.txt");

      // turnDial(testData);
      turnDial(puzzleData);

  }
}
