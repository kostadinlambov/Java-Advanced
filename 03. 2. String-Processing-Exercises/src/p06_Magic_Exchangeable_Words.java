import java.util.Scanner;
import java.util.TreeMap;

public class p06_Magic_Exchangeable_Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        checkWords(input);
    }

    private static void checkWords(String[] input) {

        TreeMap<Character, Character> charMap = new TreeMap<>();

        String shorterWord = input[0];
        String longerWord = input[1];

        if (input[1].length() < input[0].length()) {
            shorterWord = input[1];
            longerWord = input[0];
        }

        for (int i = 0; i < shorterWord.length(); i++) {
            if (!charMap.containsKey(shorterWord.charAt(i))) {
                charMap.put(shorterWord.charAt(i), longerWord.charAt(i));
            } else if (charMap.get(shorterWord.charAt(i)) != longerWord.charAt(i)) {
                System.out.println(false);
                return;
            }
        }

        int firstWordCharSize = charMap.size();
        String secondWord = "";

        for (int i = 0; i < longerWord.length(); i++) {
            if (!secondWord.contains(longerWord.charAt(i) + "")) {
                secondWord += longerWord.charAt(i);
            }
        }


        if (firstWordCharSize == secondWord.length()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
