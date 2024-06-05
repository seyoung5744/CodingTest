class Solution {
     public static int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n + 1][m + 1];

        for (int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = -1;
        }

        map[1][1] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if(i == 1 && j == 1) continue;
                if (map[i][j] != -1)
                    map[i][j] = Math.max(map[i - 1][j], 0) % 1_000_000_007+ Math.max(map[i][j - 1], 0) % 1_000_000_007;
            }
        }
        return map[n][m] % 1_000_000_007;
    }
}