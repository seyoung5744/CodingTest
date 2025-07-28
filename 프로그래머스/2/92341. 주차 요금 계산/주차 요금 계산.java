import java.util.*;
import java.util.stream.*;

class Solution {
    private static class Car {
        String status;
        int totalTime;
        int inTime;

        public Car(String status, int totalTime, int inTime) {
            this.status = status;
            this.totalTime = totalTime;
            this.inTime = inTime;
        }
    }

    public int[] solution(int[] fees, String[] records) {
        Map<String, Car> history = new HashMap<>();
        for (String record : records) {
            String[] tokens = record.split(" ");
            String time = tokens[0];
            String carNum = tokens[1];
            String status = tokens[2];

            if (status.equals("IN")) {
                if (!history.containsKey(carNum)) {
                    int inTime = convert(time);
                    history.put(carNum, new Car(status, 0, inTime));
                } else {
                    Car car = history.get(carNum);
                    car.status = status;
                    car.inTime = convert(time);
                    history.put(carNum, car);
                }
            } else {
                if (history.containsKey(carNum)) {
                    Car car = history.get(carNum);
                    int outTime = convert(time);
                    car.status = status;
                    car.totalTime += outTime - car.inTime;
                }
            }
        }

        for (String carNum : history.keySet()) {
            Car car = history.get(carNum);
            if (car.status.equals("IN")) {
                car.status = "OUT";
                car.totalTime += convert("23:59") - car.inTime;
            }
        }

        List<Integer> result = new ArrayList<>();
        List<String> carNums = new ArrayList<>(history.keySet());
        Collections.sort(carNums);

        for (String carNum : carNums) {
            Car car = history.get(carNum);
            int price = 0;
            if (car.totalTime <= fees[0]) {
                price = fees[1];
            } else {
                price = fees[1] + (int) Math.ceil((double) (car.totalTime - fees[0]) / fees[2]) * fees[3];
            }
            result.add(price);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int convert(String time) {
        String[] tokens = time.split(":");
        return Integer.parseInt(tokens[0]) * 60 + Integer.parseInt(tokens[1]);
    }
}