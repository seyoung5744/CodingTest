import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> list = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

        int count = 0; // 맞힌 개수
        int zeroCount = 0;
        for (int lotto : lottos){
            if(list.contains(lotto)){
                count++;
            }
            if(lotto == 0){
                zeroCount++;
            }
        }

        int maxRank = 7 - (count + zeroCount);
        int minRank = 7-  count;
        if(maxRank > 6) maxRank = 6;
        if(minRank > 6) minRank = 6;

        return new int[]{maxRank, minRank};
    }
}