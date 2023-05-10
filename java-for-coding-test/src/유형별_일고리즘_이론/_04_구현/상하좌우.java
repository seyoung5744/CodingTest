package 유형별_일고리즘_이론._04_구현;

import java.io.IOException;
import java.util.Scanner;

public class 상하좌우 {

    static int[][] dirt = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // 우, 좌, 상, 하
    static char[] moveType = {'R', 'L', 'U', 'D'};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        String[] plans = sc.nextLine().split(" ");
        int x = 1, y = 1;

        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);

            int nextX = -1, nextY = -1;

            for (int j = 0; j < moveType.length; j++) {
                if (plan == moveType[j]) {
                    nextX = x + dirt[j][0];
                    nextY = y + dirt[j][1];
                }
            }

            // 범위를 넘어서면 skip
            if (nextX < 1 || nextY < 1 || nextX > N || nextY > N) {
                continue;
            }

            x = nextX;
            y = nextY;

        }

        System.out.println(x + ", " + y);


    }

}
