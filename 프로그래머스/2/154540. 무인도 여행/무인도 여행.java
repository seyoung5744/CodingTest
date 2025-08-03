import java.util.*;
import java.util.stream.*;

class Solution {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};

    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char point = maps[i].charAt(j);
                if (point == 'X' || visited[i][j]) continue;

                int foods = searchLand(j, i, visited, maps);
                answer.add(foods);
            }
        }
        if (answer.isEmpty()) return new int[]{-1};
        return answer.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int searchLand(int x, int y, boolean[][] visited, String[] maps) {

        visited[y][x] = true;

        int food = maps[y].charAt(x) - '0';
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= maps[0].length() || ny < 0 || ny >= maps.length || maps[ny].charAt(nx) == 'X') continue;
            
            if (visited[ny][nx]) continue;
            food += searchLand(nx, ny, visited, maps);
        }

        return food;
    }
}