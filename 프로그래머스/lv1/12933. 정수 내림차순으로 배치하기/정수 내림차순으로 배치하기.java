import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        String result = "";
        ArrayList<String> list = new ArrayList<>();
        Long.toString(n).chars().forEach(c->list.add(String.valueOf(c - '0')));
        Collections.sort(list, Collections.reverseOrder());
        for (String s : list){
            result += s;
        }
        return Long.parseLong(result);
    }
}