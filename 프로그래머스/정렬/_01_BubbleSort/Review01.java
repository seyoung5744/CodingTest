package 프로그래머스.정렬._01_BubbleSort;

import java.util.Arrays;

public class Review01 {

    public static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            boolean swapped = false;

            for (int j = 0; j < arr.length - i; j++) {
               if(arr[j] > arr[j + 1]) {
                   swap(j, j + 1, arr);
                   swapped = true;
               }
            }

            if(!swapped) {
                break;
            }
        }
    }

    public static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 5, 1, 4, 6, 8, 2};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
