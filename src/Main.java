import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
      int dial_position = 50;
      String test_data = "../data/2025_01_test.txt";
      ArrayList<String> test_lines = new ArrayList<>();

      // Read TXT data and store in ArrayList
      try(BufferedReader reader = new BufferedReader(new FileReader(test_data))) {
        String line;
        while ((line = reader.readLine()) != null) {
          test_lines.add(line);
        }
      } catch (IOException e) {
        System.err.println("Error reading file " + e.getMessage());
      }

      for(String line : test_lines) {
        char direction = line.charAt(0);
        int distance = Integer.parseInt(line.substring(1));
        String message = String.format("Direction: %s, Distance: %s", direction, line.substring(1));
        System.out.println(message);
        if (direction == 'L') {
          int new_position = dial_position - distance;
        }

      }
  }
}
