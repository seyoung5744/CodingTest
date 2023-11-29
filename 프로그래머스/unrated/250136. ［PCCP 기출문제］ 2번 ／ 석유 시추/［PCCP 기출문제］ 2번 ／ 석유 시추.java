import java.util.*;

class Solution {
    public static int[] dx = {1, -1, 0, 0}; // 좌, 우, 하, 상
    public static int[] dy = {0, 0, 1, -1};

    public static boolean[][] visited;
    public static int count = 0;
    public static int lineNum = 2;

    public static int solution(int[][] land) {
        int answer = Integer.MIN_VALUE;

        visited = new boolean[land.length][land[0].length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < land[0].length; j++) { // x
            for (int i = 0; i < land.length; i++) { // y
                if(land[i][j] == 0) continue;
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    land[i][j] = lineNum;
                    count = 1;
                    dfs(i, j, land);
                    map.put(lineNum, count);
                    lineNum += 1;
                }
            }
        }
        
        for (int j = 0; j < land[0].length; j++) { // x
            count = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < land.length; i++) { // y
                if(land[i][j] == 0) {
                    continue;
                }
                set.add(land[i][j]);
            }

            for (Integer integer : set) {
                count += map.get(integer);
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }


    public static void dfs(int y, int x, int[][] land) {

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || nx >= land[0].length || ny < 0 || ny >= land.length || land[ny][nx] == 0 || visited[ny][nx]) {
                continue;
            }

            visited[ny][nx] = true;
            land[ny][nx] = lineNum;
            count += 1;
            dfs(ny, nx, land);
        }
    }
}