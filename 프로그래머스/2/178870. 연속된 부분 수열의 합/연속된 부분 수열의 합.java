class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[1] = sequence.length;
        int left = 0;
        int right = 0;
        int sum = sequence[left];

        while(sequence[right] <= k)
        {
            if (sum < k)
            {
                right++;

                if (right >= sequence.length)
                    break;

                sum += sequence[right];
            }
            else if (sum >= k)
            {
                if (sum == k)
                {
                    if (right - left < answer[1] - answer[0])
                    {
                        answer[0] = left;
                        answer[1] = right;
                    }
                }
                sum -= sequence[left];
                ++left;
            }
        }
        
        return answer;
    }
}