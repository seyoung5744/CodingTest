import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public static boolean[] visited;
    public static PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

    public static int solution(int[] cards) {
        int answer = 0;
        visited = new boolean[cards.length];

        for (int i = 0; i < cards.length; i++) {
            if(!visited[i]) {
                dfs(i, 0, cards);
            }
        }
        
        if(pq.size() == 1){
            return 0;
        }
        return pq.poll() * pq.poll();
    }

    public static void dfs(int idx, int len, int[] cards) {

        if(visited[idx]) {
            pq.add(len);
            return;
        }

        visited[idx] = true;
        dfs(cards[idx] - 1, len + 1, cards);
    }

}
