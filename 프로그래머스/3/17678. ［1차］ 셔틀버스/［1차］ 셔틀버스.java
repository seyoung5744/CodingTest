import java.util.PriorityQueue;

public class Solution {

    public static String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> times = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < timetable.length; i++) {
            times.add(convertTime(timetable[i]));
        }

        int startBusTime = convertTime("09:00");
        int maxPerson = m;
        int lastTime = 0;
        int curTime = startBusTime;

        for (int i = 0; i < n; i++) {
            maxPerson = m;
            curTime = startBusTime + t * i;
            while (!times.isEmpty()) {
                if (times.peek() <= curTime) {
                    lastTime = times.poll() - 1;

                    maxPerson--;
                } else {
                    break;
                }
                if (maxPerson <= 0) {
                    break;
                }
            }
        }

        if (maxPerson > 0) {
            lastTime = curTime;
        }

        return revertTime(lastTime);
    }

    public static int convertTime(String time) {
        String[] tokens = time.split(":");
        return Integer.parseInt(tokens[0]) * 60 + Integer.parseInt(tokens[1]);
    }

    public static String revertTime(int time) {
        return String.format("%02d:%02d", time / 60, time % 60);
    }

}
