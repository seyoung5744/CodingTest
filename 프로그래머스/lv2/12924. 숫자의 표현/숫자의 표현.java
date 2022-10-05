class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 등차수열 공식 사용...
//         for (int i = 1; i <= n; i++) {
//             double x = (double)n/i - ((double)i/2) + 0.5;

//             if ((x == Math.floor(x)) && x > 0) {
//                 answer++;
//             }
//         }
        
         for (int i = 1; i <=n ; i+=2) {
            if(n % i == 0)
                answer++;
        }

        return answer;
    }
}