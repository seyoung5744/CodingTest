package _15_이진탐색._27_정렬된_배열에서_특정_수의_개수_구하기;

import java.util.Scanner;

public class Main {
    public static int lowerBound(int[] arr, int target, int start, int end) {
        while(start<end){
            int mid = (start + end) / 2;
            if(arr[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public static int upperBound(int[] arr, int target, int start, int end) {
        while(start<end){
            int mid = (start + end) / 2;
            if(arr[mid] > target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    // 값이 [left_value, right_value]인 데이터의 개수를 반환하는 함수
    public static int countByRound(int[] arr, int leftValue, int rightValue) {
        // 유의: lowerBound와 upperBound는 end 변수의 값을 배열의 길이로 설정
        int leftIndex = lowerBound(arr, leftValue, 0, arr.length);
        int rightIndex = upperBound(arr, rightValue, 0, arr.length);
        return rightIndex - leftIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = countByRound(nums, x, x);

        if (result == 0) {
            System.out.println(-1);
        }else{
            System.out.println(result);
        }

    }
}
