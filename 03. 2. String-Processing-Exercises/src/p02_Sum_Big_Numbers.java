import java.util.Scanner;

public class p02_Sum_Big_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstNumber = scanner.nextLine();
        String secondNumber = scanner.nextLine();

        calculateSum(firstNumber, secondNumber);
    }

    private static void calculateSum(String firstNumber, String secondNumber) {

        String shorterString = firstNumber;
        String longerString = secondNumber;

        if(secondNumber.length() < firstNumber.length()){
            shorterString = secondNumber;
            longerString = firstNumber;
        }

        StringBuilder shorterSb = new StringBuilder(shorterString).reverse();
        StringBuilder longerSb = new StringBuilder(longerString).reverse();
        StringBuilder calculateSum = new StringBuilder();

        int sum = 0;
        int reminder = 0;
        int tempNum = 0;
        for (int i = 0; i < shorterString.length(); i++) {
            sum = shorterSb.charAt(i) - '0' +longerSb.charAt(i) - '0' + reminder;
            if(sum > 9){
                tempNum  = sum % 10;
                reminder = sum /10;
                calculateSum.append(tempNum);
            }else {
                reminder = 0;
                calculateSum.append(sum);
            }
        }

        for (int i = shorterSb.length(); i < longerSb.length(); i++) {
            sum = longerSb.charAt(i) - '0' + reminder;
            if(sum > 9){
                tempNum  = sum % 10;
                reminder = sum /10;
                calculateSum.append(tempNum);
            }else {
                reminder = 0;
                calculateSum.append(sum);
            }
        }
        if(reminder > 0){
            calculateSum.append(reminder);
        }

        System.out.println(calculateSum.reverse().toString());
    }
}