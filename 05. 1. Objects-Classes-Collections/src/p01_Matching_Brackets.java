import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p01_Matching_Brackets {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            int index = i;
            if (input.charAt(i) == '(') {
                stack.push(index);
            } else if (input.charAt(i) == ')') {
                int startIndex = stack.pop();

                String expression = input.substring(startIndex, index + 1);
                System.out.println(expression);
            }
        }
    }
}
