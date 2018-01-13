import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p04_Combinations_Count {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        System.out.println(binomi(n, k));
    }

    static long binomi(int n, int k) {
        if ((n == k) || (k == 0))
            return 1;
        else
            return binomi(n - 1, k) + binomi(n - 1, k - 1);
    }
}

