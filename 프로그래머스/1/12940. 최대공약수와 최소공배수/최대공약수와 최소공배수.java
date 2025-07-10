class Solution {
    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        return new int[] {gcd, (n * m) / gcd};
    }
    
    public int gcd(int a, int b) {
        while(b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
}