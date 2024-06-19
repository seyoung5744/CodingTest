public class Solution {

    public static int solution(int[] a) {
        int answer = 0;

        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];

        leftMin[0] = a[0];
        rightMin[a.length - 1] = a[a.length - 1];

        for (int i = 1; i < a.length; ++i) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i - 1]);
        }

        for (int i = a.length - 2; i >= 0; --i) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i + 1]);
        }

        for (int mid = 0; mid < a.length; mid++) {
            int num = a[mid]; // 가능하냐 안하냐;

            if (num > leftMin[mid] && num > rightMin[mid]) {
                continue;
            }

            answer++;
        }

        return answer;
    }
}
