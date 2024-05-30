import java.util.*;

class Food implements Comparable<Food> {

    private int index;
    private int time;

    public Food(int index, int time) {
        this.index = index;
        this.time = time;
    }

    public int getIndex() {
        return index;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(Food o) {
        return Integer.compare(this.time, o.time);
    }
}

class Solution {
    public int solution(int[] food_times, long k) {
        long sum_value = 0;
        
        for (int i = 0; i < food_times.length; i++) {
            sum_value += food_times[i];
        }
        if (sum_value <= k) {
            return -1;
        }

        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(i + 1, food_times[i]));
        }

        sum_value = 0; 
        long previous = 0;
        long length = food_times.length; 

        while (sum_value + ((pq.peek().getTime() - previous) * length) <= k) {
            int now = pq.poll().getTime();
            sum_value += (now - previous) * length;
            length -= 1; 
            previous = now; 
        }

        ArrayList<Food> result  = new ArrayList<>();
        while(!pq.isEmpty()){
            result .add(pq.poll());
        }

        Collections.sort(result, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return Integer.compare(o1.getIndex(), o2.getIndex());
            }
        });

        
        return result.get((int) ((k - sum_value) % length)).getIndex();
    }
}