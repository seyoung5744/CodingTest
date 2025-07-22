import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        for (int startIdx = 0; startIdx < elements.length; startIdx++) {
            int idx = startIdx;
            int length = 0;
            
            int sum = 0;
            while (length < elements.length) {
                sum += elements[idx % elements.length];
                set.add(sum);
                length++;
                idx++;
            }
        }
        return set.size();
    }
}