import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class p09_The_Stock_Span_Problem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> indexesStack = new ArrayDeque<>();

        int numberOfPrices = Integer.parseInt(reader.readLine());
        int[] pricesArr = new int[numberOfPrices];

        for (int i = 0; i < numberOfPrices; i++) {
            pricesArr[i] = Integer.parseInt(reader.readLine());
        }

        indexesStack.push(0);

        StringBuilder sbSpan = new StringBuilder();
        sbSpan.append(1).append("\n");

        for (int i = 1; i < pricesArr.length; i++) {

            while (!indexesStack.isEmpty() && pricesArr[indexesStack.peek()] <= pricesArr[i]) {
                indexesStack.pop();
            }

            if (indexesStack.isEmpty()) {
                sbSpan.append(i + 1).append("\n");
            } else {
                sbSpan.append(i - indexesStack.peek()).append("\n");
            }

            indexesStack.push(i);
        }

        System.out.print(sbSpan.toString());
    }
}
