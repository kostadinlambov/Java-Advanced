import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class p05_Recursive_Drawing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        draw(n);
    }

    private static void draw(int n){
        if(n <= 0){
            return;
        }
        //pre
        System.out.println(String.join("", Collections.nCopies(n, "*")));
        // recursion
        draw(n-1);
        //post
        System.out.println(String.join("", Collections.nCopies(n, "#")));
    }
}
