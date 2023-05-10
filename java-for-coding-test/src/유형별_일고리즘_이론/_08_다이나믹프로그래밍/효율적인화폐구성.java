package 유형별_일고리즘_이론._08_다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 효율적인화폐구성 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
        int[] d = new int[m + 1];
        Arrays.fill(d, 10001);

        d[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= m; j++) {
                if (d[j - coins[i]] != 10001) {
                    d[j] = Math.min(d[j], d[j - coins[i]] + 1);
                }
            }
        }

        System.out.println(Arrays.toString(d));

        if (d[m] == 10001) { // 최종적으로 M원을 만드는 방법이 없는 경우
            System.out.println(-1);
        }
        else {
            System.out.println(d[m]);
        }
    }

}
