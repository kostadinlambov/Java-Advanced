import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class p02_Maximum_Element {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int numberOfElements = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfElements; i++) {

            String[] commands = reader.readLine().split("\\s+");

            int command = Integer.parseInt(commands[0]);

            if(command == 1){
                stack.push(Integer.parseInt(commands[1]));
            }else if(command == 2){
                stack.pop();
            }else if(command == 3){
                List<Integer> valuesInStack = new ArrayList<>();
                valuesInStack.addAll(stack);
                calculateMaxAndPrint(valuesInStack);
            }
        }
    }

    private static void calculateMaxAndPrint(List<Integer> valuesInStack) {
        boolean swapped = true;
        do{
            swapped = false;
            for (int i = 0; i < valuesInStack.size()-1; i++) {
                if(valuesInStack.get(i) > valuesInStack.get(i+1)){
                    int temp = valuesInStack.get(i+1);
                    valuesInStack.set(i+1,valuesInStack.get(i));
                    valuesInStack.set(i, temp);
                }
            }
        }while(swapped == true);

        System.out.println(valuesInStack.get(valuesInStack.size()-1));
    }
}
