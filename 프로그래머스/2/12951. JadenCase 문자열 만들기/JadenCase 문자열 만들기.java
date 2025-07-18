class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                sb.append(c);
            } else {
                if (sb.length() == 0) {
                    sb.append(Character.toUpperCase(c));
                    continue;
                }
                if (sb.charAt(sb.length() - 1) == ' ') {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        return sb.toString();
    }
}