import java.util.*;

public class Solution {

    public static int[] dp1;
    public static int[] dp2;

    public static int solution(int[] sticker) {
        if (sticker.length == 1) {
            return sticker[0];
        } else if (sticker.length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }
        
        dp1 = new int[sticker.length];
        dp1[0] = sticker[0];
        dp1[1] = sticker[1];

        for (int i = 2; i < sticker.length - 1; i++) {
            if (i == 2) {
                dp1[i] += sticker[i] + dp1[i - 2];
                continue;
            }
            dp1[i] += sticker[i] + Math.max(dp1[i - 2], dp1[i - 3]);
        }

        dp2 = new int[sticker.length];
        dp2[1] = sticker[1];
        dp2[2] = sticker[2];
        for (int i = 3; i < sticker.length; i++) {
            dp2[i] += sticker[i] + Math.max(dp2[i - 2], dp2[i - 3]);
        }

        return Math.max(
            Arrays.stream(dp1).max().getAsInt(),
            Arrays.stream(dp2).max().getAsInt()
        );
    }
}
