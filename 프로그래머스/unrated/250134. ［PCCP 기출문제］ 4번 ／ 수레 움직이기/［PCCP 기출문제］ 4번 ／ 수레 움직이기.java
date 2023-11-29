class Solution {
    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }    
    public static int[] dx = {0, 0, 1, -1}; // 상, 하, 우, 좌
    public static int[] dy = {-1, 1, 0, 0};

    public static boolean[][] redVisited;
    public static boolean[][] blueVisited;

    public static int answer = Integer.MAX_VALUE;
    public static Point goalRed, goalBlue;
    
    public static int solution(int[][] maze) {

        redVisited = new boolean[maze.length][maze[0].length];
        blueVisited = new boolean[maze.length][maze[0].length];

        Point red = getPoint(maze, 1);
        Point blue = getPoint(maze, 2);
        
        goalRed = getPoint(maze, 3);
        goalBlue = getPoint(maze, 4);
        
        redVisited[red.y][red.x] = true;
        blueVisited[blue.y][blue.x] = true;
        dfs(red, blue,0, maze, redVisited, blueVisited);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    public static void dfs(Point red, Point blue, int round, int[][] maze, boolean[][] redVisited, boolean[][] blueVisited) {
        
        if(maze[red.y][red.x] == 3 && maze[blue.y][blue.x] == 4) {
            answer = Math.min(answer, round);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int rnx = dx[i] + red.x;
            int rny = dy[i] + red.y;

            if(maze[red.y][red.x] == 3) {
                rnx = red.x;
                rny = red.y;
                redVisited[rny][rnx] = false;
            }

            if(rnx < 0 || rnx >= maze[0].length || rny < 0 || rny >= maze.length || redVisited[rny][rnx] || maze[rny][rnx] == 5) continue;

            redVisited[rny][rnx] = true;
            for (int j = 0; j < 4; j++) {
                int bnx = dx[j] + blue.x;
                int bny = dy[j] + blue.y;

                if(maze[blue.y][blue.x] == 4) {
                    bnx = blue.x;
                    bny = blue.y;
                    blueVisited[bny][bnx] = false;
                }

                if(bnx < 0 || bnx >= maze[0].length || bny < 0 || bny >= maze.length || blueVisited[bny][bnx] || maze[bny][bnx] == 5) continue;

                if(rnx == bnx && rny == bny) continue; // 겹치는 경우

                if(bnx == red.x && bny == red.y && rnx == blue.x && rny == blue.y) continue; // 교환인 경우

                blueVisited[bny][bnx] = true;

                dfs(new Point(rnx, rny), new Point(bnx, bny), round + 1, maze, redVisited, blueVisited);
                blueVisited[bny][bnx] = false;

            }
            redVisited[rny][rnx] = false;

            if(maze[red.y][red.x] == 3) {
                break;
            }
        }
    }


    public static Point getPoint(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) { // y
            for (int j = 0; j < arr[0].length; j++) { // x
                if(arr[i][j] == target) {
                    return new Point(j, i); // x, y
                }
            }
        }
        return null;
    }
}