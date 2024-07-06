package 프로그래머스.정렬._03_insertion_sort;

import java.util.Arrays;

public class Review01 {

    public static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];

            int j = i - 1;
            while (j >= 0 && arr[j] > target) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = target;
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 5, 1, 4, 6, 8, 2};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
