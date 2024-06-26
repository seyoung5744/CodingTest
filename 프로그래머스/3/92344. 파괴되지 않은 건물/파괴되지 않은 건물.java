public class Solution {

    public static int solution(int[][] board, int[][] skills) {
        int[][] map = new int[board.length + 1][board[0].length + 1];

        for (int[] skill : skills) {
            int type = skill[0];
            int startI = skill[1];
            int startJ = skill[2];
            int endI = skill[3];
            int endJ = skill[4];
            int amount = skill[5];

            if (type == 1) {
                amount *= -1;
            }

            map[startI][startJ] += amount;
            map[startI][endJ + 1] -= amount;
            map[endI + 1][startJ] -= amount;
            map[endI + 1][endJ + 1] += amount;
        }

        for (int i = 0; i < map.length; ++i) {
            for (int j = 1; j < map[i].length; ++j) {
                map[i][j] += map[i][j - 1];
            }
        }

        for (int j = 0; j < map[0].length; ++j) {
            for (int i = 1; i < map.length; ++i) {
                map[i][j] += map[i - 1][j];
            }
        }


        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] + map[i][j] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }

}
