class Solution {
    public String solution(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right - 1) {
            left++;
            right--;
        }
        
        String answer = s.charAt(left) + "";
        
        return left < right ? answer + s.charAt(right) : answer;
    }
}