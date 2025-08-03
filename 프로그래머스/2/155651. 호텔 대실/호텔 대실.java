import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] bookTime = Arrays.stream(book_time)
                .map(strings -> Arrays.stream(strings)
                        .mapToInt(this::convert)
                        .toArray())
                .sorted((o1, o2) -> {
                    if (o1[0] == o2[0]) {
                        return Integer.compare(o1[1], o2[1]);
                    }
                    return Integer.compare(o1[0], o2[0]);
                })
                .toArray(int[][]::new);
        
        int answer = 0;

        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        for (int i = 0; i < bookTime.length; i++) {
            int[] time = bookTime[i];
            int start = time[0];
            int end = time[1];

            if (!endTime.isEmpty()) {
                if (endTime.peek() + 10 <= start) {
                    endTime.poll();
                }
            }
            endTime.add(end);

            answer = Math.max(answer, endTime.size());
        }
        return answer;
    }
    
    public int convert(String time) {
        String[] tokens = time.split(":");
        return Integer.parseInt(tokens[0]) * 60 + Integer.parseInt(tokens[1]);
    }
}