class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        String reverse = new StringBuilder(str).reverse().toString();
        int[] answer = new int[reverse.length()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = reverse.charAt(i) - '0';
        }
        

        return answer;
    }
}