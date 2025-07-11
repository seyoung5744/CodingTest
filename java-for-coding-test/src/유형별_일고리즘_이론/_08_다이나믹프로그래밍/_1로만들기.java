package 유형별_일고리즘_이론._08_다이나믹프로그래밍;

import java.util.Scanner;

public class _1로만들기 {

    public static int[] d = new int[30001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        for (int i = 2; i < x + 1; i++) {
            // 현재의 수에서 1일 빼는 경우
            d[i] = d[i - 1] + 1;

            // 현재의 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                d[i] = Math.min(d[i], d[i / 2] + 1);
            }

            if(i % 3 == 0){
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }

            if(i % 5 == 0){
                d[i] = Math.min(d[i], d[i / 5] + 1);
            }
        }

        System.out.println(d[x]);
    }

}
