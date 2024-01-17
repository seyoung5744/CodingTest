import java.util.List;

public class Solution {
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 0;
        int end = 0;
        for(int station : stations) {
            end = station - w - 1;
            if (end > start) {
                int remian = (end - start) % (w * 2 + 1);
                answer += (end - start) / (w * 2 + 1);
                if(remian > 0) {
                    answer += 1;
                }
            }

            start = station + w;
        }
        if(start < n)
        {
            end = n;
            int remian = (end - start) % (w * 2 + 1);
            answer += (end - start) / (w * 2 + 1);
            if(remian > 0) {
                answer += 1;
            }
        }
        return answer;
    }
}
