import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> fail = new TreeMap<>();
        Arrays.sort(stages);
//        System.out.println(Arrays.toString(stages));

        int idx = 0;
        int length = stages.length;
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = idx; j < stages.length; j++) {
                if(i == stages[j]){
                    count++;
                }
            }
  
            if(length-idx == 0)
                fail.put(i, 0.0);
            else
                fail.put(i, (double) count / (length-idx));
            length -= idx;
            idx = count;
        }

        // Map.Entry 리스트 작성
        List<Map.Entry<Integer, Double>> list_entries = new ArrayList<>(fail.entrySet());
        // 비교함수 Comparator를 사용하여 오름차순으로 정렬
        Collections.sort(list_entries, new Comparator<Map.Entry<Integer, Double>>() {
            // compare로 값을 비교
            public int compare(Map.Entry<Integer, Double> obj1, Map.Entry<Integer, Double> obj2) {
                // 오름 차순 정렬
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        int index = 0;
        for(Map.Entry<Integer, Double> entry : list_entries) {
            answer[index++] = entry.getKey();
        }
        return answer;
    }
}