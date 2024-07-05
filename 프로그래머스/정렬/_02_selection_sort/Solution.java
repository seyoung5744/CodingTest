package 프로그래머스.정렬._02_selection_sort;

import java.util.Arrays;

public class Solution {

    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            swap(i, minIdx, arr);
        }
    }

    public static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    
    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 1, 6};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
