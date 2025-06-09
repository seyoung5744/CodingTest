class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        boolean isSpace = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append(c);
                isSpace = true;
                continue;
            }
            if (isSpace) {
                if (Character.isAlphabetic(c)) {
                    c = Character.toUpperCase(c);
                }
                
            } else {
                c = Character.toLowerCase(c);
            }
            sb.append(c);
            isSpace = false;
        }
        return sb.toString();
    }
}