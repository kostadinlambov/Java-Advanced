import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class p06_Simple_Text_Editor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder text = new StringBuilder();
        ArrayDeque<String[]> commandsStack = new ArrayDeque<>();

        int numberOfOperations = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfOperations; i++) {

            String[] token = reader.readLine().split("\\s+");
            int command = Integer.parseInt(token[0]);
            String lastTextInput = "";
            String lastTextErasure = "";
            if (command == 1) {

                commandsStack.addLast(token);

                lastTextInput = token[1];
                text.append(lastTextInput);
            } else if (command == 2) {
                int textLengthToErase = Integer.parseInt(token[1]);

                lastTextErasure = text.substring(text.length() - textLengthToErase);
                token[1] = lastTextErasure;
                commandsStack.addLast(token);

                text.delete(text.length() - textLengthToErase, text.length());

            } else if (command == 3) {
                char charToPrint = text.charAt(Integer.parseInt(token[1]) - 1);
                System.out.println(charToPrint);
            } else if (command == 4) {
                undoCommand(commandsStack, text);
            }
        }
    }

    private static void undoCommand(ArrayDeque<String[]> commandsStack, StringBuilder text) {
        String[] lastCommand = commandsStack.removeLast();

        int command = Integer.parseInt(lastCommand[0]);
        if(command == 1){
            String textToDelete = lastCommand[1];
            text.delete(text.length()-textToDelete.length(), text.length());
        }else if(command == 2){
            String textToAppend = lastCommand[1];
            text.append(textToAppend);
        }
    }
}
