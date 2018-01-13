package bitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02_Modify_a_Bit {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = reader.readLine().split("\\s+");

        int number = Integer.parseInt(numbers[0]);
        int position = Integer.parseInt(numbers[1]);
        int bitToSet = Integer.parseInt(numbers[2]);

        if(bitToSet == 0){
            int mask = ~(1 << position);
            int result = number & mask;
            System.out.println(result);
        }else if(bitToSet == 1){
            int mask = 1 << position;
            int result = number | mask;
            System.out.println(result);
        }
    }
}
