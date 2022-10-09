import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int[] people = new int[n];
        ArrayList<String> afterWords = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            people[i%n] += 1;
//            System.out.println("사람 " + (i%n+1) + " 차례 : " + people[i%n]);
            if(i > 0 && afterWords.get(i-1).charAt(afterWords.get(i-1).length()-1) != words[i].charAt(0) || afterWords.contains(words[i])){
                answer[0] = (i%n+1);
                answer[1] = people[i%n];
//                System.out.println("정답 " + (i%n+1)+ " 차례 : " + people[i%n]);
                break;
            }

            afterWords.add(words[i]);
        }
      return answer;
    }
}