import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static Map<String, Integer> mapping = new HashMap<>();
    public static int[] parent;

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        parent = new int[enroll.length+1];
        mapping.put("-", enroll.length);
        for(int i = 0; i < enroll.length; ++i)
        {
            mapping.put(enroll[i], i);
        }

        for(int i = 0; i < referral.length; ++i)
        {
            parent[i] = mapping.get(referral[i]);
        }
        parent[mapping.get("-")] = mapping.get("-");


        for(int i = 0; i < seller.length; ++i) {
            String name = seller[i];
            int idx = mapping.get(name);
            int count = amount[i];
            int money = count * 100;
            while(parent[idx] != idx)
            {
                int div = (int)(money * 0.1);

                if (div < 1)
                    div = 0;

                answer[idx] += money - div;

                money = (int)div;

                idx = parent[idx];
            }
        }

        return answer;
    }

}
