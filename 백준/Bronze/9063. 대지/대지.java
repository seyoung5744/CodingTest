import java.util.Scanner;

public class Main {

    public static int minX, maxX;
    public static int minY, maxY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        if (T == 1) {
            System.out.println(0);
            return;
        }
        maxX = maxY = Integer.MIN_VALUE;
        minX = minY = Integer.MAX_VALUE;

        while (T-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (x < minX) minX = x;
            if (x > maxX) maxX = x;
            if (y < minY) minY = y;
            if (y > maxY) maxY = y;
        }

        System.out.println((maxX - minX) * (maxY - minY));
    }

}
