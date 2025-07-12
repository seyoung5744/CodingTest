class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < food.length; i++) {
            String foodCount = Integer.toString(i).repeat(food[i] / 2);
            sb.append(foodCount);
        }
        return sb.toString() + "0" + sb.reverse().toString();
    }
}