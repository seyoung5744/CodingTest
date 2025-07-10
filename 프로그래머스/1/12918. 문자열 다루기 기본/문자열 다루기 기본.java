class Solution {
    public boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) return false;
        
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - '0';
            if (c < 0 || c > 9) return false;
        }
        return true;
    }
}