import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> prefixes = new HashSet<>();
        for(String phone : phone_book){
            for (int end = 1; end < phone.length(); end++) {
                prefixes.add(phone.substring(0, end));
            }
        }
        
        for(String phone : phone_book){
            if(prefixes.contains(phone)){
                return false;
            }
        }
        
        return true;
    }
}