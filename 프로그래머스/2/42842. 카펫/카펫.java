class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        for (int width = 3; width < 5000; width++) {
            for (int height = 3; height <= width; height++) {
                if ((2 * (width + height - 2) == brown && ((height - 2) * (width - 2)) == yellow)) {
                    return new int[]{width, height};
                }
            }
        }
        return new int[]{-1, -1};
    }
}