import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;

public class p06_Reverse_and_Exclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] inputNumbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        int num = Integer.parseInt(reader.readLine());

        BiFunction<Integer[], Integer, ArrayList<Integer>> reverseAndDeleteByNumber = (inputArr, number) -> {
            Integer[] reversedArr = new Integer[inputArr.length];
            for (int i = 0; i < inputArr.length; i++) {
                reversedArr[i] = inputArr[inputArr.length - 1 - i];
            }

            ArrayList<Integer> resultList = new ArrayList<>();
            for (int i = 0; i <reversedArr.length; i++) {
                if(reversedArr[i] % number != 0){
                    resultList.add(reversedArr[i]);
                }
            }
            return  resultList;
        };

        System.out.printf(reverseAndDeleteByNumber.apply(inputNumbers, num)
                .toString()
                .replaceAll("[\\[\\],]", ""));
    }
}
