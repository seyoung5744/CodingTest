package 유형별_일고리즘_이론._07_이진탐색;

import java.util.Scanner;

public class 떡볶이_떡_만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 떡의 개수(N)와 요청한 떡의 길이(M)
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 각 떡의 개별 높이 정보
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = (int) 1e9;

        int result = 0;
        while(start <= end){
            int total = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < n; i++) {
                if(arr[i] > mid){
                    total += arr[i] - mid;
                }
            }

            // 떡의 양이 부족한 경우 더 많이 자르기(왼쪽 부분 탐색)
            if(total < m){
                end = mid - 1;
            }
            // 떡의 양이 충분한 경우 덜 자르기(오른쪽 부분 탐색)
            else{
                result = mid; // 최대한 덜 잘랐을 때가 정답이므로, 여기에서 result에 기록
                start = mid + 1;
            }
        }

        System.out.println(result);
    }

}
