public class Solution {

    public static long solution(int r1, int r2) {
        long answer = 0;

        long inner1 = 0;
        for (int x = 1; x <= r2; x++) {
            double inY = Math.sqrt((((long) r1 * r1) - ((long) x * x)));
            double outY = Math.sqrt((((long) r2 * r2) - ((long) x * x)));

            if (x >= r1)
                inY = 0;

            inner1 += Math.floor(outY) - Math.ceil(inY) + 1;
        }

        return inner1 * 4;
    }

}
