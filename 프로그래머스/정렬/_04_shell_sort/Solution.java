package 프로그래머스.정렬._04_shell_sort;

import java.util.Arrays;

public class Solution {

    private final static int[] gap =
        {1, 4, 10, 23, 57, 132, 301, 701, 1750, 3937,
            8858, 19930, 44842, 100894, 227011, 510774,
            1149241, 2585792, 5818032, 13090572, 29453787,
            66271020, 149109795, 335497038, 754868335, 1698453753};    // 갭을 담고있는 배열

    public static void shellSort(int[] arr) {
        shellSort(arr, arr.length);
    }

    // 맨 처음 gap을 참조 할 인덱스를 구하는 메소드
    public static int getGap(int size) {
        int index = 0;
        int len = (int) (size / 2.25);
        while (gap[index] < len) {
            index++;
        }
        return index;
    }

    public static void shellSort(int[] arr, int size) {
        int index = getGap(size);
        for (int i = index; i >= 0; i--) {
            for (int j = 0; j < gap[i]; j++) {
                insertionSort(arr, j, size, gap[i]);
            }
        }
    }

    public static void insertionSort(int[] arr, int start, int size, int gap) {

        for (int i = start + gap; i < size; i += gap) {

            int target = arr[i];

            int j = i - gap;

            while (j >= start && arr[j] > target) {
                arr[j + gap] = arr[j];
                j -= gap;
            }

            arr[j + gap] = target;
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 5, 1, 4, 6, 8, 2};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
