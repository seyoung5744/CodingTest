import java.util.*;

class Solution {
    
    public static int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int[] a = getDivisor(arrayA);
        int[] b = getDivisor(arrayB);

        return Math.max(getMax(a, arrayB), getMax(b, arrayA));
    }

    public static int getMax(int[] arr, int[] target) {
        for (int i = arr.length - 1; i >= 0; i--) {

            boolean flag = true;

            for (int j = 0; j < target.length && flag; j++) {
                if(target[j] % arr[i] == 0) {
                    flag = false;
                }
            }

            if(flag) {
                return arr[i];
            }
        }
        return 0;
    }
    public static int[] getDivisor(int[] arr) {
        List<Integer> result = new ArrayList<>();

        for (int i = 2; i <= arr[0]; i++) {
            boolean flag = true;

            for (int j = 0; j < arr.length && flag; j++) {
                if(arr[j] % i != 0) {
                    flag = false;
                }
            }

            if(flag) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}