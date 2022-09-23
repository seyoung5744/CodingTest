class Solution {
    public boolean solution(String s) {
       boolean answer = false;

        if(s.length() == 4 || s.length() == 6) {
            char[] chars = s.toCharArray();
            for (char ch : chars) {
                answer = true;
                System.out.print((ch - '0') + " ");
                if (ch - '0' > 9) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}