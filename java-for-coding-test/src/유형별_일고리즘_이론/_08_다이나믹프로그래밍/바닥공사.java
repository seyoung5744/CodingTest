package 유형별_일고리즘_이론._08_다이나믹프로그래밍;

import java.util.Scanner;

public class 바닥공사 {

    public static int[] d = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        d[1] = 1;
        d[2] = 3;

        for (int i = 3; i < n + 1; i++) {
            d[i] = (d[i - 1] + d[i - 2] * 2) % 796796;
        }

        System.out.println(d[n]);
    }

}
