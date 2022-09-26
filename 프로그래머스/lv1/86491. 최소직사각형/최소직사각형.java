class Solution {
    public int solution(int[][] sizes) {
        int maxRow = 0;
        int maxCol = 0;

        for (int[] size : sizes){
            if(size[0] < size[1]){
                int temp = size[1];
                size[1] = size[0];
                size[0] = temp;
            }
            if(size[0] > maxRow)
                maxRow = size[0];

            if(size[1] > maxCol)
                maxCol = size[1];
        }

        return maxRow*maxCol;
    }
}