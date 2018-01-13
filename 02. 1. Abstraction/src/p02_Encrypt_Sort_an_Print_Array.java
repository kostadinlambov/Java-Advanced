import java.util.*;

public class p02_Encrypt_Sort_an_Print_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStrings = Integer.parseInt(scanner.nextLine());
        int[] numbersArr = new int[numberOfStrings];

        for (int i = 0; i < numberOfStrings; i++) {
            String inputString = scanner.nextLine();
            int encryptedString = encryptString(inputString);
            numbersArr[i] = encryptedString;
        }

        Arrays.sort(numbersArr);

        for (int number : numbersArr) {
            System.out.println(number);
        }
    }

    private static int encryptString(String inputString) {

        int sum = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if ( "aeouiAEOUI".contains(inputString.charAt(i)+ "")) {
                sum += inputString.charAt(i) * inputString.length();
            } else {
                sum += inputString.charAt(i) / inputString.length();
            }
        }


        List<Character> vowels = new ArrayList<>();
        Collections.addAll(vowels, 'a', 'e', 'o', 'i', 'u');

        for (int i = 0; i < inputString.length(); i++) {

        }
        return sum;
    }
}
