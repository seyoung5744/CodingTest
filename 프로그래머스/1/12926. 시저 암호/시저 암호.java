class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append(c);
                continue;
            }

            int offset = Character.isUpperCase(c) ? 'A' : 'a';
            char next = (char) (((c + n) % offset) % 26 + offset);
            sb.append(next);
        }
        return sb.toString();
    }
}