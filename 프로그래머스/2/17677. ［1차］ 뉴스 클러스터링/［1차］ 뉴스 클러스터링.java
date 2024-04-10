import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static int solution(String str1, String str2) {
        List<String> set1 = createSet(str1);
        List<String> set2 = createSet(str2);

        int intersectionSize = getIntersectionSize(set1, set2);
        int unionSize = set1.size() + set2.size() - intersectionSize;
        return unionSize == 0? 65536 : (int)(((double)intersectionSize / unionSize) * 65536) ;
    }

    public static List<String> createSet(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            String token = s.substring(i, i + 2);
            if (Character.isAlphabetic(token.charAt(0)) && Character.isAlphabetic(token.charAt(1))) {
                result.add(token.toLowerCase());
            }
        }
        return result;
    }

    public static int getIntersectionSize(List<String> set1, List<String> set2) {
        int size = 0;
        Map<String, Integer> map = new HashMap<>();
        for(String set : set1) {
            map.put(set, map.getOrDefault(set, 0) + 1);
        }

        for(String set : set2) {
            if(map.containsKey(set) && map.get(set) > 0) {
                map.put(set, map.get(set) - 1);
                size += 1;
            }
        }
        return size;
    }

}
