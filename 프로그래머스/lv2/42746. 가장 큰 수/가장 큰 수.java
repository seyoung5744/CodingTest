import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numStr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numStr[i] = numbers[i] + "";
        }

        Arrays.sort(numStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if(numStr[0].equals("0")) return "0";
        for(String str : numStr){
            answer+= str;
        }

        return answer;
    }
}