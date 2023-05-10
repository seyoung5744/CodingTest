package 유형별_일고리즘_이론._04_구현;

import java.util.Scanner;

public class 왕실의나이트 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 현재 나이트 위치 입력 받기
        String inputData = sc.nextLine();
        int row = inputData.charAt(1) - '0';
        int col = inputData.charAt(0) - 'a' + 1;

        // 나이트가 이동할 수 있는 방향 8가지
//        int[][] steps = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, 2}, {1, 2}, {-1, -2}, {1, -2}};
        int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
        int[] dy = {-1, 1, -1, 1, 2, 2, -2, -2};

        // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
        int count = 0;
        for (int i = 0; i < 8; i++) {
            // 이동하고자 하는 위치 확인
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];

            // 해당 위치로 이동이 가능하다면 카운트 증가
            if (nextRow >= 1 && nextCol >= 1 && nextRow <= 8 && nextCol <= 8) {
                count++;
            }
        }

        System.out.println(count);
    }

}
