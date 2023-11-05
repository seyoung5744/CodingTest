import java.util.*;

class Solution {
    public int[] solution(String[] names, int[] yearning, String[][] photos) {
        int[] answer = new int[photos.length];
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < names.length; i++) {
            map.put(names[i], yearning[i]);
        }

        for(int i = 0; i < photos.length; i++) {
            for(int j = 0; j < photos[i].length; j++) {
                if(map.containsKey(photos[i][j])) {
                    answer[i] += map.get(photos[i][j]);
                }
            }
        }
        
        return answer;
    }
}