import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class p05_Applied_Arithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Consumer<Integer[]> add = numbersArr -> {
            for (int i = 0; i < numbersArr.length; i++) {
                numbersArr[i]++;
            }
        };
        Consumer<Integer[]> multiply = numbersArr -> {
            for (int i = 0; i < numbersArr.length; i++) {
                numbersArr[i] *= 2;
            }
        };

        Consumer<Integer[]> subtract = numbersArr -> {
            for (int i = 0; i < numbersArr.length; i++) {
                numbersArr[i]--;
            }
        };

        Consumer<Integer[]> print = numbersArr -> {
            for (int i = 0; i < numbersArr.length; i++) {
                System.out.print(numbersArr[i] + " ");
            }
            System.out.println();
        };

        Integer[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        while (true) {
            String commnad = reader.readLine();

            if (commnad.equalsIgnoreCase("end")) {
               // print.accept(numbers);
                break;
            }

            if (commnad.equalsIgnoreCase("add")) {
                add.accept(numbers);
            }else if(commnad.equalsIgnoreCase("multiply")){
                multiply.accept(numbers);
            }else if(commnad.equalsIgnoreCase("subtract")){
                subtract.accept(numbers);
            }else if(commnad.equalsIgnoreCase("print")){
                print.accept(numbers);
            }
        }
    }
}
