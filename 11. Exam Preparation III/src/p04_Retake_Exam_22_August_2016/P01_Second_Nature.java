package p04_Retake_Exam_22_August_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P01_Second_Nature {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] flowersInput = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

        Integer[] bucketsInput = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);


        Deque<Integer> flowersQueue = new ArrayDeque<>(Arrays.asList(flowersInput));
        Deque<Integer> bucketsQueue = new ArrayDeque<>(Arrays.asList(bucketsInput));

        List<Integer> secondNatureFlowers = new ArrayList<>();

        int currentFlowerValue = 0;
        int currentBucketValue = 0;

        while (!bucketsQueue.isEmpty() && !flowersQueue.isEmpty()) {

            int firstFlowerValue = flowersQueue.removeFirst();
            int firstBucketValue = bucketsQueue.removeLast();

            currentFlowerValue += firstFlowerValue;
            currentBucketValue += firstBucketValue;

            if (currentFlowerValue == currentBucketValue) {
                secondNatureFlowers.add(currentFlowerValue);
                currentFlowerValue = 0;
                currentBucketValue = 0;
                continue;
            }

            if (currentFlowerValue > currentBucketValue) {
                currentFlowerValue -= currentBucketValue;
                flowersQueue.addFirst(currentFlowerValue);
                currentBucketValue = 0;
            } else {
                currentBucketValue -= currentFlowerValue;
                currentFlowerValue = 0;
            }
        }

        if (flowersQueue.isEmpty()) {
            if(bucketsQueue.isEmpty()){
                bucketsQueue.addLast(currentBucketValue);
            }else{
                int firstBucketValue = bucketsQueue.removeLast();
                firstBucketValue += currentBucketValue;
                bucketsQueue.addLast(firstBucketValue);
            }
            List<Integer> bucketsListToPrint = new ArrayList<>();
            while (!bucketsQueue.isEmpty()) {
                bucketsListToPrint.add(bucketsQueue.removeLast());
            }


           System.out.println(bucketsListToPrint.toString().replaceAll("[\\[\\],]",""));
        } else {
            flowersQueue.addFirst(currentFlowerValue);
            System.out.println(flowersQueue.toString());
        }

        if (secondNatureFlowers.size() > 0) {
            System.out.println(secondNatureFlowers.toString().replaceAll("[\\[\\],]",""));
        } else {
            System.out.println("None");
        }

    }
}
