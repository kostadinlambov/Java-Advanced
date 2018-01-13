import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class p05_Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = scanner.nextLine().split("[,.?!\\s+]+");

        Set<String> palindromes = new TreeSet<>();

        String reversedString;

        for (int i = 0; i < inputLine.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(inputLine[i]);
            reversedString = sb.reverse().toString();

            if(inputLine[i].equals(reversedString)){
                palindromes.add(inputLine[i]);
            }
        }

        System.out.println(palindromes.toString());
    }
}
