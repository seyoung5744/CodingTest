package _14_정렬._24_안테나;

import java.util.*;

/*
4
5 1 7 9

6
1 2 3 5 8 9
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] homes = new int[n];
        for (int i = 0; i < n; i++) {
            homes[i] = sc.nextInt();
        }

        Arrays.sort(homes);

        System.out.println(homes[(n - 1) / 2]);
    }

}
