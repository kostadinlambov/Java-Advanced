import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class p03_Basic_Queue_Operations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        String[] input = reader.readLine().split("\\s+");
        int numberOfElementsToPush = Integer.parseInt(input[0]);
        int numberOfElementsToPop = Integer.parseInt(input[1]);
        int numberToCheck = Integer.parseInt(input[2]);

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numberOfElementsToPush; i++) {
            queue.add(numbers[i]);
        }
        for (int i = 0; i < numberOfElementsToPop; i++) {
            queue.remove();
        }

        if(!queue.isEmpty()){
            if (queue.contains(numberToCheck)) {
                System.out.println(true);
            } else {
                sortStackAndPrintMin(queue);
            }
        }else{
            System.out.println(0);
        }

    }

    private static void sortStackAndPrintMin(ArrayDeque<Integer> queue) {
        int[] arr = new int[queue.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.remove();
        }

        boolean swapped = true;
        do {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped == true);

        System.out.println(arr[0]);
    }
}

