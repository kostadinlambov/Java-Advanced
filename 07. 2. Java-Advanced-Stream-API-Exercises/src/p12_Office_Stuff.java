import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p12_Office_Stuff {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, LinkedHashMap<String, Integer>> companyMap = new TreeMap<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] token = reader.readLine().split("\\s+-\\s+");

            String company = token[0].substring(1);
            int amount = Integer.parseInt(token[1]);
            String product = token[2].substring(0, token[2].length() - 1);

            if (!companyMap.containsKey(company)) {
                companyMap.put(company, new LinkedHashMap<>());
            }

            if (!companyMap.get(company).containsKey(product)) {
                companyMap.get(company).put(product, 0);
            }

            companyMap.get(company)
                    .put(product, companyMap.get(company).get(product) + amount);
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> company : companyMap.entrySet()) {
            System.out.printf("%s: ", company.getKey());
            System.out.println(company.getValue().toString()
                    .replaceAll("[{}]", "")
                    .replaceAll("[=]", "-"));

        }
    }
}

