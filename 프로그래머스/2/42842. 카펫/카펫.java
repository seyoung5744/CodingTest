class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        for (int weight = 3; weight < 5000; weight++) {
            for (int height = 3; height <= weight; height++) {
                int boundary = 2 * (height + weight - 2);
                int center = (weight * height) - boundary;

                if (brown == boundary && yellow == center) {
                    return new int[]{weight, height};
                }
            }
        }

        return answer;
    }
}