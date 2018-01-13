import java.util.Arrays;
import java.util.Scanner;

public class p01_Selection_Sort_Algoritm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }

        System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
    }

    private static void swap(int[] arr, int min, int index) {
        int temp = arr[min];
        arr[min] = arr[index];
        arr[index] = temp;
    }
}
