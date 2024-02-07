public class Solution {

    public static int[][] skillSum;

    public static int solution(int[][] board, int[][] skills) {
        int answer = 0;
        skillSum = new int[board.length + 1][board[0].length + 1];

        for (int[] skill : skills) {
            int motion = skill[0];
            int startY = skill[1];
            int startX = skill[2];

            int endY = skill[3];
            int endX = skill[4];
            int damage = skill[5];

            if (motion == 2) {
                damage *= -1;
            }

            skillSum[startY][startX] += damage;
            skillSum[startY][endX + 1] -= damage;
            skillSum[endY + 1][startX] -= damage;
            skillSum[endY + 1][endX + 1] += damage;
        }

        for (int i = 0; i < skillSum.length; i++) {
            for (int j = 1; j < skillSum[0].length; j++) {
                skillSum[i][j] += skillSum[i][j - 1];
            }
        }

        for (int i = 0; i < skillSum[0].length; i++) {
            for (int j = 1; j < skillSum.length; j++) {
                skillSum[j][i] += skillSum[j - 1][i];
            }
        }

       
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(skillSum[i][j] < board[i][j])
                    ++answer;
            }
        }
        return answer;
    }

}
