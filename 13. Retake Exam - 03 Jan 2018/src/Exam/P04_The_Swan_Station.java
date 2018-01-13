package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P04_The_Swan_Station {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int[] theNumbersArr = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::valueOf).toArray();

            ArrayDeque<Integer> theNumbersQueue = new ArrayDeque<>();

            for (int i = 0; i < theNumbersArr.length; i++) {
                theNumbersQueue.addLast(theNumbersArr[i]);
            }

            String[] secondInputLine = reader.readLine().split(" ");

            ArrayDeque<Integer> integersQueue = new ArrayDeque<>();
            for (int i = 0; i < secondInputLine.length; i++) {
                integersQueue.addLast(Integer.parseInt(secondInputLine[i]));
            }

            List<Integer> resultList = new ArrayList<>();

            while (!theNumbersQueue.isEmpty()) {
                int currentInteger = integersQueue.removeFirst();
                int currentFistNumber = theNumbersQueue.peekFirst();

                if (currentInteger % currentFistNumber == 0) {
                    resultList.add(currentInteger);
                    theNumbersQueue.removeFirst();
                } else {
                    currentInteger++;
                    integersQueue.addLast(currentInteger);
                }
            }

            System.out.println(resultList.toString().replaceAll("[\\[\\]]", ""));
    }
}
