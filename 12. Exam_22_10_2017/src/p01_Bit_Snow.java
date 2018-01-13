import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p01_Bit_Snow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");
        int[] numbersArr = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            numbersArr[i] = Integer.parseInt(input[i]);
        }

        int size = 1;
        for (int k = 0; k < numbersArr.length - 1; k++) {
            for (int i = numbersArr.length - 1; i >= size; i--) {
                int firstNumber = numbersArr[i - 1] & numbersArr[i];
                int secondNumber = numbersArr[i] | numbersArr[i - 1];

                numbersArr[i - 1] = firstNumber;
                numbersArr[i] = secondNumber;
            }
            size++;
        }

        System.out.println(Arrays.toString(numbersArr).replaceAll("[\\[\\]]", ""));
    }
}
