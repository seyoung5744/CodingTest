import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> b - a);
        Set<Integer> deleted = new HashSet<>();

        for (String operation : operations) {
            String[] tokens = operation.split(" ");
            String command = tokens[0];
            int num = Integer.parseInt(tokens[1]);

            switch (command) {
                case "I":
                    minQ.offer(num);
                    break;
                case "D":
                    if (num == 1) {
                        move(minQ, maxQ);
                        maxQ.poll();
                    } else {
                        minQ.poll();
                    }
                    move(maxQ, minQ);
                    break;
            }
        }

        if (minQ.isEmpty()) {
            return new int[]{0, 0};
        }
        int min = minQ.peek();
        move(minQ, maxQ);
        int max = maxQ.peek();
        return new int[]{max, min};
    }

    public void move(PriorityQueue<Integer> from, PriorityQueue<Integer> to) {
        if (from.isEmpty()) 
        {
            return;
        }

        while (!from.isEmpty()) {
            to.offer(from.poll());
        }
    }
}