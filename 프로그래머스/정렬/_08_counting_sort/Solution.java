package 프로그래머스.정렬._08_counting_sort;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        // 전체 크기는 30으로 제한
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            // Math.random을 통해 값의 범위는 0 ~ 19 까지로 제한
            arr[i] = (int) (Math.random() * 20);
        }
        System.out.println("원본 배열 : " + Arrays.toString(arr));

        countingSort(arr);

        System.out.println("정렬 결과 : " + Arrays.toString(arr));
    }

    private static void countingSort(int[] arr) {
        // 최댓값을 찾는다.
        int max = Arrays.stream(arr).max().getAsInt();

        // 음수가 전달될 경우를 대비, 최솟값을 찾는다.
        int min = Arrays.stream(arr).min().getAsInt();

        // Count 배열의 크기를 결정
        int range = max - min + 1;
        int[] count = new int[range];

        // result 배열도 생성 ( 정렬이 완료된 배열이므로 기존 배열 크기와 동일하게 설정)
        int[] result = new int[arr.length];

        // 각 배열의 값이 몇 번 나왔는지 넣어주자
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min] += 1; // 최소값을 빼줌으로써 0번 index부터 사용 가능
        }

        // count 배열의 누적합을 구함(Modify)
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // count 배열은 사실상 어디에 위치시킬지 값을 저장한 Modified 배열이므로 그 값을 통해서 result 배열에 원래 값을 저장
        for (int i = arr.length - 1; i >= 0; i--) {
            result[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min] -= 1;
        }

        for (int i = 0; i < result.length; i++) {
            arr[i] = result[i];
        }
    }
}
