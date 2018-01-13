import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class p02_Hot_Potato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, input);

        while (queue.size() > 1) {

            for (int i = 1; i < n; i++) {
                String removedName = queue.remove();
                queue.add(removedName);
            }

            System.out.println("Removed " + queue.remove());
        }
        System.out.println("Last is " + queue.remove());
    }
}
