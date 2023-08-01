class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        String reversed = new StringBuilder(str).reverse().toString();

        int[] answer = new int[reversed.length()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = reversed.charAt(i) - '0';
        }

        return answer;
    }
}