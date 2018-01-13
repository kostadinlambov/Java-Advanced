package p04_Retake_Exam_22_August_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03_NMS {

    private static StringBuilder wordsSb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        System.out.println();
        while (true) {
            String inputLine = reader.readLine();
            if ("---NMS SEND---".equals(inputLine)) {
                break;
            }
            sb.append(inputLine);
        }
        sb.append("(");

        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < sb.length()-1; i++) {
            if(Character.toLowerCase(sb.charAt(i)) > Character.toLowerCase(sb.charAt(i+1))){
                takeTheWord(sb, startIndex, endIndex);
                startIndex = i+1;
                endIndex = i+1;

            }else{
                endIndex++;
            }
        }

        String delimiter = reader.readLine();

        String outputString = wordsSb.toString().trim().replaceAll(" ", delimiter);
        System.out.println(outputString);

    }

    private static void takeTheWord(StringBuilder sb, int startIndex, int endIndex) {
        String word = sb.substring(startIndex, endIndex+1);
        wordsSb.append(word).append(" ");

    }
}
