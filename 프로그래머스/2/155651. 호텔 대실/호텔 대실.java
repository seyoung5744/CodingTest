import java.util.*;

class Solution {
    public static class Person implements Comparable<Person> {

        int startTime;
        int endTime;

        public Person(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Person o) {
            return this.endTime - o.endTime;
        }
    }

    public static int solution(String[][] book_time) {
        int answer = 0;

        List<Person> times = new ArrayList<>();

        for (int i = 0; i < book_time.length; i++) {
            String[] books = book_time[i];
            int start = convertTime(books[0]);
            int end = convertTime(books[1]);
            times.add(new Person(start, end));
        }

        Collections.sort(times, (a, b) -> a.startTime - b.startTime);

        PriorityQueue<Person> pq = new PriorityQueue<>();

        for (Person time : times) {
            if (!pq.isEmpty()) {
                while (!pq.isEmpty() && (pq.peek().endTime + 10 <= time.startTime)) {
                    pq.poll();
                }
            }
            pq.add(time);

            answer = Math.max(answer, pq.size());
        }
        return answer;
    }
    public static int convertTime(String times) {
        String[] split = times.split(":");
        int hour = Integer.parseInt(split[0]) * 60;
        int min = Integer.parseInt(split[1]);
        return hour + min;
    }
}