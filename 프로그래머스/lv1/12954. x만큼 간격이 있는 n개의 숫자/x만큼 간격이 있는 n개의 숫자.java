import java.util.ArrayList;

class Solution {
    public long[] solution(int x, int n) {
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add((long)x * i);
        }
        long[] answer = list.stream().mapToLong(l -> l).toArray();
        return answer;
    }
}