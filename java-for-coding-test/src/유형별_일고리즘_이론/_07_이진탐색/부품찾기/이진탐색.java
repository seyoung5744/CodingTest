package 유형별_일고리즘_이론._07_이진탐색.부품찾기;

import java.util.Arrays;
import java.util.Scanner;

public class 이진탐색 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int m = sc.nextInt();

        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int result = binarySearch(arr, targets[i], 0, n - 1);
            if (result != -1) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            // 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == target) {
                return mid;
            }
            // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            else if (arr[mid] > target) {
                end = mid - 1;
            }
            // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

}
