import java.util.Arrays;

class Solution {
    private static final int[][] mem = new int[501][501];

    public int solution(int[][] triangle) {
        
        for(int[] m : mem){
            Arrays.fill(m, -1);
        }
        return max(0, 0, triangle);
    }

    private static int max(int x, int y, int[][] triangle) {
        if(mem[y][x] != -1) return mem[y][x];
        if (y == triangle.length) {
            return 0;
        }

        return mem[y][x] = triangle[y][x] + Math.max(max(x, y + 1, triangle), max(x + 1, y + 1, triangle));
    }
}
