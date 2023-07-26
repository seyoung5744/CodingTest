import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private static class State {

        private final String word;
        private final int step;

        public State(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    public int solution(String begin, String target, String[] words) {
        boolean[] isVisited = new boolean[words.length];

        Queue<State> q = new LinkedList<>();
        q.offer(new State(begin, 0));

        while (!q.isEmpty()) {
            State state = q.poll();
            
            if(state.word.equals(target)){
                return state.step;
            }
            
            for (int i = 0; i < words.length; i++) {
                String next = words[i];
                
                if (!isConvertable(state.word, next)) {
                    continue;
                }
                
                if(isVisited[i]) continue;
                isVisited[i] = true;
                
                q.offer(new State(next, state.step + 1));

            }
        }
        return 0;
    }

    private static boolean isConvertable(String from, String to) {
        char[] fromArr = from.toCharArray();
        char[] toArr = to.toCharArray();

        int diff = 0;
        for (int i = 0; i < fromArr.length; i++) {
            if (fromArr[i] != toArr[i]) {
                diff++;
            }
        }

        return diff == 1;
    }
}
