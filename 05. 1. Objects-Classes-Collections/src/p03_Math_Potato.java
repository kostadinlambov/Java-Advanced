import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class p03_Math_Potato {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, input);

        int count = 1;
        while (queue.size() > 1) {

            boolean isPrime = checkIfPrime(count);

            for (int i = 1; i < n; i++) {
                String removedName = queue.remove();
                queue.add(removedName);
            }

            if (isPrime){
                System.out.println("Prime " + queue.peek());
            }else{
                System.out.println("Removed " + queue.remove());
            }

            count++;
        }
        System.out.println("Last is " + queue.remove());
    }

    private static boolean checkIfPrime(int count) {

        if(count == 1){
            return false;
        }
        for (int i = 2; i < count ; i++) {
            if( count % i == 0 ){
                return false;
            }
        }
        return true;
    }
}
