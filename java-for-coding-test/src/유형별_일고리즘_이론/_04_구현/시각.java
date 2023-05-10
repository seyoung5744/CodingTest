package 유형별_일고리즘_이론._04_구현;

import java.util.Scanner;

public class 시각 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 0;

        for (int i = 0; i < N + 1; i++) { // 시
            for (int j = 0; j < 60; j++) { // 분
                for (int k = 0; k < 60; k++) { // 초
                    if(check(i, j, k)){
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    public static boolean check(int h, int m, int s){
        if(h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3){
            return true;
        }
        return false;
    }

}
