package 유형별_일고리즘_이론._07_이진탐색;

import java.util.Scanner;

public class 재귀함수_이진탐색 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n(원소의 개수)과 target(찾고자하는 문자열)을 입력받기
        int n = sc.nextInt();
        int target = sc.nextInt();

        // 전체 원소 입력받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = binarySearch(arr, target, 0, n - 1);
        if (result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        } else {
            System.out.println(result + 1);
        }
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        // 찾은 경우 중간점 인덱스 반환
        if (arr[mid] == target)return mid;
        // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
        else if (arr[mid] < target) return binarySearch(arr, target, mid + 1, end);
        // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
        else return binarySearch(arr, target, start, mid - 1);

    }
}
