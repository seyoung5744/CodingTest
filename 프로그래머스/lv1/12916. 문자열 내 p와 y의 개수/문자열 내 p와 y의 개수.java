class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        
        int p = s.replace("y","").length();
        int y = s.replace("p","").length();

        return p==y;
    }
}