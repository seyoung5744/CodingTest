import java.util.*;

class Solution {
   private static class Task {
        String name;
        int startTime;
        int playTime;

        public Task(String name, int startTime, int playTime) {
            this.name = name;
            this.startTime = startTime;
            this.playTime = playTime;
        }

    }

    public String[] solution(String[][] plans) {
        Task[] tasks = new Task[plans.length];
        for (int i = 0; i < plans.length; i++) {
            tasks[i] = new Task(plans[i][0], convert(plans[i][1]), Integer.parseInt(plans[i][2]));
        }

        Arrays.sort(tasks, (a, b) -> a.startTime - b.startTime);

        List<String> answer = new ArrayList<>();

        Deque<Task> recentStoppedTask = new ArrayDeque<>();
        PriorityQueue<Task> playingTask = new PriorityQueue<>((a, b) -> a.startTime - b.startTime);
        for (int i = 0; i < tasks.length; i++) {
            playingTask.offer(tasks[i]);
        }

        int curTime = -1;
        while (!playingTask.isEmpty()) {
            Task nextTask = playingTask.poll();

            if (nextTask.startTime > curTime) {
                while (!recentStoppedTask.isEmpty()) {
                    Task mostRecentStoppedTask = recentStoppedTask.pop();

                    if (curTime + mostRecentStoppedTask.playTime <= nextTask.startTime) {
                        answer.add(mostRecentStoppedTask.name);
                        curTime += mostRecentStoppedTask.playTime;
                    } else {
                        mostRecentStoppedTask.playTime -= nextTask.startTime - curTime;
                        recentStoppedTask.push(mostRecentStoppedTask);
                        break;
                    }
                }
            }

            recentStoppedTask.push(nextTask);
            curTime = nextTask.startTime;
        }

        while (!recentStoppedTask.isEmpty()) {
            answer.add(recentStoppedTask.pop().name);
        }
        return answer.stream().toArray(String[]::new);
    }

    private int convert(String time) {
        String[] tokens = time.split(":");
        return Integer.parseInt(tokens[0]) * 60 + Integer.parseInt(tokens[1]);
    }
}