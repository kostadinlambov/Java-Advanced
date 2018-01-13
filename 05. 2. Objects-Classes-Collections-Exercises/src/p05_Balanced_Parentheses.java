import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p05_Balanced_Parentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        if (isBalanced(input)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isBalanced(String input) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char closingParenthesis = input.charAt(i);
            if (closingParenthesis == '[' || closingParenthesis == '(' || closingParenthesis == '{') {
                stack.addFirst(closingParenthesis);
            } else {
                if (!stack.isEmpty()) {
                    char openingParenthesis = stack.pop();
                    if (openingParenthesis == '{') {
                        if (closingParenthesis != '}') {
                            return false;
                        }
                    } else if (openingParenthesis == '[') {
                        if (closingParenthesis != ']') {
                            return false;
                        }
                    } else if (openingParenthesis == '(') {
                        if (closingParenthesis != ')') {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}