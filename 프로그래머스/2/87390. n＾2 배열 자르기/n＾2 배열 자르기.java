import java.util.stream.*;

class Solution {
    private static long[] getRowCol(int n, long left){
        return new long[]{left / n, left % n};
    }
    
    public int[] solution(int n, long left, long right) {
        // int[] answer = new int[(int)(right - left + 1)];
        
        return LongStream.rangeClosed(left, right)
            .mapToInt(value -> (int)Math.max(value / n, value % n) + 1).toArray();
//         for(long i = left; i <= right; i++) {
//             long[] rowcol = getRowCol(n, i);
//             long row = rowcol[0];
//             long col = rowcol[1];
//             int index = (int)(i - left);
//             if(col <= row) {
//                 answer[index] = (int)row + 1;
//             }else {
//                 answer[index] = (int)col + 1;
//             }
//         }
        
//         return answer;
    }
}