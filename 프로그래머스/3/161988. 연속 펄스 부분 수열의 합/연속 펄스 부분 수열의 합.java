public class Solution {

    public static long solution(int[] sequence) {
        int[] arr1 = new int[sequence.length];
        int[] arr2 = new int[sequence.length];

        for (int i = 0; i < sequence.length; i++) {
            arr1[i] = (i % 2 == 0) ? sequence[i] * -1 : sequence[i];
            arr2[i] = (i % 2 == 0) ? sequence[i] : sequence[i] * -1;
        }

        return Math.max(findMax(arr1, 0, arr1.length - 1), findMax(arr2, 0, arr1.length - 1));
    }

    public static long findMax(int[] arr, int l, int r) {
        if (l > r) {
            return 0;
        }

        if (l == r) {
            return Math.max(0, arr[l]);
        }

        int mid = (l + r) / 2;

        long left = findMax(arr, l, mid);
        long right = findMax(arr, mid + 1, r);

        long leftMax = 0;
        long sum = 0;
        for (int i = mid; i >= l; i--) {
            sum += arr[i];
            leftMax = Math.max(leftMax, sum);
        }

        long rightMax = 0;
        sum = 0;
        for (int i = mid + 1; i <= r; i++) {
            sum += arr[i];
            rightMax = Math.max(rightMax, sum);
        }

        return Math.max(Math.max(leftMax + rightMax, left), right);
    }
}
