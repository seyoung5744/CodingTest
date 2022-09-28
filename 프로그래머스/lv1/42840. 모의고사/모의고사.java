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
        System.out.println("맞힌 개수 : " + Arrays.toString(count));

        int max = count[0];
        for (int i = 0; i < count.length; i++) {
            if(count[i] > max){
                max = count[i];
            }
        }

        ArrayList<Integer> an = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if(max == count[i]){
                an.add(i+1);
            }
        }
        
        int[] answer = an.stream()
                .mapToInt(i -> i)
                .toArray();

        return answer;
    }
    
}