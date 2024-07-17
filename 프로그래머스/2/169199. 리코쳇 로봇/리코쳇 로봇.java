import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    private static int[] dx = {1, -1, 0, 0}; // 우, 좌, 하, 상
    private static int[] dy = {0, 0, 1, -1};

    public static int solution(String[] board) {

        int[] start = new int[0];
        int[] end = new int[0];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    start = new int[]{i, j};
                } else if (board[i].charAt(j) == 'G') {
                    end = new int[]{i, j};
                }
            }
        }

        int[][] visited = new int[board.length][board[0].length()];
        for(int[] visit : visited) {
            Arrays.fill(visit, 1000000000);
        }

        visited[start[0]][start[1]] = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(start);

        int answer = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[1] == end[1] && cur[0] == end[0]) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[1];
                int ny = cur[0];

                while(nx + dx[i] >= 0 && nx + dx[i] < board[0].length() && ny + dy[i]>= 0 && ny + dy[i]< board.length
                && board[ny + dy[i]].charAt(nx + dx[i]) != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }

                if (visited[ny][nx] <= visited[cur[0]][cur[1]] + 1)
                    continue;

                visited[ny][nx] = visited[cur[0]][cur[1]] + 1;
                q.add(new int[]{ny, nx});
            }
        }

        if (visited[end[0]][end[1]] == 1000000000)
        {
            return -1;
        }


        return visited[end[0]][end[1]];
    }

}
