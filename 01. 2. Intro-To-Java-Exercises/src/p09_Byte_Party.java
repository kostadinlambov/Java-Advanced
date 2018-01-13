import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p09_Byte_Party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int countOfIntegers = Integer.parseInt(scanner.nextLine());

        List<Integer> numbers = new ArrayList<>(); 
      //  List<String> commands = new ArrayList<>();

        for (int i = 0; i < countOfIntegers; i++) {
            numbers.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 0; i < countOfIntegers; i++) {
            //commands.add(scanner.nextLine());
            int[] commands = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int position = commands[1];

            if(commands[0] == 0){

                int mask = ~(1 << position);

                for (int j = 0; j < countOfIntegers; j++) {
                    int result = numbers.get(j) & mask;
                    System.out.println(mask);
                    System.out.println(result);
                }


                System.out.println();
            }else if(commands[0] == 1){
                int mask = 1 << position;

                for (int j = 0; j < countOfIntegers; j++) {
                    int result = numbers.get(j) | mask;
                    System.out.println(mask);
                    System.out.println(result);
                }

            }
            else if(commands[0] == -1){
                int mask = 1 << position;

                for (int j = 0; j < countOfIntegers; j++) {
                    int result = numbers.get(j) ^ mask;
                }
            }

        }
        System.out.println();
    }
}
