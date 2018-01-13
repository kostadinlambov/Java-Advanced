import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p03_Implement_Binary_Search_using_Recursion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] elements = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int key = Integer.parseInt(reader.readLine());

        Arrays.sort(elements);

        System.out.println(binarySearch(elements, key, 0, elements.length));

    }

    private static int binarySearch(int[] elements, int key, int lo, int hi) {

        if (elements[elements.length - 1] < key) {
            return -1;
        }

        if (hi >= lo) {
            int mid = lo + (hi - lo) / 2;
            if (key < elements[mid]) {
                return binarySearch(elements, key, lo, mid);
            } else if (key > elements[mid]) {
                return binarySearch(elements, key, mid + 1, hi);
            } else {
                return mid;
            }
        }

        return -1;
    }
}
