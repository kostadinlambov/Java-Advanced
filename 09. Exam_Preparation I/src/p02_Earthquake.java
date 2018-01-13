import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p02_Earthquake {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        ArrayDeque<ArrayDeque<Integer>> wavesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> currentQueue = new ArrayDeque<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {

            ArrayDeque<Integer> currentQueueInput = new ArrayDeque<>();
            Integer[] waveArr = Arrays.stream(reader.readLine().split("\\s+"))
                    .map(Integer::valueOf)
                    .toArray(Integer[]::new);

            for (Integer integer : waveArr) {
                currentQueueInput.addLast(integer);
            }
            wavesQueue.addLast(currentQueueInput);
        }

        List<Integer> seismicitiyList = new ArrayList<>();
        StringBuilder seismicitiySb = new StringBuilder();


        int seismicitiesCount = 0;

        while(!wavesQueue.isEmpty()){


            currentQueue = wavesQueue.removeFirst();

            int seismicity = currentQueue.removeFirst();

            if(currentQueue.size() > 0){
                boolean isSeismicityLessThanInt = false;
                for (int i = 0; i < currentQueue.size(); i++) {
                    int currentInt = currentQueue.removeFirst();
                    if(seismicity < currentInt){
                        seismicitiySb.append(seismicity).append(" ");
                        seismicitiesCount++;
                        currentQueue.addFirst(currentInt);
                        wavesQueue.addLast(currentQueue);
                        isSeismicityLessThanInt = true;
                        break;
                    }
                    i--;
                }
                if(!isSeismicityLessThanInt){
                    seismicitiySb.append(seismicity).append(" ");
                    seismicitiesCount++;
                }


            }else{
                seismicitiySb.append(seismicity).append(" ");
                seismicitiesCount++;
            }

        }

        System.out.println(seismicitiesCount);
        System.out.println(seismicitiySb.toString());
    }
}
