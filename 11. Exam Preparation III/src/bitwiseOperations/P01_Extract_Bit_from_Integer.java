package bitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01_Extract_Bit_from_Integer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] numbers = reader.readLine().split("\\s+");

        int number = Integer.parseInt(numbers[0]);
        String numberBinary = String.format("%8s", Integer.toBinaryString(number))
                .replace(" ", "0");
        System.out.println("numberBinary: " + numberBinary);

        int position = Integer.parseInt(numbers[1]);
        String positionBinary = String.format("%8s", Integer.toBinaryString(position))
                .replace(" ", "0");
        System.out.println("position: " + position);
        System.out.println("positionBinary: " + positionBinary);

        int maskRight = number >> position;
        String maskBinary = String.format("%8s", Integer.toBinaryString(maskRight))
                .replace(" ", "0");
        System.out.println("maskBinary: " + maskBinary);

        int bit = maskRight & 1;
        String bitBinary = String.format("%8s", Integer.toBinaryString(bit))
                .replace(" ", "0");
        System.out.println("resultBitBinary: " + bitBinary);

        System.out.printf("Bit at position %d is %d%n", position, bit);

    }
}
