package bitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P08_Wiggle_Wiggle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArr = reader.readLine().split("\\s+");

        for (int i = 0; i < inputArr.length; i += 2) {
            BigInteger firstNum = new BigInteger(inputArr[i]);
            BigInteger secondNum = new BigInteger(inputArr[i + 1]);

            String firstNumBinary = String.format("%64s", firstNum.toString(2))
                    .replace(" ", "0");
            String secondNumBinary = String.format("%64s", secondNum.toString(2))
                    .replace(" ", "0");

            BigInteger one = new BigInteger("1");

            String firstNumBinaryNew = null;
            String secondNumBinaryNew = null;
            for (int j = 63; j >= 0; j -= 2) {
                int currentFirstNumBit = firstNumBinary.charAt(j) - '0';
                int currentSecondNumBit = secondNumBinary.charAt(j) - '0';

                if (currentFirstNumBit != currentSecondNumBit) {
                    firstNum = firstNum.xor(one.shiftLeft(63 - j));
                    secondNum = secondNum.xor(one.shiftLeft(63 - j));

                     firstNumBinaryNew = String.format("%64s", firstNum.toString(2))
                            .replace(" ", "0");
                     secondNumBinaryNew = String.format("%64s", secondNum.toString(2))
                            .replace(" ", "0");
                }
            }

            String firstNumBinaryReversed = null;
            String secondNumBinaryReversed = null;

            for (int j = 62; j >= 0; j--) {
                firstNum = firstNum.xor(one.shiftLeft(62 - j));
                secondNum = secondNum.xor(one.shiftLeft(62 - j));
                firstNumBinaryReversed =  String.format("%63s", firstNum.toString(2))
                        .replace(" ", "0");
                secondNumBinaryReversed = String.format("%63s", secondNum.toString(2))
                        .replace(" ", "0");
            }
            System.out.println(firstNum.toString() + " " + firstNumBinaryReversed);
            System.out.println(secondNum.toString() + " " + secondNumBinaryReversed);
        }
    }
}
