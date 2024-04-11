class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m + 1][n + 1];

        for (int[] puddle : puddles) {
            map[puddle[0]][puddle[1]] = -1;
        }
        map[1][1] = 1;  

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == 1 && j == 1 ) continue;
                map[i][j] = (map[i][j] == -1) ? 0 : (map[i-1][j] + map[i][j-1])%1_000_000_007;
            }
        }

        return map[m][n];
    }
}