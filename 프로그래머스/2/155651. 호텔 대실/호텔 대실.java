import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public static int solution(String[][] book_time) {

        int[][] bookTime = new int[book_time.length][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < book_time.length; i++) {
            bookTime[i] = new int[]{convert(book_time[i][0]), convert(book_time[i][1]) + 10};
        }

        Arrays.sort(bookTime, (a, b) -> a[0] - b[0]);

        System.out.println(Arrays.deepToString(bookTime));

        int answer = 0;

        for (int i = 0; i < bookTime.length; i++) {

            while(!pq.isEmpty() && bookTime[i][0] >= pq.peek())
            {
                pq.poll();
            }
            pq.add(bookTime[i][1]);

            answer = Math.max(answer, pq.size());
        }

        return answer;
    }

    public static int convert(String time) {
        int[] split = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        return split[0] * 60 + split[1];
    }
}
