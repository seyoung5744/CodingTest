class Solution {
    public static int result;

    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target, 0);
        return result;
    }

    private static void dfs(int start, int[] numbers, int target, int count) {

        if (start == numbers.length) {
            if (count == target) {
                result += 1;
            }
            return;
        }

        dfs(start + 1, numbers, target, count + numbers[start]);
        dfs(start + 1, numbers, target, count - numbers[start]);
    }
}