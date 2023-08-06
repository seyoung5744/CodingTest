import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (int in : ingredient) {
            list.add(in);

            if (list.size() >= 4) {
                int curSize = list.size();
                if (list.get(curSize - 1) == 1 &&
                    list.get(curSize - 2) == 3 &&
                    list.get(curSize - 3) == 2 &&
                    list.get(curSize - 4) == 1) {

                    answer += 1;
                    list.remove(curSize - 1);
                    list.remove(curSize - 2);
                    list.remove(curSize - 3);
                    list.remove(curSize - 4);
                }
            }

        }

        return answer;
    }
}