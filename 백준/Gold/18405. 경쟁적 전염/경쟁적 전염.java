import java.util.*;

class Virus implements Comparable<Virus> {

    private int index;
    private int second;
    private int x;
    private int y;

    public Virus(int priority, int second, int x, int y) {
        this.index = priority;
        this.second = second;
        this.x = x;
        this.y = y;
    }

    public int getIndex() {
        return index;
    }

    public int getSecond() {
        return second;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Virus o) {
        if (this.index < o.index) {
            return -1;
        }

        return 1;
    }
}

public class Main {

    public static int n, k;
    public static int[][] map = new int[201][201];
    public static int s, x, y;
    public static ArrayList<Virus> viruses = new ArrayList<>();
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] != 0) {
                    viruses.add(new Virus(map[i][j], 0, i, j));
                }
            }
        }
        s = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();

        Collections.sort(viruses);

        Queue<Virus> virusQ = new LinkedList<>();
        for (Virus value : viruses) {
            virusQ.offer(value);
        }

        while (!virusQ.isEmpty()) {
            Virus virus = virusQ.poll();

            if (virus.getSecond() == s) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = virus.getX() + dx[i];
                int ny = virus.getY() + dy[i];
                if (0 < nx && nx <= n && 0 < ny && ny <= n) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = virus.getIndex();
                        virusQ.offer(new Virus(virus.getIndex(), virus.getSecond() + 1, nx, ny));
                    }
                }
            }
        }

        System.out.println(map[x][y]);
    }
}