import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_HandScore {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputLine = reader.readLine();
        String inputLineAdjustment = inputLine +" JokerP";

        calculateSum(inputLineAdjustment);
    }

    private static void calculateSum(String inputLine) {
        String[] cardsArr = inputLine.split("\\s+");
        int count = 1;
        int totalSum = 0;
        int sum = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < cardsArr.length-1; i++) {
            String cardValue = cardsArr[i].substring(0, cardsArr[i].length()-1);
            String cardSuit = cardsArr[i].substring(cardsArr[i].length()-1, cardsArr[i].length());
            String cardSuitNextCard = cardsArr[i+1].substring(cardsArr[i+1].length()-1, cardsArr[i+1].length());

            if(cardSuit.equalsIgnoreCase(cardSuitNextCard)){
                count++;
            }else{
                endIndex = i;
                startIndex = endIndex -count +1 ;
                sum = calculateCurrentSum(startIndex, endIndex, cardsArr, count);
                count = 1;
                totalSum += sum;
            }
        }
        System.out.println(totalSum);
    }

    private static int calculateCurrentSum(int startIndex, int endIndex, String[] cardsArr, int count) {
        int sum = 0;

        for (int i = startIndex; i <= endIndex; i++) {

            String cardValueString = cardsArr[i].substring(0, cardsArr[i].length()-1);
            String cardSuit = cardsArr[i].substring(cardsArr[i].length()-1, cardsArr[i].length());

            int cardValue = 0;

            switch(cardValueString){
                case "2":
                    cardValue = 2;
                    break;
                case "3":
                    cardValue = 3;
                    break;
                case "4":
                    cardValue = 4;
                    break;
                case "5":
                    cardValue = 5;
                    break;
                case "6":
                    cardValue = 6;
                    break;
                case "7":
                    cardValue = 7;
                    break;
                case "8":
                    cardValue = 8;
                    break;
                case "9":
                    cardValue = 9;
                    break;
                case "10":
                    cardValue = 10;
                    break;
                case "J":
                    cardValue = 12;
                    break;
                case "Q":
                    cardValue = 13;
                    break;
                case "K":
                    cardValue = 14;
                    break;
                case "A":
                    cardValue = 15;
                    break;
            }
            sum += cardValue;
        }
        return sum *= count;
    }
}
