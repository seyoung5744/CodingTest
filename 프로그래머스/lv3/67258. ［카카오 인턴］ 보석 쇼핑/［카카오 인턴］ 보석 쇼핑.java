import java.util.*;

public class Solution {

    public int[] solution(String[] gems) {
        int[] answer = {};
        Set<String> gemSet = new HashSet<>(List.of(gems));

        int start = 0;
        int end = gems.length - 1;

        int s = 0;
        int e = 0;
        
        Map<String, Integer> includes = new HashMap<>();
        includes.put(gems[s], 1);

        while (s < gems.length) {

            if (includes.keySet().size() == gemSet.size()) { // 모든 보석을 포함하고 있다면
                if (e - s < end - start) { // 구간 검사해서 더 짧은 구간으로 갱신
                    start = s;
                    end = e;
                }

                // s 부분 보석 빼기
                includes.put(gems[s], includes.get(gems[s]) - 1);
                if (includes.get(gems[s]) == 0) {
                    includes.remove(gems[s]);
                }
                s++;
            } else if (e < gems.length - 1) { // e 가 배열 끝보다 작으면
                e++;
                includes.put(gems[e], includes.getOrDefault(gems[e], 0) + 1);
            } else { // 배열 범위를 넘어서면 남은 보석으론 답 추론 불가 => 종료
                break;
            }
        }
        
        return new int[]{start + 1, end + 1};
    }
}
