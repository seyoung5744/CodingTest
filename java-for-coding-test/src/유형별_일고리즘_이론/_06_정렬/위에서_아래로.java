package 유형별_일고리즘_이론._06_정렬;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 위에서_아래로 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }

}
