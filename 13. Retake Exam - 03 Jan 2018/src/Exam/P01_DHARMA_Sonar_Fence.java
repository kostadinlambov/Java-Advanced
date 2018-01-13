package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P01_DHARMA_Sonar_Fence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
        String inputNumber = reader.readLine();

        if("Reprogram".equalsIgnoreCase(inputNumber)){
            break;
        }

        BigInteger numberBigInteger = new BigInteger(inputNumber);
        String numberBinary = String.format("%32s", numberBigInteger.toString(2))
                .replace(" ", "0");

        StringBuilder sb = new StringBuilder(numberBinary);

        for (int i = 0; i < sb.length() - 1; i++) {
            char currentChar = sb.charAt(i);
            if (currentChar == '1' && sb.charAt(i + 1) == '1') {
                sb.setCharAt(i, '0');
                sb.setCharAt(i + 1, '0');
                i++;
            } else if (currentChar == '0' && sb.charAt(i + 1) == '0') {
                sb.setCharAt(i, '1');
                sb.setCharAt(i + 1, '1');
                i++;
            }
        }

        BigInteger result = new BigInteger(sb.toString(), 2);
        System.out.println(result.toString());

        }
    }
}
