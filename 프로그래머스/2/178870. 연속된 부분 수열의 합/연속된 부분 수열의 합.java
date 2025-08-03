class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[1] = 1_000_001;

        int left = 0;
        int right = 0;
        int sum = 0;

        while (right < sequence.length) {

            sum += sequence[right];

            while (left <= right && sum >= k) {
                
                if(sum == k) {
                    int len = right - left;
                    if (len < answer[1] - answer[0]) {
                        answer[0] = left;
                        answer[1] = right;
                    }
                }
                sum -= sequence[left++];
            }

            right++;
        }

        
        return answer;
    }
}