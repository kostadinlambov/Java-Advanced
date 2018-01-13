import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class p02_Binary_Search {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int x = Integer.parseInt(reader.readLine());

        Arrays.sort(arr);
        int index = binarySearch(arr, x, 0, arr.length);
        System.out.println(index);
    }

    private static int binarySearch(int[] arr, int x, int start, int end) {
        if(arr[arr.length-1] < x){
            return -1;
        }
        while (start <= end) {
            int middle = (start + end) / 2;
            if (arr[middle] < x) {
                start = middle + 1;
            } else if (arr[middle] > x) {
                end = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
