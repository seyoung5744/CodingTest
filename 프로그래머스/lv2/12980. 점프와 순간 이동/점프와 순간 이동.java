import java.util.*;

public class Solution {
        public int solution(int n) {
            int ans = 0;

        while(n > 0){
            if(n % 2 == 0){ // 짝수면
                n /= 2;
                // System.out.println("2 나누기 : " +n);
            }else{ // 홀수면
                n-=1;
                ans+=1;
                // System.out.println("1 빼기 : " + n);
            }
        }

        return ans;
        }
}