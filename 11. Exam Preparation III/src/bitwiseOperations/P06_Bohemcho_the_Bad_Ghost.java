package bitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class P06_Bohemcho_the_Bad_Ghost {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger totalScore = new BigInteger("0");
        BigInteger countOfLightsOn = new BigInteger("0");

        while(true){
            String input = reader.readLine();
            if("Stop, God damn it".equalsIgnoreCase(input)){
                break;
            }

            BigInteger floorInitialStateNumberBigInteger = new BigInteger(input);

            String floorInitialStateNumber =String.format("%32s",floorInitialStateNumberBigInteger.toString(2))
                    .replace(' ', '0');
            int[] apartmentNumbersToVisit = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            StringBuilder sb = new StringBuilder(floorInitialStateNumber);
            sb.reverse();

            for (int i = 0; i < apartmentNumbersToVisit.length; i++) {
                int roomState = sb.charAt(apartmentNumbersToVisit[i]);

                if(roomState == '0'){
                    sb.setCharAt(apartmentNumbersToVisit[i], '1');
                }else{
                    sb.setCharAt(apartmentNumbersToVisit[i], '0');
                }
            }

            for (int i = 0; i < 32; i++) {
                if(sb.charAt(i)=='1'){
                    countOfLightsOn =  countOfLightsOn.add(new BigInteger("1"));
                }
            }

            totalScore = totalScore.add(new BigInteger(sb.reverse().toString(),2));
        }

        System.out.printf("Bohemcho left %s lights on and his score is %s",
                countOfLightsOn.toString(), totalScore.toString());
    }
}
