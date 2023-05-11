package _11_그리디._05_볼링공_고르기;

import java.util.*;

/*

5 3
1 3 2 3 2

8 5
1 5 4 3 2 4 5 2
 */
public class Main {

    public static int[] balls = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            balls[num] += 1;
        }

        int result = 0;
        for (int i = 1; i <= m; i++) {
            n -= balls[i]; // 무게가 i인 볼링공의 개수(A가 선택할 수 있는 개수) 제외
            result += balls[i] * n;
        }

        System.out.println(result);
    }

}
