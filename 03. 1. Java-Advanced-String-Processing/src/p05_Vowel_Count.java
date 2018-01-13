

import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class p05_Vowel_Count {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern regex = Pattern.compile("[aeiouyAEUIOY]");
        Matcher matcher = regex.matcher(input);

        int count = 0;
        while(matcher.find()){
            count++;
        }
        System.out.printf("Vowels: %d", count);
    }
}
