import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p07_Find_the_Missing_Number {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfIntegers = Integer.parseInt(reader.readLine());

        int[] intArray = Arrays.stream(reader.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        findMissingNumber(intArray, numberOfIntegers);
    }

    private static void findMissingNumber(int[] intArray, int numberOfIntegers) {

        int expectedSum = numberOfIntegers * (numberOfIntegers + 1) / 2;
        int calculatedSum = 0;
        for (int i = 0; i < numberOfIntegers - 1; i++) {
            calculatedSum += intArray[i];
        }

        int missingNumber = expectedSum - calculatedSum;
        System.out.println(missingNumber);
    }
}
