public class Solution {

    public static int[] queens;
    public static int answer = 0;

    public static int solution(int n) {
        queens = new int[n];
        dfs(0);
        return answer;
    }

    public static void dfs(int depth) {
        if (depth == queens.length) {
            answer++;
            return;
        }

        for (int i = 0; i < queens.length; ++i) {
            queens[depth] = i;

            if (isAvailable(depth)) {
                dfs(depth + 1);
            }
        }
    }

    public static boolean isAvailable(int depth) {
        for (int i = 0; i < depth; ++i) {
            if (queens[i] == queens[depth] || Math.abs(queens[i] - queens[depth]) == Math.abs(i - depth)) {
                return false;
            }
        }
        return true;
    }

}
