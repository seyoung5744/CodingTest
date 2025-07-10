class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int cIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == ' ') {
                cIdx = 0;
                sb.append(c);
                continue;
            }
            
            if (cIdx % 2 == 0) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
            cIdx++;            
        }
        return sb.toString();
    }
}