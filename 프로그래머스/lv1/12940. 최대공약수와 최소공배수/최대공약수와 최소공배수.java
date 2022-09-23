class Solution {
    public static int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        return new int[]{gcd(n, m), n * m / gcd};
    }
    public static int gcd(int n, int m){
        if(n % m == 0){
            return m;
        }
        return gcd(m, n%m);
    }
}