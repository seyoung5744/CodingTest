import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static class Step{
        String str;
        Step(String str)
        {
            this.str = str;
        }
    }

    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; ++i){
            String binaryStr = Long.toString(numbers[i], 2);
            Queue<Step> q = new LinkedList<>();
            int result = 1;

            int n = 0;
            while(binaryStr.length() > Math.pow(2, n) - 1) {
                n++;
            }

            while(binaryStr.length() < Math.pow(2, n) - 1)
            {
                binaryStr = "0" + binaryStr;
            }

            q.offer(new Step(binaryStr));

            while(!q.isEmpty())
            {
                Step s = q.poll();

                if (s.str.length() == 1)
                    break;

                int mid = s.str.length() / 2;

                String leftChild = s.str.substring(0, mid);
                String rightChild = s.str.substring(mid + 1);
                if (s.str.charAt(mid) == '1')
                {
                    q.add(new Step(leftChild));
                    q.add(new Step(rightChild));
                }
                else
                {
                    if (leftChild.contains("1") || rightChild.contains("1"))
                    {
                        result = 0;
                        break;
                    }
                }
            }

            answer[i] = result;
        }
        
        return answer;
    }
}
