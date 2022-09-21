class Solution {
    private int sum = 0;
    public boolean solution(int x) {
//         int sum = 0;
//         int n = x;
//         while(n > 0){
//             sum += (n % 10);
//             n /= 10;
//         }

//         return (x % sum) == 0;
        sum = 0;
        Integer.toString(x).chars().forEach(c -> sum += (c - '0'));
        return x % sum == 0;
    }
}