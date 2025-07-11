class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int num = left; num <= right; num++) {
            int count = getDivivorCount(num);
            if (count % 2 == 0) {
                answer += num;
            } else {
                answer -= num;
            }
        }
        return answer;
    }
    
    public int getDivivorCount(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (i * i == num) count++;
            else if (num % i == 0) count += 2;
        }
        return count;
    }
}