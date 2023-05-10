package 유형별_일고리즘_이론._04_구현;

import java.util.Scanner;

public class 게임개발 {

    public static int n, m, x, y, direction;

    // 방문한 위치를 저장하기 위한 맵을 생성하여 0으로 초기화
    public static int[][] visited = new int[50][50];

    // 전체 맵 정보
    public static int[][] map = new int[50][50];

    // 북, 동, 남, 서 방향
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void turnLeft() {
        direction -= 1;
        if (direction == -1) {
            direction = 3;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M 을 공백을 기준으로 구분하여 입력받기
        n = sc.nextInt();
        m = sc.nextInt();

        // 현재 캐릭터의 x, y, 방향 입력받기
        x = sc.nextInt();
        y = sc.nextInt();
        direction = sc.nextInt();

        // 현재 좌표 방문 처리
        visited[x][y] = 1;

        // 전체 맵 정보 입력받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int cnt = 1;
        int turn_time = 0;

        while(true){
            // 왼쪽으로 회전
            turnLeft();

            int nextX = x + dx[direction];
            int nextY = y + dy[direction];

            // 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
            if(visited[nextX][nextY] == 0 && map[nextX][nextY] == 0){
                visited[nextX][nextY] = 1;
                x = nextX;
                y = nextY;
                cnt += 1;
                turn_time = 0;
                continue;
            }
            // 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
            else{
                turn_time += 1;
            }

            // 4방향 모두 갈 수 없는 경우
            if(turn_time == 4){
                nextX = x - dx[direction];
                nextY = y - dy[direction];
                // 뒤로 갈 수 있다면 이동
                if(map[nextX][nextY] == 0){
                    x = nextX;
                    y = nextY;
                }
                // 뒤가 바다로 막혀있는 경우
                else break;
                turn_time  = 0;
            }
        }

        System.out.println(cnt);

    }

}
