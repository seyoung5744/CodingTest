class Solution {
    public static int[] dx = {0, 0, 1, -1}; // 상, 하, 우, 좌
    public static int[] dy = {-1, 1, 0, 0};

    public static boolean[][] redVisited;
    public static boolean[][] blueVisited;

    public static int answer = Integer.MAX_VALUE;

    public static int solution(int[][] maze) {

        redVisited = new boolean[maze.length][maze[0].length];
        blueVisited = new boolean[maze.length][maze[0].length];

        int[] red = getPoint(maze, 1);
        int[] blue = getPoint(maze, 2);
        redVisited[red[1]][red[0]] = true;
        blueVisited[blue[1]][blue[0]] = true;
        dfs(red[0], red[1], blue[0], blue[1], 0, maze, redVisited, blueVisited);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    public static void dfs(int rx, int ry, int bx, int by, int round, int[][] maze, boolean[][] redVisited, boolean[][] blueVisited) {

        if(maze[ry][rx] == 3 && maze[by][bx] == 4) {
            answer = Math.min(answer, round);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int rnx = dx[i] + rx;
            int rny = dy[i] + ry;

            if(maze[ry][rx] == 3) {
                rnx = rx;
                rny = ry;
                redVisited[rny][rnx] = false;
            }

            if(rnx < 0 || rnx >= maze[0].length || rny < 0 || rny >= maze.length || redVisited[rny][rnx] || maze[rny][rnx] == 5) continue;

            redVisited[rny][rnx] = true;
            for (int j = 0; j < 4; j++) {
                int bnx = dx[j] + bx;
                int bny = dy[j] + by;

                if(maze[by][bx] == 4) {
                    bnx = bx;
                    bny = by;
                    blueVisited[bny][bnx] = false;
                }

                if(bnx < 0 || bnx >= maze[0].length || bny < 0 || bny >= maze.length || blueVisited[bny][bnx] || maze[bny][bnx] == 5) continue;

                if(rnx == bnx && rny == bny) continue; // 겹치는 경우

                if(bnx == rx && bny == ry && rnx == bx && rny == by) continue; // 교환인 경우

                blueVisited[bny][bnx] = true;

                dfs(rnx, rny, bnx, bny, round + 1, maze, redVisited, blueVisited);
                blueVisited[bny][bnx] = false;

            }
            redVisited[rny][rnx] = false;

            if(maze[ry][rx] == 3) {
                break;
            }
        }
    }


    public static int[] getPoint(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) { // y
            for (int j = 0; j < arr[0].length; j++) { // x
                if(arr[i][j] == target) {
                    return new int[] {j, i}; // x, y
                }
            }
        }
        return null;
    }
}