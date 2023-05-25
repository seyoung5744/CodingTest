import java.util.*;
import java.io.*;

class Info {

    private int x;
    private int y;
    private String type;

    public Info(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getType() {
        return type;
    }
}

public class Main {

    public static int R, C;
    public static char[][] graph = new char[50][50];
    public static int[][] visited = new int[50][50];
    public static Queue<Info> q = new LinkedList<>();
    public static boolean flag;

    public static int answer;

    public static int sx, sy;
    
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            char[] cArr = st.nextToken().toCharArray();
            for (int j = 0; j < C; j++) {
                char c = cArr[j];
                if (c == 'S') {
                    sx = i;
                    sy = j;
                    visited[sx][sy] = 1;
                } else if (c == '*') {
                    visited[i][j] = -1;
                    q.offer(new Info(i, j, "water"));
                }
                graph[i][j] = c;
            }
        }

        bfs(sx, sy);
        System.out.println(flag? answer : "KAKTUS");
    }

    public static void bfs(int sx, int sy) {
        q.offer(new Info(sx, sy, "kaktus"));

        while (!q.isEmpty()) {
            Info cur = q.poll();
            int x = cur.getX();
            int y = cur.getY();
            String type = cur.getType();

            if (graph[x][y] == 'D') {
                flag = true;
                answer = visited[x][y] - 1;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (visited[nx][ny] == 0 && graph[nx][ny] == '.' || graph[nx][ny] == 'D') {
                        if (type.equals("water")) {
                            if(graph[nx][ny] == '.') {
                                visited[nx][ny] = -1;
                                q.offer(new Info(nx, ny, "water"));
                            }
                        }

                        if (type.equals("kaktus")) {
                            visited[nx][ny] = visited[x][y] + 1;
                            q.offer(new Info(nx, ny, "kaktus"));
                        }
                    }
                }

            }
        }
    }
}
