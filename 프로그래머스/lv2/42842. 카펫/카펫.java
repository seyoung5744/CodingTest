class Solution {
     private static final int MAX_WIDTH = 5000;

    public int[] solution(int brown, int yellow) {
        for (int width = 3; width <= MAX_WIDTH; width++) {
            for (int height = 3; height <= width; height++) {
                int boundary = (width + height - 2) * 2;
                int center = (width * height) - boundary;
                if(boundary == brown && center == yellow){
                    return new int[]{width, height};
                }
            }
        }

        return null;
    }
}