package p06_Java_Fundamentals_Retake_08_May_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P01_Royalism {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");

        List<String> royalistsList = new ArrayList<>();
        List<String> nonRoyalistsList = new ArrayList<>();

        for (int i = 0; i < tokens.length; i++) {
            int totalCharacterValuesSum = 0;
            for (int j = 0; j < tokens[i].length(); j++) {
                int currentCharacterValues = tokens[i].charAt(j);

                totalCharacterValuesSum += currentCharacterValues;
            }

            while(totalCharacterValuesSum > 26){
                totalCharacterValuesSum -= 26;
            }

            if(totalCharacterValuesSum == 'R' - 'A' + 1){
                royalistsList.add(tokens[i]);
            }else{
                nonRoyalistsList.add(tokens[i]);
            }
        }

        if(royalistsList.size() >= nonRoyalistsList.size()){
            System.out.println("Royalists - " + royalistsList.size());
            for (String royalist : royalistsList) {
                System.out.println(royalist);
            }
            System.out.println("All hail Royal!");
        }else{
            for (String nonRoyalist : nonRoyalistsList) {
                System.out.println(nonRoyalist);
            }
            System.out.println("Royalism, Declined!");
        }
    }
}
