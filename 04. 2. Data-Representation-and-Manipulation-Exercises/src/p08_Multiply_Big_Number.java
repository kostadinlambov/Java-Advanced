import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p08_Multiply_Big_Number {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstNumber = reader.readLine();
        String secondNumber = reader.readLine();

        calculateProduct(firstNumber, secondNumber);
    }

    private static void calculateProduct(String firstNumber, String secondNumber) {

        int count = 0;
        String result = "0";

        for (int i = secondNumber.length() - 1; i >= 0; i--) {

            int secondDigit = secondNumber.charAt(i) - '0';
            int reminder = 0;
            StringBuilder calculatedProduct = new StringBuilder();

            for (int j = firstNumber.length() - 1; j >= 0; j--) {

                int firstDigit = firstNumber.charAt(j) - '0';

                int prod = (secondDigit * firstDigit) + reminder;
                int tempNum = prod % 10;
                reminder = prod / 10;
                calculatedProduct.append(tempNum);
            }
            if (reminder != 0) {
                calculatedProduct.append(reminder);
            }

            calculatedProduct.reverse();

            for (int k = 0; k < count; k++) {
                calculatedProduct.append(0);
            }

            result = addDigits(result, calculatedProduct.toString());
            count++;
        }

        StringBuilder resultSb = new StringBuilder(result);

        for (int i = 0; i < resultSb.length(); i++) {
            if(resultSb.charAt(i) == 0){
                resultSb.deleteCharAt(i);
                i--;
            }else{
                break;
            }
        }

        int sum = 0;
        for (int i = 0; i < resultSb.length(); i++) {
            sum = resultSb.charAt(i) - '0';
        }


        if(sum < 1 || secondNumber.charAt(0)-'0' == 0){
            System.out.println(0);
        }else{
            System.out.println(resultSb);
        }
    }


    private static String addDigits(String firstString, String secondString) {

        StringBuilder result = new StringBuilder();

        int i = firstString.length() - 1;
        int j = secondString.length() - 1;
        int reminder = 0;

        while (true) {
            if (i < 0 && j < 0) {
                break;
            }

            int firstDigit = i < 0 ? 0 : firstString.charAt(i--) - '0';
            int secondDigit = j < 0 ? 0 : secondString.charAt(j--) - '0';
            int sum = firstDigit + secondDigit + reminder;

            result.append(sum % 10);
            reminder = sum / 10;
        }

        if (reminder != 0) {
            result.append(reminder);
        }

        return result.reverse().toString();
    }
}



