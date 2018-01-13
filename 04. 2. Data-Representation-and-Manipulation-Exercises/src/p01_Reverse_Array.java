import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p01_Reverse_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbersArr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        reverseArr(numbersArr, 0, numbersArr.length - 1);

        System.out.println(Arrays.toString(numbersArr).replaceAll("[\\[\\],]", ""));
    }

    private static void reverseArr(int[] numbersArr, int startIndex, int endIndex) {
        int base = numbersArr.length / 2;
        if (startIndex == base) {
            return;
        }
        int temp = numbersArr[startIndex];
        numbersArr[startIndex] = numbersArr[endIndex];
        numbersArr[endIndex] = temp;
        reverseArr(numbersArr, startIndex + 1, endIndex - 1);
    }
}
