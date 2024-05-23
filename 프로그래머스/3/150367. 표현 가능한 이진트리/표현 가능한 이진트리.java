import java.util.*;

public class Solution {

    public static class Step {

        public String str;

        public Step(String str) {
            this.str = str;
        }
    }


    public static int r ;
    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; ++i) {
            String binaryStr = Long.toString(numbers[i], 2);

            int n = 0;
            while (binaryStr.length() > Math.pow(2, n) - 1) {
                n++;
            }

            while (binaryStr.length() < Math.pow(2, n) - 1) {
                binaryStr = "0" + binaryStr;
            }


            r = 1;

            isBinaryTree(binaryStr, 0, binaryStr.length());

            answer[i] = r;
        }
        return answer;
    }

    public static char isBinaryTree(String s, int start, int end) { // end는 포함X
        int mid = (end + start) / 2;

        if (end - start == 1) { // 노드가 1개일 때까지

            return s.charAt(start);
        }

        char left = isBinaryTree(s, start, mid);
        char right = isBinaryTree(s, mid + 1, end);

        if (s.charAt(mid) == '0') {
            if (left == '1' || right == '1')
                r = 0;
        }

        return s.charAt(mid);
        // 부모 검사

    }

}
