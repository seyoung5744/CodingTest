public class Solution {

    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int a = 0;
        for (int i = 0; i < arrayA.length; i++) {
            a = gcd(a, arrayA[i]);
        }

        int b = 0;
        for (int i = 0; i < arrayB.length; i++) {
            b = gcd(b, arrayB[i]);
        }

        boolean flagA = true;
        for (int i = 0; i < arrayA.length; i++) {
            if(arrayA[i] % b == 0) flagA = false;
        }

        boolean flagB = true;
        for (int i = 0; i < arrayB.length; i++) {
            if(arrayB[i] % a == 0) flagB = false;
        }

        if (flagA) {
            answer = b;
        }

        if (flagB) {
            answer = Math.max(answer, a);
        }

        return answer;
    }

    public static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

}
