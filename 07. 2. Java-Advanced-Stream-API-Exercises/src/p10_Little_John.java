import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p10_Little_John {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputLines = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            String input = reader.readLine();
            inputLines.add(input);
        }

        Pattern regex = Pattern
                .compile("(?<small>>----->)|(?<medium>>>----->)|(>>>----->>)");

        int countLargeArrows = 0;
        int countMediumArrows = 0;
        int countSmallArrows = 0;

        for(int i = 0 ;i < 4; i++){
            Matcher matcher = regex.matcher(inputLines.get(i));
            while (matcher.find()){
                if(matcher.group("small")!=null){
                    countSmallArrows++;
                }else if(matcher.group("medium")!=null){
                    countMediumArrows++;
                }else{
                    countLargeArrows++;
                }
            }
        }

        StringBuilder numberOfArrows = new StringBuilder();
        numberOfArrows
                .append(countSmallArrows)
                .append(countMediumArrows)
                .append(countLargeArrows);

        String binaryNum = Integer.toBinaryString(Integer.parseInt(numberOfArrows.toString()));

        StringBuilder binaryNumSb = new StringBuilder(binaryNum).reverse();
        binaryNum += binaryNumSb.toString();

        int decimalNum = Integer.parseInt(binaryNum, 2);
        System.out.println(decimalNum);
    }
}
