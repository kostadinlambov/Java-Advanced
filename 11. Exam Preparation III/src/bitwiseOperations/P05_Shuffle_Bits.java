package bitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P05_Shuffle_Bits {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger firstNumber = new BigInteger(reader.readLine());
        BigInteger secondNumber = new BigInteger(reader.readLine());

        String firstNumberBinary = firstNumber.toString(2);
        String secondNumberBinary = secondNumber.toString(2);

        String firstNumberBinary32Bit = String.format("%32s", firstNumberBinary).replace(" ", "0");
        String secondNumberBinary32Bit = String.format("%32s", secondNumberBinary).replace(" ", "0");

        StringBuilder sb = new StringBuilder();

        if (firstNumberBinary.length() >= secondNumberBinary.length()) {
            for (int i = 0; i < firstNumberBinary32Bit.length(); i++) {
                sb.append(firstNumberBinary32Bit.charAt(i)).append(secondNumberBinary32Bit.charAt(i));
            }
        } else {
            for (int i = 0; i < secondNumberBinary32Bit.length(); i += 2) {
                sb.append(firstNumberBinary32Bit.charAt(i)).append(firstNumberBinary32Bit.charAt(i + 1))
                        .append(secondNumberBinary32Bit.charAt(i)).append(secondNumberBinary32Bit.charAt(i + 1));
            }
        }
        BigInteger result = new BigInteger(sb.toString(), 2);
        System.out.println(result);
    }
}
