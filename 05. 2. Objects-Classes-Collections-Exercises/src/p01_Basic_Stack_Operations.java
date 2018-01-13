import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class p01_Basic_Stack_Operations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String[] input = reader.readLine().split("\\s+");
        int numberOfElementsToPush = Integer.parseInt(input[0]);
        int numberOfElementsToPop = Integer.parseInt(input[1]);
        int numberToCheck = Integer.parseInt(input[2]);

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numberOfElementsToPush; i++) {
            stack.push(numbers[i]);
        }
        for (int i = 0; i < numberOfElementsToPop; i++) {
            stack.pop();
        }

        if (!stack.isEmpty()) {
            if (stack.contains(numberToCheck)) {
                System.out.println(true);
            } else {
                sortStackAndPrintMin(stack);
            }
        }else{
            System.out.println(0);
        }
    }

    private static void sortStackAndPrintMin(ArrayDeque<Integer> stack) {

        int[] arr = new int[stack.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
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
