public class Solution {

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 0, end = 0;

        int max = w * 2 + 1;

        for (int i = 0; i < stations.length; i++) {
            start = end + 1;
            end = stations[i] - w - 1;

            if (end < start) {
                end = stations[i] + w;
                continue;
            }
            
            int distance = end - start + 1;

            answer += distance / max;

            if (distance % max != 0) {
                ++answer;
            }

            end = stations[i] + w;
        }

        if (end < n) {
            start = end + 1;
            end = n;

            int distance = end - start + 1;

            answer += distance / max;

            if (distance % max != 0) {
                ++answer;
            }
        }

        return answer;
    }
}