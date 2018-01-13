import java.util.Scanner;

public class p07_Character_Multiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputString = scanner.nextLine().split("\\s+");

        int sum = calculateSumOfCharMultiplier(inputString[0], inputString[1]);

        System.out.println(sum);
    }

    private static int calculateSumOfCharMultiplier(String s, String s1) {

        String shorterString = "";
        String longerString = "";

        if(s.length() <= s1.length()){
            shorterString = s;
            longerString = s1;
        }else{
            shorterString = s1;
            longerString = s;
        }

        int sum = 0;

        for (int i = 0; i < shorterString.length(); i++) {
            sum += shorterString.charAt(i) * longerString.charAt(i);
        }

        for (int i = shorterString.length(); i < longerString.length() ; i++) {
            sum += longerString.charAt(i);
        }

        return sum;
    }
}
