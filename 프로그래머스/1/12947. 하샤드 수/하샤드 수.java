class Solution {
    public boolean solution(int x) {
        return x % getDigitSum(x) == 0;
    }
    
    public int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}