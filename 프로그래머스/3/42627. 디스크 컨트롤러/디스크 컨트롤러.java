import java.util.*;

public class Solution {

    static class Disk {

        public final int start;
        public final int jobTime;

        public Disk(int start, int jobTime) {
            this.start = start;
            this.jobTime = jobTime;
        }
    }

    public int solution(int[][] jobs) {
        Disk[] disks = new Disk[jobs.length];

        for (int i = 0; i < jobs.length; i++) {
            disks[i] = new Disk(jobs[i][0], jobs[i][1]);
        }

        Arrays.sort(disks, (a, b) -> a.start - b.start);

        Queue<Disk> q = new LinkedList<>(Arrays.asList(disks));
        PriorityQueue<Disk> pq = new PriorityQueue<>((a, b) -> a.jobTime - b.jobTime);

        int exec = 0; // 누적 시간
        int time = 0; // 현재 시간

        while(!q.isEmpty() || !pq.isEmpty()) {
            while(!q.isEmpty() && q.peek().start <= time){
                pq.add(q.poll());
            }

            if(pq.isEmpty()) {
                time = q.peek().start;
                continue;
            }

            Disk curJob = pq.poll();
            exec += time + curJob.jobTime - curJob.start;
            time += curJob.jobTime;
        }

        return exec / disks.length;
    }
}
