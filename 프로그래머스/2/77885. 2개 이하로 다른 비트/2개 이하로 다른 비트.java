class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
                continue;
            }

            String binaryString = Long.toBinaryString(numbers[i]);
            char[] next = ('0' + binaryString).toCharArray();
            for (int j = next.length - 1; j >= 0; j--) {
                if (next[j] == '0') {
                    next[j + 1] = '0';
                    next[j] = '1';
                    break;
                }
            }
            answer[i] = Long.parseLong(String.valueOf(next), 2);

        }
        return answer;
    }
}