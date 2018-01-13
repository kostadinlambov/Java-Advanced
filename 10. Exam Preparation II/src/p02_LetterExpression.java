import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p02_LetterExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputLine = reader.readLine();

        Pattern regex = Pattern.compile("([^\\d-]*)?(?<numbers>\\d+)(?<nonDigits>[^\\d-]*)");
        Matcher matcher = regex.matcher(inputLine);

        List<BigDecimal> numbersList = new ArrayList<>();
        List<String> symbolsList = new ArrayList<>();

        int countNumbers = 0;
        while(matcher.find()){
            countNumbers++;
            BigDecimal number = new BigDecimal(matcher.group("numbers"));
            if(matcher.group(1).length() % 2 != 0){
                number = number.multiply(new BigDecimal(-1));
            }
            String symbols = matcher.group("nonDigits");
            numbersList.add(number);
            symbolsList.add(symbols);
        }

        if(countNumbers == 0){
            System.out.println(0);
            return;
        }
        BigDecimal sum = new BigDecimal(0);
        sum = sum.add(numbersList.get(0));

        for (int i = 1; i < numbersList.size(); i++) {
            int symbolsLength = symbolsList.get(i-1).length();
            if(symbolsLength % 2 == 0){
                sum = sum.add(numbersList.get(i));
            }else{
                sum = sum.subtract(numbersList.get(i));
            }
        }

        DecimalFormat df = new DecimalFormat("#.#######");
        System.out.println(df.format(sum));
    }
}
