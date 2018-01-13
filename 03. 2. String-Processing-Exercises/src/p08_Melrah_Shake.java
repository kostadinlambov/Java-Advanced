import java.util.Scanner;

public class p08_Melrah_Shake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        String pattern = scanner.nextLine();

        StringBuilder sb = new StringBuilder(inputLine);
        StringBuilder sbPattern = new StringBuilder(pattern);

        while (true) {

            int firstMatch = sb.indexOf(sbPattern.toString());

            if (firstMatch == -1 || sbPattern.length() == 0) {
                System.out.println("No shake.");
                break;
            }

            sb.delete(firstMatch, firstMatch + sbPattern.length());

            int lastMatch = sb.lastIndexOf(sbPattern.toString());
            sb.delete(lastMatch, lastMatch + sbPattern.length());

            System.out.println("Shaked it.");

            int index = sbPattern.length()/2;;
            sbPattern.delete(index, index+1);
        }

        System.out.println(sb.toString());
    }
}
