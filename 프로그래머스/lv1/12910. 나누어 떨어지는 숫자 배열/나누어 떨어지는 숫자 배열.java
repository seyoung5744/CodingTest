import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).sorted().filter( n -> n % divisor == 0).toArray();

        return answer.length == 0? new int[]{-1}: answer;
    }
}