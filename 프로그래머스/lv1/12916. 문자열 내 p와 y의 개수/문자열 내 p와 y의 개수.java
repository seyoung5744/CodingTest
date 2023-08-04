class Solution {
    boolean solution(String s) {
        int p = s.toLowerCase().replace("y","").length();
        int y = s.toLowerCase().replace("p","").length();

        return p==y;
    }
}