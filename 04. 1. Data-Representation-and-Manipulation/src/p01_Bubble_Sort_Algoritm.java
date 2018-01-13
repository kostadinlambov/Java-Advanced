import java.util.Arrays;
import java.util.Scanner;

public class p01_Bubble_Sort_Algoritm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean swapped = true;
        do {
            swapped = false;
            for (int i = 0; i < arr.length-1; i++) {

                if (arr[i] > arr[i + 1]) {
                    swap(arr, i+1, i);
                    swapped = true;
                }
            }
        } while (swapped == true);

        System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
    }

    private static void swap(int[] arr, int min, int index) {
        int temp = arr[min];
        arr[min] = arr[index];
        arr[index] = temp;
    }
}

