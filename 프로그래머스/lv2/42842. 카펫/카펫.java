import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        ArrayList<Integer> aliquotNum = new ArrayList<>();
        int sum = brown + yellow;
        for (int i = 1; i <= sum/2; i++) {
            if(sum % i == 0){
                aliquotNum.add(i);
            }
        }
        aliquotNum.add(sum);

        int row = 0, col = 0;
        int length = aliquotNum.size() % 2 == 0? aliquotNum.size()/2 : (aliquotNum.size()/2) +1;
        for (int i = 0; i < length; i++) {
            row = aliquotNum.get(i);
            col = sum / row;
            if( col >= row){
                if((row - 2)*(col -2)==yellow){
                    answer[0] = col;
                    answer[1] = row;
                }
            }
        }
        return answer;
    }
}