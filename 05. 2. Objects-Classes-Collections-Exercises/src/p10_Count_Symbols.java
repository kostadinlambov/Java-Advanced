import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class p10_Count_Symbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Character, Integer> symbolsCounter = new TreeMap<>();

        String input = reader.readLine();

        for (int i = 0; i < input.length(); i++) {

            if(symbolsCounter.containsKey(input.charAt(i))){
                symbolsCounter.put(input.charAt(i), symbolsCounter.get(input.charAt(i))+ 1);
            }else{
                symbolsCounter.put(input.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> character : symbolsCounter.entrySet()) {
            System.out.printf("%s: %d time/s%n", character.getKey(), character.getValue());
        }
    }
}
