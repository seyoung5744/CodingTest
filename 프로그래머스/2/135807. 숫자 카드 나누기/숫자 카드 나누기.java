public class Solution {

    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int gcdA = gcd(arrayA);
        int gcdB = gcd(arrayB);

        if (canDivided(arrayA, gcdB)) {
            answer = gcdB;
        }

        if (canDivided(arrayB, gcdA)) {
            answer = Math.max(answer, gcdA);
        }

        return answer;
    }

    public static boolean canDivided(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % target == 0) {
                return false;
            }
        }
        return true;
    }

    public static int gcd(int[] arr) {
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    private static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

}
