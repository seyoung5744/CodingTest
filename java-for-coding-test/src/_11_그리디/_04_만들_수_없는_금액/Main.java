package _11_그리디._04_만들_수_없는_금액;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins);

        int target = 1;
        for (int i = 0; i < coins.length; i++) {
            if(target <  coins[i]) break;
            target+= coins[i];
        }

        System.out.println(target);
    }

}
