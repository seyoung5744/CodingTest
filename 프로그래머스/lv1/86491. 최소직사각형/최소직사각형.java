class Solution {
    public int solution(int[][] sizes) {
        int maxRow = 0;
        int maxCol = 0;

        for (int[] size : sizes){
            maxRow = Math.max(maxRow, Math.max(size[0], size[1]));
            maxCol = Math.max(maxCol, Math.min(size[0], size[1]));
        }

        return maxRow*maxCol;
    }
}