import java.io.*;
import java.util.*;

public class Main {

    public static int[] coins = {25, 10, 5, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int money = sc.nextInt();

            int cnt = 0;
            for (int i = 0; i < coins.length; i++) {
                cnt = money / coins[i];
                System.out.print(cnt + " ");
                if (cnt > 0) {
                    money %= (cnt * coins[i]);
                }
            }

            System.out.println();
        }
    }

}
