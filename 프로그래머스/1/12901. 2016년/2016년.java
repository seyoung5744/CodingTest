class Solution {
    private static final int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] days = {"THU","FRI","SAT","SUN", "MON","TUE","WED"};
    
    public String solution(int a, int b) {
        System.out.println(convert(a, b));
        return days[convert(a, b) % 7];
    }
    
    public int convert(int month, int day) {
        int total = 0;
        for (int i = 0; i < month - 1; i++) {
            total += months[i];
        }
        return total + day;
    }
}