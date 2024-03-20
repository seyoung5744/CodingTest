import java.util.Arrays;

public class Solution {

    public static int solution(int[] a) {
        int answer = 0;

        int[] cnt = new int[a.length];

        for (int num : a) {
            cnt[num]++;
        }


        for (int i = 0; i < cnt.length; i++) {

            if(cnt[i] <= answer / 2)
                continue;

            int r = 0;
            int end = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[j] == i) {
                    if (j - 1 >= 0)
                    {
                        if (j-1 >= end && a[j-1] != a[j])
                        {
                            end = j + 1;
                            r += 2;
                            continue;
                        }
                    }

                    if (j + 1 < a.length)
                    {
                        if (j + 1 < a.length && a[j] != a[j+1])
                        {
                            r += 2;
                            end = j + 2;
                            continue;
                        }
                    }
                }
            }

            answer = Math.max(answer, r);
        }

        return answer;
    }
}
