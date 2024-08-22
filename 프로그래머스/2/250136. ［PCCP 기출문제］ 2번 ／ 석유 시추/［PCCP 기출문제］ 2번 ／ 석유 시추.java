import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

    static Map<Integer, Integer> m = new HashMap<>();

    public static int solution(int[][] land) {
        int answer = 0;
        int[][] areas = new int[land.length][land[0].length];

        settingAreas(land, areas);

        for (int i = 0; i < land[0].length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < land.length; j++) {
                if (land[j][i] == 0)
                    continue;
                
                set.add(areas[j][i]);
            }
            int result = 0;
            for (int a : set) {
                result += m.get(a);
            }
            answer = Math.max(answer, result);
        }
        return answer;
    }

    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static void settingAreas(int[][] land, int[][] areas) {
        boolean[][] visited = new boolean[areas.length][areas[0].length];

        int sector = 1;

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; ++j) {
                if (land[i][j] == 0) {
                    continue;
                }

                if (visited[i][j] == true) {
                    continue;
                }

                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{i, j});
                visited[i][j] = true;
                int count = 1;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    areas[cur[0]][cur[1]] = sector;

                    for (int k = 0; k < 4; k++) {
                        int nx = cur[1] + dx[k];
                        int ny = cur[0] + dy[k];

                        if (nx < 0 || nx >= land[0].length || ny < 0 || ny >= land.length) {
                            continue;
                        }

                        if (land[ny][nx] == 0 || visited[ny][nx]) {
                            continue;
                        }

                        q.offer(new int[]{ny, nx});
                        visited[ny][nx] = true;
                        count += 1;
                    }
                }

                m.put(sector, count);
                sector += 1;
            }
        }

    }
}
