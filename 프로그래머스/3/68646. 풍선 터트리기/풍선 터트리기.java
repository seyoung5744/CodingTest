class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        leftMin[0] = a[0];
        rightMin[a.length - 1] = a[a.length - 1];

        for (int i = 1; i < a.length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i - 1]);
            rightMin[a.length - 1 - i] = Math.min(rightMin[a.length - i], a[a.length - i]);
        }

        for (int i = 0; i < a.length; i++) {
            if(a[i] > leftMin[i] && a[i] > rightMin[i]) continue;

            answer++;
        }

        return answer;
    }
}