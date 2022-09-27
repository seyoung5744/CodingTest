class Solution {
    public String solution(int a, int b) {
        String[] days = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int[] months = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        int sum = 0;
        for (int i = 0; i < a; i++) {
            sum += months[i];
        }
  
        String answer = "";
        answer = days[(sum+b-1)%7];
        return answer;
    }
}