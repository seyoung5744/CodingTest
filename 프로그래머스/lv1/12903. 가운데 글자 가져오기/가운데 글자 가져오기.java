class Solution {
    public String solution(String s) {
        int point = s.length()/2;
        return (s.length() % 2 == 0) ? s.substring(point-1,point+1) : s.substring(point, point+1);
    }
}