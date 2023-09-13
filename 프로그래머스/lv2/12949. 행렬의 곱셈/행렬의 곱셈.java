
public class Solution {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int y = 0; y < arr1.length; y++) {
            for (int x = 0; x < arr2[0].length; x++) {
                for (int k = 0; k < arr1[y].length; k++) {
                    answer[y][x] += arr1[y][k] * arr2[k][x];
                }
            }
        }
        return answer;
    }

}