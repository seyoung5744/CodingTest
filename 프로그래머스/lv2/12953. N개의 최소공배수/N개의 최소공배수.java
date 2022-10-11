import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        Stack<Integer> stack = new Stack<>();
        // IntStream.of(arr).forEach(stack::push);
        // for문으로 stack에 넣는게 stream보다 더 빠름
        for (int i : arr) {
            stack.push(i);
        }
        while(stack.size() != 1) {
            int a = stack.pop();
            int b = stack.pop();
            int gcd = gcd(Math.min(a, b), Math.max(a, b));
            int lcm = a*b/gcd;
            stack.push(lcm);
        }
        
        return stack.pop();
    }
    public static int gcd(int a, int b){
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}