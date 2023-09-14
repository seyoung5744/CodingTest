public class Solution {

    public int[] solution(String s) {
        int[] answer = {};
        int zero = 0;
        int count = 0;

        while (!s.equals("1")) {
            int length = s.length();
            int removedZero = s.replace("0", "").length();
            zero += length - removedZero;
            s = Integer.toString(removedZero, 2);
            count += 1;
        }

        return new int[]{count, zero};
    }
}
