import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = numbers[i] + "";
        }

        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if(strArr[0].equals("0")){
            return "0";
        }

        return String.join("", strArr);
    }
}