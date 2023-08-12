import java.util.HashSet;
import java.util.Set;

class Solution {

    public String solution(String myString){
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for(char c : myString.toCharArray()){
            if(set.contains(c)) continue;

            set.add(c);
            sb.append(c);
        }
        
        return sb.toString();
    }

}
