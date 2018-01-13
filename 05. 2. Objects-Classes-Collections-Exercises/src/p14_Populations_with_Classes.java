import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p14_Populations_with_Classes {

    private static Map<String, LinkedList<City>> countries = new LinkedHashMap<>();
    private static LinkedList<String> countriesList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line.equals("report")) {
                break;
            }
            String[] lines = line.split("\\|");
            String name = lines[0];
            String country = lines[1];
            if (!countriesList.contains(country)) {
                countriesList.add(country);
            }
            City c = new City(name, Long.parseLong(lines[2]));
            LinkedList<City> temp = new LinkedList<>();
            if (countries.containsKey(country)) {
                temp = countries.get(country);
            }
            temp.add(c);
            countries.put(country, temp);

        }
        print();
    }

    private static void print() {
        /*should be ordered by their total population in descending order.
        If two countries/cities have the same population, keep them in the order in which they were entered.*/

        LinkedHashMap<String, LinkedList<City>> sortedCountries = countries.entrySet().stream().sorted((a,b)->{
            Long operand1 = a.getValue().stream().mapToLong(City::getPop).sum();
            Long operand2 = b.getValue().stream().mapToLong(City::getPop).sum();
            return operand2.compareTo(operand1);
        }).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue,newValue)->oldValue, LinkedHashMap::new));


        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, LinkedList<City>> country_listOfCities : sortedCountries.entrySet()) {
            System.out.printf("%s (total population: %d)%n", country_listOfCities.getKey(), country_listOfCities.getValue().stream().mapToLong(City::getPop).sum());
            LinkedList<City> cities = country_listOfCities.getValue().stream()
                    .sorted(Comparator.comparing(City::getPop).reversed())
                    .collect(Collectors.toCollection(LinkedList::new));
            sb.setLength(0);
            for (City city : cities) {
                sb.append("=>")
                        .append(city.name)
                        .append(": ")
                        .append(city.pop)
                        .append("\r\n");

            }
            System.out.printf(sb.toString());
        }
    }
}

class City {
    String name;
    long pop;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPop() {
        return pop;
    }

    public void setPop(long pop) {
        this.pop = pop;
    }

    public City(String name, long pop) {

        this.name = name;
        this.pop = pop;
    }

}
