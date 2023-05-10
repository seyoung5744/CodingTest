package 유형별_일고리즘_이론._06_정렬;

public class 계수정렬 {

    public static final int MAX_VALUE = 9;

    public static void main(String[] args) {
        // 모든 원소의 값이 0보다 크거나 같다고 가정
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};

        // 모든 범위를 포함하는 리스트 선언(모든 값은 0으로 초기화)
        int[] cnt = new int[MAX_VALUE + 1];

        for (int num : arr) {
            cnt[num] += 1;
        }

        for (int i = 0; i <= MAX_VALUE; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }

}
