import java.util.*;

class Point {

    int index;
    int time;

    public Point(int index, int time) {
        this.index = index;
        this.time = time;
    }
}

public class Main {

    public static int n, k;
    public static boolean[] visited = new boolean[100_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        Queue<Point> q = new LinkedList<>();
        visited[n] = true;
        q.offer(new Point(n, 0));
        int min = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Point now = q.poll();
            visited[now.index] = true;

            if(now.index == k){
                min = Math.min(min, now.time);
                break;
            }
            if (now.index * 2 <= 100_000 && !visited[now.index * 2]) {
                q.offer(new Point(now.index * 2, now.time));
            }
            if (now.index - 1 >= 0 && !visited[now.index - 1]) {
                q.offer(new Point(now.index - 1, now.time + 1));
            }
            if (now.index + 1 <= 100_000 && !visited[now.index + 1]) {
                q.offer(new Point(now.index + 1, now.time + 1));
            }
        }

        System.out.println(min);

    }

}
