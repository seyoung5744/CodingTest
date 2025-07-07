class Solution {
    public double solution(int[] numbers) {
        return getSum(numbers) / numbers.length;
    }
    
    public double getSum(int[] nums) {
        double sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        return sum;
    }
}