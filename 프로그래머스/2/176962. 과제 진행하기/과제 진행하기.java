import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    static class Task {

        String name;
        int start;
        int playTime;

        public Task(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }

    public static String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        PriorityQueue<Task> tasks = new PriorityQueue<>((a, b) -> a.start - b.start);

        for (String[] plan : plans) {
            tasks.add(new Task(plan[0], convertTimeToMinute(plan[1]), Integer.parseInt(plan[2])));
        }

        Deque<Task> waiting = new ArrayDeque<>();
        Task curTask = tasks.poll();

        while (!tasks.isEmpty()) {
            if ((curTask.start + curTask.playTime) > tasks.peek().start) {
                int newPlayTime = curTask.playTime - (tasks.peek().start - curTask.start);
                curTask.playTime = newPlayTime;
                curTask.start = curTask.start + (tasks.peek().start - curTask.start);
                waiting.push(curTask);
                curTask = tasks.poll();
            } else if((curTask.start + curTask.playTime) == tasks.peek().start) {
                answer.add(curTask.name);
                curTask = tasks.poll();
            } else {
                if(!waiting.isEmpty()) {
                    answer.add(curTask.name);
                    int newStartTime = curTask.start + curTask.playTime;
                    curTask = waiting.pop();
                    curTask.start = newStartTime;
                }
                else
                {
                    answer.add(curTask.name);
                    curTask = tasks.poll();
                }
            }
        }

        answer.add(curTask.name);

        while(!waiting.isEmpty())
        {
            answer.add(waiting.pop().name);
        }

        return answer.stream().toArray(String[]::new);
    }

    public static int convertTimeToMinute(String time) {
        String[] tokens = time.split(":");
        return Integer.parseInt(tokens[0]) * 60 + Integer.parseInt(tokens[1]);
    }

}
