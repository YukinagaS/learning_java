package year2015;

import java.util.ArrayList;
import utilities.FileUtils;

public class dayone {
  static void floorFinder(String data) {
    int floor = 0;
    for (int i = 0; i < data.length(); i++) {
      if (data.charAt(i) == '(') {
        floor += 1;
      } else {
        floor -= 1;
      }
    }
    System.out.println("Final floor: " + floor);
  }

  static void basementFinder(String data) {
    int floor = 0;
    int answer = 0;
    for (int i = 0; i < data.length(); i++) {
      if (data.charAt(i) == '(') {
        floor += 1;
      } else {
        floor -= 1;
      }
      if (floor == -1) {
        answer = i + 1;
        break;
      }
    }
    System.out.println("Basement at: " + answer);
  }
  public static void main(String[] args) {
    ArrayList<String> testData = FileUtils.readToArrayList("data/2015_01.txt");
    String puzzleData = FileUtils.readToString("puzzle/2015_01.txt").trim();

    // for (String item : testData) {
    //   System.out.println("Input: " + item);
    //   floorFinder(item);
    // }

    floorFinder(puzzleData);
    basementFinder(puzzleData);
  }
}
