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
        // 전체 음식을 먹는 시간보다 k가 크거나 같다면 -1
        long sum_value = 0;
        for (int i = 0; i < food_times.length; i++) {
            sum_value += food_times[i];
        }
        if (sum_value <= k) {
            return -1;
        }

        // 시간이 작은 음식부터 빼야 하므로 우선순위 큐를 이용
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(i + 1, food_times[i]));
        }

        sum_value = 0; // 먹기 위해 사용한 시간
        long previous = 0; // 직전에 다 먹은 음식 시간
        long length = food_times.length; // 남은 음식 개수

        // summary + (현재의 음식 시간 - 이전 음식 시간) * 현재 음식 개수와 k 비교
        while (sum_value + ((pq.peek().getTime() - previous) * length) <= k) {
            int now = pq.poll().getTime();
            sum_value += (now - previous) * length;
            length -= 1; // 다먹은 음식 제외
            previous = now; // 이전 음식 시간 재설정
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