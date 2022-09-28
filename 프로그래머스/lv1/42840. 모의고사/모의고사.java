import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[][] students = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] count = new int[3];

        for (int i = 0; i < answers.length; i++) { // 0 1 2 3 4 / 5 6 7 8 9
            for (int j = 0; j < students.length; j++) {
                if(answers[i] == students[j][(students[j].length + i) % students[j].length]){
                    count[j]++;
                }
            }
        }


        int[] indexs = new int[3];
        int max = count[0];
        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            if(count[i] > max){
                max = count[i];
                idx = i;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if(max == count[i]){
                indexs[i] = i+1;
            }
        }

        ArrayList<Integer> an = new ArrayList<>();

        for (int i = 0; i < indexs.length; i++) {
            if(indexs[i] != 0) {
                an.add(indexs[i]);
            }
        }

        int[] answer = an.stream()
                .mapToInt(i -> i)
                .toArray();

        return answer;
    }
    
}