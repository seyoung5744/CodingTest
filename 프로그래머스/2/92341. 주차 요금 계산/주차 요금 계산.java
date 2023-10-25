import java.util.*;
import java.util.stream.Collectors;


public class Solution {

    static class Car {

        String status;
        int time;

        public Car(String status, int time) {
            this.status = status;
            this.time = time;
        }
    }

    private static final int LAST_TIME = 23 * 60 + 59;

    public static int[] solution(int[] fees, String[] records) {

        Map<String, Car> map = new HashMap<>();

        for (String record : records) {
            String[] split = record.split(" ");
            String[] times = split[0].split(":");
            int time = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            String car = split[1];
            String status = split[2];

            if (status.equals("IN")) {
                Car inCar = map.getOrDefault(car, new Car("", 0));
                inCar.time -= time;
                inCar.status = status;
                map.put(car, inCar);
            } else { // OUT
                Car outCar = map.get(car);
                outCar.time = time + outCar.time;
                outCar.status = status;

                map.put(car, outCar);
            }
        }

        for (Map.Entry<String, Car> entry : map.entrySet()) {
            Car curCar = entry.getValue();
            if (curCar.status.equals("IN")) {
                curCar.time += LAST_TIME;
                curCar.status = "OUT";
                map.put(entry.getKey(), curCar);
            }
        }

        int baseTime = fees[0];
        int baseMoney = fees[1];
        int baseMin = fees[2];
        int unitMoney = fees[3];
        
        List<String> keys = map.keySet().stream().sorted().collect(Collectors.toList());
        List<Integer> answer = new ArrayList<>();

        for (String key : keys) {
            Car car = map.get(key);

            int sum = baseMoney;
            if (car.time > baseTime) {
                sum += (int) Math.ceil((double) (car.time - baseTime) / baseMin) * unitMoney;
            }

            answer.add(sum);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}
