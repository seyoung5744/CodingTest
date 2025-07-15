class Solution {
    public int solution(String s) {
        int answer = 0;

        char xChar = 0;
        int x = 0;
        
        int notX = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (xChar == 0) {
                xChar = s.charAt(i);
                x = 1;
                continue;
            }
            
            if (s.charAt(i) == xChar) {
                x++;
            } else {
                notX++;
            }
            
            if (x == notX) {
                answer++;
                xChar = 0;
                x = 0;
                notX = 0;
            }
        }
        if (xChar != 0) {
            answer++;
        }
        return answer;
    }
    
}