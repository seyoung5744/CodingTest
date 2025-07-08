class Solution {
    public int solution(String s) {
        
        boolean isMinus = false;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '-') {
                isMinus = true;
            } else if (c != '+') {
                result = result * 10 + (c - '0');    
            }
        }
        
        
        return isMinus? result * -1 : result;
    }
}