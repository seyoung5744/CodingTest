class Solution {
    public int solution(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i - 1] = (arr[i] * arr[i - 1] ) / gcb(arr[i], arr[i - 1]);
        }
        return arr[0];
    }
    
    public int gcb(int a, int b) {
        
        while (b > 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}