import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.stream.Collectors;

public class p03_Little_Alchemy {

    private static int GOLDCOUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Integer[] sequenceOfStones = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);


        Deque<Integer> stonesQueue = new ArrayDeque<>();
        Collections.addAll(stonesQueue, sequenceOfStones);


        while (true) {

            String[] tokens = reader.readLine().split("\\s+");

            if ("Revision".equalsIgnoreCase(tokens[0])) {
                break;
            }

            String commnand = tokens[0];

            switch (commnand) {
                case "Apply":
                    int numberOfAcidDoses = Integer.parseInt(tokens[2]);
                    if (stonesQueue.size() > 0) {
                        applyAcid(numberOfAcidDoses, stonesQueue);
                    }
                    break;

                case "Air":
                    int airLeakAmount = Integer.parseInt(tokens[2]);
                    if(GOLDCOUNT > 0){
                        airLeak(airLeakAmount, stonesQueue);
                    }
                    break;
            }
        }
        String stringSequenceToPrint = stonesQueue.stream().map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(stringSequenceToPrint);


        System.out.println(GOLDCOUNT);
    }

    private static void airLeak(int airLeakAmount, Deque<Integer> stonesQueue) {
        if (airLeakAmount > 0 && GOLDCOUNT > 0) {
            stonesQueue.addLast(airLeakAmount);
            GOLDCOUNT--;
        }
    }

    private static void applyAcid(int numberOfAcidDoses, Deque<Integer> stonesQueue) {

        for (int i = 0; i < numberOfAcidDoses; i++) {
            if(stonesQueue.size() > 0){
                int firstStone = stonesQueue.removeFirst();
                firstStone--;
                if (firstStone > 0) {
                    stonesQueue.addLast(firstStone);
                } else {
                    GOLDCOUNT++;
                }
            }

        }
    }
}
