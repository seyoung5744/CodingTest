class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int num = 1; num <= number; num++) {
            int weapon = getDivisor(num);
            if (weapon > limit) {
                answer += power;
            } else {
                answer += weapon;
            }
        }
        return answer;
    }
    
    public int getDivisor(int num) {
        int count = 0;
        
        for (int i = 1; i * i <= num; i++) {
            if (i * i == num) count++;
            else if (num % i == 0){
                count += 2;
            }
        }
        return count;
    }
}