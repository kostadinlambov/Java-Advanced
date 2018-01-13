import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p03_Recursive_Array_Sum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(sum(arr, 0));
    }

    private static int sum(int[] arr, int index){
        if(index == arr.length-1){
            return arr[index];
        }
        return arr[index] + sum(arr, index+1);
    }
}
