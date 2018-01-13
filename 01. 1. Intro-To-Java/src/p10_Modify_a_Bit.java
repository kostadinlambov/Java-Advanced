import java.util.Scanner;

public class p10_Modify_a_Bit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int v = scanner.nextInt();

        if (v == 0) {
            int mask = ~(1 << p);
            int result = n & mask;

            System.out.println(mask);
            System.out.println(result);

            String binaryRepresentationMask = Integer.toBinaryString(result);
            System.out.println(binaryRepresentationMask);
        } else {
            int mask = 1 << p;
            int result = n | mask;

            System.out.println(mask);
            System.out.println(result);

            String binaryRepresentationMask = Integer.toBinaryString(result);
            System.out.println(binaryRepresentationMask);
        }
    }
}
