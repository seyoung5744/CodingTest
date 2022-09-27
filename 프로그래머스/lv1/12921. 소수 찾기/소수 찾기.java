import java.util.*;
class Solution {
    public int solution(int n) {
        boolean[] flags = new boolean[n+1];
        Arrays.fill(flags, true);

        // 소수는 true
        // 0, 1 은 소수가 아니므로 false
        flags[0] = flags[1] = false;

        // 주어진 n의 n*(1/2)까지만 검사하면 됨.
        for (int i = 2; i*i <=n ; i++) {
            // 만약 i가 소수 혹은 아직 지워지지 않았다면.
            if(flags[i]){
                // i의 배수 j들에 대해 flags[j] = false;
                // i*i 미만은 이미 지워졌으므로 신경X
                for (int j = i*i; j <= n; j+=i) {
                    flags[j] = false;
                }
            }
        }
        int count = 0;
        for (boolean flag : flags){
            if(flag){
                count++;
            }
        }
        return count;
    }
}