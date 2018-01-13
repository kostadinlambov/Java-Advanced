import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class p16_Dragon_Army {
    private static int DEFAULT_DAMAGE = 45;
    private static int DEFAULT_HEALTH = 250;
    private static int DEFAULT_ARMOR = 10;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfDragons = Integer.parseInt(reader.readLine());
        LinkedHashMap<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();

        for (int i = 0; i < numberOfDragons; i++) {
            String[] line = reader.readLine().split("\\s+");
            String type = line[0];
            String dragonsName = line[1];
            Integer damage = line[2].equals("null")? DEFAULT_DAMAGE : Integer.valueOf( line[2]);
            Integer health = line[3].equals("null")? DEFAULT_HEALTH : Integer.valueOf( line[3]);
            Integer armor = line[4].equals("null")? DEFAULT_ARMOR : Integer.valueOf( line[4]);

            if(!dragons.containsKey(type)){
                dragons.put(type, new TreeMap<String, int[]>());
            }

            dragons.get(type).put(dragonsName, new int[]{damage, health, armor});
        }

        for (Map.Entry<String, TreeMap<String, int[]>> allDragons : dragons.entrySet()) {
            calculateAndPrintAllDragons(allDragons.getValue(), allDragons.getKey());
            for (Map.Entry<String,int[]> currentDragon : allDragons.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",currentDragon.getKey(),
                        currentDragon.getValue()[0], currentDragon.getValue()[1],currentDragon.getValue()[2] );
            }
        }
    }

    private static void calculateAndPrintAllDragons(TreeMap<String, int[]> value, String color) {
        Double averageDamage = 0.0;
        Double averageHealth = 0.0;
        Double averageArmor = 0.0;

        for (int[] ints : value.values()) {
            averageDamage += ints[0];
            averageHealth += ints[1];
            averageArmor += ints[2];
        }

        averageDamage /= value.size();
        averageHealth /= value.size();
        averageArmor /= value.size();
        System.out.printf("%s::(%.2f/%.2f/%.2f)%n", color, averageDamage, averageHealth, averageArmor);
    }
}
