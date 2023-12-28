import java.io.*;
import java.util.*;

public class Main {
    public static class Snake {
        int x, y;

        public Snake(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] map;
    public static List<Snake> snakes = new ArrayList<>();
    public static Map<Integer, String> commands = new HashMap<>();
    public static int[] dx = {1, 0, -1, 0}; // 우, 하, 좌, 상
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] tokens = br.readLine().split(" ");
            int y = Integer.parseInt(tokens[0]) - 1;
            int x = Integer.parseInt(tokens[1]) - 1;
            map[y][x] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            String[] tokens = br.readLine().split(" ");
            int count = Integer.parseInt(tokens[0]);
            String cmd = tokens[1];
            commands.put(count, cmd);
        }

        solution();
    }

    public static void solution() {

        int time = 0;
        int direction = 0;

        Snake cur = new Snake(0, 0);
        snakes.add(cur);

        while(true) {
            time++; // 시간 증가

            int nx = dx[direction] + cur.x;
            int ny = dy[direction] + cur.y;

            // 종료 조건
            if(isFinish(nx, ny)) {
                break;
            }

            // 사과가 있을때 없을 때
            if(map[ny][nx] == 1) {
                map[ny][nx] = 0;
                snakes.add(new Snake(nx, ny));
            } else {
                snakes.add(new Snake(nx, ny));
                snakes.remove(0);
            }

            if(commands.containsKey(time)) {
                if(commands.get(time).equals("D")) { // 우측으로 방향 전환
                    direction += 1;
                    if(direction == 4) direction = 0;
                } else {
                    direction -= 1;
                    if(direction == -1) direction = 3;
                }
            }

            cur.x = nx;
            cur.y = ny;
        }

        System.out.println(time);
    }

    public static boolean isFinish(int nx, int ny) {
        if(nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) {
            return true;
        }

        for(Snake body : snakes) {
            if(nx == body.x && ny == body.y) {
                return true;
            }
        }
        return false;
    }
}