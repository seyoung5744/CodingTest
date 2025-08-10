import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int life = n;
        int round = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for (int i = 0; i < enemy.length; i++) {
            int e = enemy[i];
            pq.offer(e);

            if (life < e) {
                if (k <= 0) {
                    break;
                }
                
                life = life + pq.poll();
                k -= 1;
            }
            
            life -= e;
            round++;
        }
        return round;
    }
}