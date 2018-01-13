import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Pattern;

public class p08_Evaluate_Expression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Double> valuesStack = new ArrayDeque<>();
        ArrayDeque<String> InfixToPostfixQueue = new ArrayDeque<>();

        String[] input = reader.readLine().split("\\s+");

        InfixToPostfixQueue = InfixToPostfix(input);

        String regexNumbers = "\\d+";

        for (String anInput : InfixToPostfixQueue) {
            if (Pattern.matches(regexNumbers, anInput)) {
                valuesStack.addFirst(Double.parseDouble(anInput));
            } else {
                double firstValue = valuesStack.pop();
                double secondValue = valuesStack.pop();

                switch (anInput) {
                    case "+":
                        valuesStack.addFirst(secondValue + firstValue);
                        break;
                    case "-":
                        valuesStack.addFirst(secondValue - firstValue);
                        break;
                    case "*":
                        valuesStack.addFirst(secondValue * firstValue);
                        break;
                    case "/":
                        valuesStack.addFirst(secondValue / firstValue);
                        break;
                }
            }
        }
        System.out.printf("%.2f", valuesStack.pop());
    }

    private static ArrayDeque<String> InfixToPostfix(String[] input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> outputQueue = new ArrayDeque<>();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();

        String regexNumbers = "\\d+";
        String regexVariables = "[a-z]+";
        String regexOperators = "[+*\\/()\\-]+";

        for (String anInput : input) {
            if (Pattern.matches(regexNumbers, anInput)) {
                outputQueue.addLast(anInput);
            } else if (Pattern.matches(regexOperators, anInput)) {
                if (!operatorStack.isEmpty()) {
                    if ((operatorStack.peek().equals("*") || operatorStack.peek().equals("/"))
                            && (anInput.equals("*") || anInput.equals("/"))) {
                        outputQueue.addLast(operatorStack.pop());
                        operatorStack.addFirst(anInput);
                    } else if ((operatorStack.peek().equals("+") || operatorStack.peek().equals("-")
                            || operatorStack.peek().equals("*") || operatorStack.peek().equals("/"))
                            && (anInput.equals("+") || anInput.equals("-"))) {
                        outputQueue.addLast(operatorStack.pop());
                        operatorStack.addFirst(anInput);
                    } else if (anInput.equals(")")) {
                        while (!operatorStack.peek().equals("(")) {
                            outputQueue.addLast(operatorStack.pop());
                        }
                        operatorStack.pop();
                    } else {
                        operatorStack.addFirst(anInput);
                    }
                } else {
                    operatorStack.addFirst(anInput);
                }
            } else if (Pattern.matches(regexVariables, anInput)) {
                outputQueue.addLast(anInput);
            }
        }

        while (!operatorStack.isEmpty()) {
            outputQueue.addLast(operatorStack.pop());
        }

        return outputQueue;

    }
}

