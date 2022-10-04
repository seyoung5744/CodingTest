class Solution {
    public int[] solution(String s) {
        int zeroCnt = 0;
        int cnt = 0;
        int length;

        while(!s.equals("1")){
            length = s.length();
            s = s.replaceAll("[^1]", "");
            zeroCnt += (length - s.length());
            s = Integer.toBinaryString(s.length());
            cnt++;
        }
        return new int[]{cnt, zeroCnt};
    }
}