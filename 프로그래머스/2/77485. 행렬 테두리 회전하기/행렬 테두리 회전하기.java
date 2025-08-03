class Solution {
    public static final int[] dx = {1, 0, -1, 0}; // 우, 하, 좌, 상
    public static final int[] dy = {0, 1, 0, -1};

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] map = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }

        for (int i = 0; i < queries.length; i++) {

            int y1 = queries[i][0] - 1;
            int x1 = queries[i][1] - 1;
            int y2 = queries[i][2] - 1;
            int x2 = queries[i][3] - 1;

            int curX = x1;
            int curY = y1;
            int curDir = 0;

            int cur = map[y1][x1];
            answer[i] = cur;
            int next = 0;
            int loop = (x2 - x1) * 2 + (y2 - y1) * 2;
            System.out.println(loop);
            while (loop-- > 0) {
                int nx = curX + dx[curDir];
                int ny = curY + dy[curDir];
                if (nx < x1 || nx > x2 || ny < y1 || ny > y2) {
                    curDir = (curDir + 1) % 4;
                    nx = curX + dx[curDir];
                    ny = curY + dy[curDir];
                }

                next = map[ny][nx];
                map[ny][nx] = cur;
                cur = next;
                answer[i] = Math.min(cur, answer[i]);
                curX = nx;
                curY = ny;
            }

        }
        return answer;
    }
}