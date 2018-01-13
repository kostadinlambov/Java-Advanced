import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class p02_Linear_Search {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int x = Integer.parseInt(reader.readLine());

        int index = linearSearch(arr, x);

        System.out.println(index);
    }

    static int linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == x){
                return i;
            }
        }
        return -1;
    }
}
