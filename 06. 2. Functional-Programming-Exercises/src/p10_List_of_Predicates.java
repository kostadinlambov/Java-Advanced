import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.function.Predicate;

public class p10_List_of_Predicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());

        int[] divisorsArr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Predicate<Integer> predicate = x -> {
            for (int i = 0; i < divisorsArr.length; i++) {
                if(x % divisorsArr[i] != 0){
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= number; i++) {
            if(predicate.test(i)){
                System.out.print(i + " ");
            }
        }
    }
}
