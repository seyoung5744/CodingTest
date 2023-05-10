package 유형별_일고리즘_이론._06_정렬;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 두_배열의_원소_교체 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N과 K를 입력받기
        int n = sc.nextInt();
        int k = sc.nextInt();

        // 배열 A 입력받기
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // 배열 B 입력받기
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            if (a[i] < b[i]) {
                int tmp = a[i];
                a[i] = b[i];
                b[i] = tmp;
            } else {
                break;
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += a[i];
        }

        System.out.println(result);


    }

}
