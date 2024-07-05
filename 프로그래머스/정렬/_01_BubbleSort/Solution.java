package 프로그래머스.정렬._01_BubbleSort;

import java.util.Arrays;

public class Solution {

    public static void sort(int[] arr) {

        for (int round = 1; round < arr.length; round++) {
            for (int i = 0; i < arr.length - round; i++) {
                if(arr[i] > arr[i + 1]) {
                    swap(i, i + 1, arr);
                }
            }
        }
    }

    public static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 6, 8, 2};

        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
