
public class Solution {

    public static long solution(int r1, int r2) {

        long inner = getInner1((long)r2) - getInner2((long)r1);
        long line = r2 - r1 + 1;
        
        return inner * 4 + line * 4;
    }

    public static long getInner1(long r) {
        long sum = 0;
        for (long x = 1; x < r; x++) {
            sum += (long) Math.sqrt((r * r) - (x * x));
        }
        return sum;
    }
    
    public static long getInner2(long r) {
        long sum = 0;
        for (long x = 1; x < r; x++) {
            long y = (long)Math.sqrt((r * r) - (x * x));
            sum += y;
            
            if (y*y == ((long)r * r) - (x * x))
                --sum;
        }
        
        return sum;
    }

}
