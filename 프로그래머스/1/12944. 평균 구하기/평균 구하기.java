class Solution {
    public double solution(int[] arr) {
        return getSum(arr) / arr.length;
    }
    
    public double getSum(int[] arr) {
        double sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}