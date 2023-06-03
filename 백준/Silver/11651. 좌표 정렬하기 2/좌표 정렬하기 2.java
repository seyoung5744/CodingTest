import java.util.*;

class Point2 {

    int x;
    int y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}

public class Main {

    public static Point2[] points;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        points = new Point2[n];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point2(x, y);
        }

        Arrays.sort(points, (p1, p2) -> {
            if(p1.y == p2.y){
                return Integer.compare(p1.x, p2.x);
            }

            return Integer.compare(p1.y, p2.y);
        });

        for(Point2 point : points){
            System.out.println(point);
        }
    }
}