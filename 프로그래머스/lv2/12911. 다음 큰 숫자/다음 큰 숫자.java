class Solution {
    public int solution(int n) {
       int answer = 0;

        int bitCnt = Integer.bitCount(n);
        int num = 0;
        while(bitCnt != num){
            n++;
            num = Integer.bitCount(n);
            if(bitCnt == num){
                answer = n;
            }

        }

        return answer;
    }
}