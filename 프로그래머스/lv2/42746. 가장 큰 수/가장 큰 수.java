import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(int[] numbers) {
        String[] strArr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        
        if(strArr[0].equals("0")) {
            return "0";
        }
        return Arrays.stream(strArr).collect(Collectors.joining());
    }
}