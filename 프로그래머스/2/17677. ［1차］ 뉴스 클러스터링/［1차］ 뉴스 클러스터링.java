import java.util.*;

public class Solution {

    public static int solution(String str1, String str2) {
        Map<String, Integer> map1 = createSet(str1);
        int sum1 = map1.values().stream().mapToInt(Integer::intValue).sum();

        Map<String, Integer> map2 = createSet(str2);
        int sum2  = map2.values().stream().mapToInt(Integer::intValue).sum();

        if(sum1 == 0 && sum2 == 0) {
            return 65536;
        }
        
        double intersection = getIntersection(map1, map2);
        double union = sum1 + sum2 - intersection;

        return (int)((intersection / union) * 65536);
    }

    public static double getIntersection(Map<String, Integer> map1, Map<String, Integer> map2) {
        double result = 0;

        for(Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();

            if(map2.containsKey(key)) {
                result += Math.min(map1.get(key), map2.get(key));
            }
        }

        return result;
    }

    public static Map<String, Integer> createSet(String str) {
        String sub = "";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            sub = str.substring(i, i + 2);

            if(Character.isAlphabetic(sub.charAt(0)) && Character.isAlphabetic(sub.charAt(1))) {
                sub = sub.toLowerCase();
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }
        return map;
    }

}
