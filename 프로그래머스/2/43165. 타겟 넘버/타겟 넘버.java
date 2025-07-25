class Solution {
    
    public static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);    
        return answer;
    }
    
    public void dfs(int idx, int num, int[] numbers, int target) {
        if (idx == numbers.length) {
            if (num == target) {
                answer++;
            }
            return;
        }

        
        dfs(idx + 1, num + numbers[idx], numbers, target);
        dfs(idx + 1, num - numbers[idx], numbers, target);
    }
}