class Solution {
    public String solution(String s, int n) {
        char[] chars = s.toCharArray();
        char[] shiftChars = new char[s.length()];
        int start, end;

        for (int i = 0; i < s.length(); i++) {
            if(chars[i] >= 'a' && chars[i] <= 'z'){
                start = 'a';
                end = 'z';
            }else{
                start = 'A';
                end = 'Z';
            }

            if (chars[i] + n > end) {
                shiftChars[i] = (char) (((chars[i] + n) % end) + (start - 1));
            }else if(chars[i] == ' '){
                shiftChars[i] = chars[i];
            }else{
                shiftChars[i] = (char)(chars[i] + n);
            }
        }

        return String.valueOf(shiftChars);
    }
}