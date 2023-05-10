package 유형별_일고리즘_이론._06_정렬;

import java.util.Arrays;

public class 퀵정렬 {

    public static void main(String[] args) {
        int n = 10;
        int[] arr = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};
        quickSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) { // 만약 원소가 1개일 경우 종료
            return;
        }

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            // 피벗보다 큰 데이터를 찾을 때까지 반복
            while (left <= end && arr[left] <= arr[pivot]) {
                left++;
            }

            // 피벗보다 작은 데이터를 찾을 때까지 반복
            while (right > start && arr[right] >= arr[pivot]) {
                right--;
            }

            // 엇갈렸다면 작은 데이터와 피벗을 교체
            if (left > right) {
                swap(arr, pivot, right);
            }
            // 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
            else {
                swap(arr, left, right);
            }
        }

        // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
