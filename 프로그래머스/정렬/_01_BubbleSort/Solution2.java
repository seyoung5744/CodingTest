package 프로그래머스.정렬._01_BubbleSort;

import java.util.Arrays;

public class Solution2 {

    public static void sort(int[] arr) {

        for (int round = 1; round < arr.length; round++) {

            boolean swapped = false;

            for (int i = 0; i < arr.length - round; i++) {
                if(arr[i] > arr[i + 1]) {
                    swap(i, i + 1, arr);
                    swapped = true;
                }
            }
            System.out.println("스왑 여부 : " + swapped + " : " + Arrays.toString(arr));
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
//        int[] arr = {3, 1, 4, 6, 8, 2};
        int[] arr = {1, 2, 4, 3, 6, 8};

        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
