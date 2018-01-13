import java.util.Scanner;

public class p09_Extract_Bit_from_Integer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int p = scanner.nextInt();

        int maskRight = n >> p;
        int bit = maskRight & 1;

        System.out.println(bit);

        String binaryRepresentationMask = Integer.toBinaryString(maskRight);
        System.out.println(binaryRepresentationMask
                .substring(binaryRepresentationMask.length()-1));
    }
}
