import java.util.*;

public class Solution {

    public static List<List<Character>> board = new ArrayList<>();
    public static List<List<Boolean>> isDeleted = new ArrayList<>();

    public static int solution(int m, int n, String[] strBoard) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            board.add(new ArrayList<>());
            isDeleted.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                board.get(i).add(strBoard[j].charAt(i));
                isDeleted.get(i).add(false);
            }
        }

        while(check()) {
            answer += delete();
        }

        return answer;
    }

    public static int delete() {
        int result = 0;

        for (int i = 0; i < isDeleted.size(); i++) {
            for (int j = 0; j < isDeleted.get(i).size(); j++) {
                Boolean cur = isDeleted.get(i).get(j);
                if(cur) {
                    board.get(i).remove(j);
                    isDeleted.get(i).remove(j);
                    result++;
                    --j;
                }
            }
        }
        return result;
    }

    public static boolean check() {
        boolean flag = false;

        for (int i = 0; i < board.size() - 1; i++) {
            for (int j = 0; j < board.get(i).size() - 1; j++) {
                char cur = board.get(i).get(j);
                int count = 0;

                for(int k = j; k < board.get(i+1).size() && k < j + 2; ++k)
                {
                    if (cur == board.get(i+1).get(k))
                        ++count;
                }
                if (cur == board.get(i).get(j + 1) && count == 2) {
                    isDeleted.get(i).set(j, true);
                    isDeleted.get(i).set(j + 1, true);
                    isDeleted.get(i + 1).set(j, true);
                    isDeleted.get(i + 1).set(j + 1, true);
                    flag = true;
                }
            }
        }
        return flag;
    }

}
