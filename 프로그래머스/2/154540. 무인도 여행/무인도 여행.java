import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static final int[] DX = {0, 0, 1, -1};
    public static final int[] DY = {-1, 1, 0, 0};

    public static int[] solution(String[] maps) {
        char[][] map = new char[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }

        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (map[i][j] == 'X' || visited[i][j]) {
                    continue;
                }
                answer.add(countMeal(j, i, map, visited));
            }
        }

        Collections.sort(answer);
        
        if(answer.size() == 0) return new int[]{-1};
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int countMeal(int x, int y, char[][] map, boolean[][] visited) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[y][x] = true;
        
        int result = map[y][x] - '0';
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + DX[i];
                int ny = cur[1] + DY[i];

                if(nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) continue;

                if(map[ny][nx] == 'X' || visited[ny][nx]) continue;
            
                result += map[ny][nx] - '0';
                
                q.offer(new int[]{nx, ny});
                visited[ny][nx] = true;
            }
        }
        return result;
    }

}
