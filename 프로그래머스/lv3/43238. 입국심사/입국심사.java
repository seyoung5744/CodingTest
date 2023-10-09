public class Solution {

    public static long solution(int n, int[] times){
        long start = 1;
        long end = 1_000_000_000_000_000_000L;

        while(end > start) {
            long mid = (start + end) / 2;

            if(isValid(n, mid, times)) {
                end = mid;
            }else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static boolean isValid(int n, long t, int[] times) {
        long result = 0;
        for(int time : times) {
            result += t / time;
        }
        return result >= n;
    }

}
