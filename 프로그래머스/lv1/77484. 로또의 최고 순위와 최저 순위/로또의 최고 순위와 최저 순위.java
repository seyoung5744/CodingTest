import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public static int rank(int num){
        if(num == 6){
            return 1;
        }else if(num == 5){
            return 2;
        }else if(num == 4){
            return 3;
        }else if(num == 3){
            return 4;
        }else if(num == 2){
            return 5;
        }else{
            return 6;
        }
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Set<Integer> set = Arrays.stream(win_nums).boxed().collect(Collectors.toSet());

        int count = 0; // 맞힌 개수
        int zeroCount = 0;
        for (int lotto : lottos){
            if(set.contains(lotto)){
                count++;
            }
            if(lotto == 0){
                zeroCount++;
            }
        }

        answer[0] = rank(count+zeroCount);
        answer[1] = rank(count);
        return answer;
    }
}