class Solution {
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = find(numbers[i]);
        }

        return answer;
    }

    public static long find(long number) {

        if(number % 2 == 0) {
            return number + 1;
        }else {
            long num = 2;
            long tmp = number;

            while(tmp <= number) {
                tmp = number ^ num;

                if(tmp < number) {
//                    tmp ^= num;
                    num *= 2;
                }else {
                    tmp ^= num / 2;
                }
            }
            return tmp;
        }
    }
}