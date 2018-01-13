package bitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P07_WaveBits_August_2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputNumber = reader.readLine();
        BigInteger numberBigInteger = new BigInteger(inputNumber);
        String numberBinary = String.format("%64s", numberBigInteger.toString(2))
                .replace(" ", "0");

        StringBuilder sb = new StringBuilder(numberBinary);

        sb.reverse();
        int currentSequenceLength = 1;
        int maxSequenceLength = 0;
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < sb.length() - 2; i++) {
            char currentChar = sb.charAt(i);
            if (currentChar == '1' && sb.charAt(i + 1) == '0' &&
                    sb.charAt(i + 2) == '1') {
                currentSequenceLength += 2;

                if (currentSequenceLength > maxSequenceLength) {
                    maxSequenceLength = currentSequenceLength;
                    endIndex = i + 2;
                    startIndex = endIndex - currentSequenceLength + 1;
                    i++;
                }else{
                    i++;
                }
            } else {
                currentSequenceLength = 1;
            }
        }

        if (maxSequenceLength > 0) {
            sb.delete(startIndex, endIndex + 1);
            sb.reverse();
            BigInteger result = new BigInteger(sb.toString(), 2);
            System.out.println(result.toString());
        } else {
            System.out.println("No waves found!");
        }
    }
}
