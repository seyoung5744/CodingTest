public class Solution {

    public static int[] solution(String s) {
        int[] answer = new int[]{0, 0};

        while (!s.equals("1")) {
            int beforeLength = s.length();
            s = s.replace("0", "");
            answer[1] += beforeLength - s.length();

            s = Integer.toString(s.length(), 2);
            answer[0]++;
        }
        return answer;
    }
}
