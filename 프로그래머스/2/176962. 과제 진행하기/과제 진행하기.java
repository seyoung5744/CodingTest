import java.util.*;

public class Solution {

    public static class Task implements Comparable<Task> {

        String name;
        int startTime;
        int playTime;

        public Task(String name, String startTime, String playTime) {
            this.name = name;
            this.startTime = convertStrToInt(startTime);
            this.playTime = Integer.parseInt(playTime);
        }

        public int convertStrToInt(String time) {
            int[] tokens = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
            return tokens[0] * 60 + tokens[1];
        }

        @Override
        public int compareTo(Task o) {
            return this.startTime - o.startTime;
        }
    }

    public static String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();

        PriorityQueue<Task> tasks = new PriorityQueue<>();
        for (String[] plan : plans) {
            tasks.add(new Task(plan[0], plan[1], plan[2]));
        }

        Stack<Task> waiting = new Stack<>();

        Task cur = tasks.poll();
        while (!tasks.isEmpty()) {
            Task next = tasks.peek();

            if (next.startTime < cur.startTime + cur.playTime) {
                cur.playTime -= (next.startTime - cur.startTime);
                waiting.push(cur);
                cur = tasks.poll();
            } else {
                answer.add(cur.name);

                if(waiting.isEmpty()) {
                    cur = tasks.poll();
                    continue;
                }
                int newStartTime = cur.playTime + cur.startTime;
                cur = waiting.pop();
                cur.startTime = newStartTime;
            }

        }
        answer.add(cur.name);

        while(!waiting.isEmpty()) {
            answer.add(waiting.pop().name);
        }

        return answer.toArray(new String[answer.size()]);
    }
}
