import java.util.Scanner;

public class p04_Unicode_Characters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <input.length() ; i++) {

            String unicodeChar = String.format("\\u%04x" ,(int)input.charAt(i));

            sb.append(unicodeChar);
        }

        System.out.println(sb.toString());
    }
}
