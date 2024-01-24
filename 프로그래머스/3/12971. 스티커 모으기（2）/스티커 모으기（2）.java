class Solution {
    public static int solution(int[] sticker) {
        if(sticker.length == 1) {
            return sticker[0];
        }else if (sticker.length == 2){
            return Math.max(sticker[0], sticker[1]);
        }
        return Math.max(getMax(0, sticker.length - 2, sticker, new int[sticker.length]), getMax(1, sticker.length - 1, sticker, new int[sticker.length]));
    }

    public static int getMax(int start, int end, int[] sticker, int[] dp) {

        dp[start] = sticker[start];
        dp[start + 1] = Math.max(sticker[start], sticker[start + 1] );

        for (int i = start + 2; i <= end; i++) {
            if(dp[i] == 0) {
                dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
            }
        }

        return dp[end];
    }
}