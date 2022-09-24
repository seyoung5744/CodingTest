import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<String> strNum = new ArrayList<>();

        while(n > 0){
            strNum.add(Integer.toString(n % 3));
            n /= 3;
        }

        for (int i = 0; i < strNum.size(); i++) {
            answer += (Integer.parseInt(strNum.get(strNum.size() - i-1)) * Math.pow(3, i));
        }
        return answer;
    }
}