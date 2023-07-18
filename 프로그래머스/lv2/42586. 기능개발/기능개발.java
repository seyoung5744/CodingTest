import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add(i);
        }

        List<Integer> result = new ArrayList<>();
        int days = 0;
        int count = 0;
        while (!q.isEmpty()) {
            int idx = q.poll();
            int expiration = (int) Math.ceil((double) (100 - progresses[idx]) / speeds[idx]);
            System.out.println("완료 일 : " + expiration);
            if(expiration > days){
                if(days != 0){
                    result.add(count);
                    count = 0;
                }
                days = expiration;
            }
            count++;
        }

        result.add(count);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}