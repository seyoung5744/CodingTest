import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(String s) {
        s = s.replaceAll("\\{", "").replaceAll("}", "");
        String[] nums = s.split(",");
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (String num : nums) {
            int number = Integer.parseInt(num);
            if (!hashMap.containsKey(number)) {
                hashMap.put(number, 1);
            } else {
                hashMap.put(number, hashMap.get(number) + 1);
            }
        }

        int[] answer = new int[hashMap.size()];
        
        List<Map.Entry<Integer, Integer>> entries = hashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        for (int i = 0; i < entries.size(); i++) {
            answer[i] = entries.get(entries.size()-i-1).getKey();
        }
        return answer;
    }
}