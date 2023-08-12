import java.util.*;

class Solution {
    private static int[] mem = new int[100_001];

    public int solution(int n) {
        Arrays.fill(mem, -1);
        return fibo(n);
    }

    private static int fibo(int n){
        if(mem[n] != -1) return mem[n];
        if(n < 2) return n;

        return mem[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
    }
}