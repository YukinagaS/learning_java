package year2025;

import utilities.FileUtils;
import java.util.stream.LongStream;
import java.util.ArrayList;

public class daytwo {

  static ArrayList<LongStream> processData(String data) {
    String[] allIDs = data.split(",");
    ArrayList<LongStream> result = new ArrayList<LongStream>();
    for (String id : allIDs) {
      String[] idRange = id.split("-");
      long rangeStart = Long.parseLong(idRange[0]);
      long rangeEnd = Long.parseLong(idRange[1].trim());
      result.add(LongStream.rangeClosed(rangeStart, rangeEnd));
    }
    return result;
  }

  static long sumInvalids(ArrayList<LongStream> data) {
    ArrayList<Long> invalidIDs = new ArrayList<Long>();
    Long sum = 0L;

    for (LongStream idRange : data) {
      idRange.forEach(n -> {
        String strN = Long.toString(n);
        String firstHalf = strN.substring(0, strN.length() / 2);
        String lastHalf = strN.substring(strN.length() / 2);
        System.out.println(firstHalf + " vs. " + lastHalf + ": " + (firstHalf.equals(lastHalf)));
        if (firstHalf.equals(lastHalf)) invalidIDs.add(n);
      });
    }

    for (Long item : invalidIDs) {
      sum += item;
    }
    return sum;
  }

  public static void main(String[] args) {
    String testData = FileUtils.readToString("data/2025_02.txt");
    ArrayList<LongStream> testProcessed = processData(testData);
    long sumTest = sumInvalids(testProcessed);

    // String puzzleData = FileUtils.readToString("puzzle/2025_02.txt");
    // ArrayList<LongStream> puzzleProcessed = processData(puzzleData);
    // long sumPuzzle = sumInvalids(puzzleProcessed);


    System.out.println("Test Invalid IDs: " + sumTest);
    // System.out.println("Puzzle Invalid IDs: " + sumPuzzle);
  } // End of main
}
