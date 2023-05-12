package 유형별_일고리즘_이론._06_정렬;

import java.util.Arrays;

public class 선택정렬 {

    public static int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

    public static void main(String[] args) {
        for (int i = 0; i < array.length - 1; i++) {
            int min_idx = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[min_idx] > array[j]) {
                    min_idx = j;
                }
            }

            swap(i, min_idx);
        }

        System.out.println(Arrays.toString(array));
    }

    public static void swap(int a, int b) {
        int tmp = array[b];
        array[b] = array[a];
        array[a] = tmp;
    }
}
