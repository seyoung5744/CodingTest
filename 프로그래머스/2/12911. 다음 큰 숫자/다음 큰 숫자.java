class Solution {
    public int solution(int n) {
        String removedZeroN = Integer.toString(n, 2).replace("0", "");

        int next = n + 1;
        while (true) {
            String removedZeroNext = Integer.toString(next, 2).replace("0", "");
            if (removedZeroN.equals(removedZeroNext)) {
                return next;
            }
            next++;
        }
    }
}