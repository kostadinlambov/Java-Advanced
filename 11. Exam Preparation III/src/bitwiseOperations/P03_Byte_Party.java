package bitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03_Byte_Party {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        int[] numbersArr = new int[number];

        for (int i = 0; i < number; i++) {
            numbersArr[i] = Integer.parseInt(reader.readLine());
        }

        while (true){
            String[] tokens = reader.readLine().split("\\s+");
            if("party".equalsIgnoreCase(tokens[0])){
                break;
            }

            String command = tokens[0];
            int position = Integer.parseInt(tokens[1]);

            for (int i = 0; i < numbersArr.length; i++) {
                switch (command){
                    case "0":
                        int maskUnsetBit = ~(1 << position);
                        numbersArr[i] = numbersArr[i] & maskUnsetBit;
                        break;
                    case "1":
                        int maskSetBit = 1 << position;
                        numbersArr[i] = numbersArr[i] | maskSetBit;
                        break;
                    case "-1":
                        int maskToggleBit = 1 << position;
                        numbersArr[i] = numbersArr[i] ^ maskToggleBit;
                        break;
                }
            }
        }

        for (int currentNumber : numbersArr) {
            System.out.println(currentNumber);
        }
    }
}
