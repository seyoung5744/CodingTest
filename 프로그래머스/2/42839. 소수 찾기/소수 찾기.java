import java.util.*;

class Solution {
    
     public static Set<Integer> set = new HashSet<>();

    public static int solution(String numbers) {
        String[] tokens = numbers.split("");
        int[] nums = numbers.chars().map(i -> i - '0').toArray();

        generate(0, new boolean[tokens.length], nums);

        return set.size();
    }

    private static void generate(int num, boolean[] visited, int[] nums) {

        if (isPrime(num)) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) continue;

            int nextNum = num * 10 + nums[i];

            visited[i] = true;
            generate(nextNum, visited, nums);
            visited[i] = false;
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}