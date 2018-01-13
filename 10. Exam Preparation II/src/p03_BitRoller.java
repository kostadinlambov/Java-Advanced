import java.io.IOException;
import java.util.Scanner;

public class p03_BitRoller {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int fixed = 19 - 1 - Integer.parseInt(scanner.nextLine());
        int rotations = Integer.parseInt(scanner.nextLine());

        StringBuilder sb = new StringBuilder(String.format("%19s", Integer.toBinaryString(number)).replace(' ', '0'));

        char fixedChar = sb.charAt(fixed);
        int last = (fixed == 18) ? 17 : 18;
        int first = (fixed == 0) ? 1 : 0;

        for (int i = 0; i < rotations; i++) {
            sb.insert(first, sb.charAt(last));
            if (first == 0) {
                sb.setCharAt(fixed + 1, sb.charAt(fixed));
            }
            sb.setCharAt(fixed, fixedChar);
            sb.deleteCharAt(19);
        }

        System.out.println(Integer.parseInt(sb.toString(), 2));
    }
}



