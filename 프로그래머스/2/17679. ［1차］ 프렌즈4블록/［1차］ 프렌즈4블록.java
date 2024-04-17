import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static int[] dx = {1, 0, 1}; // 우, 하, 아래대각선
    public static int[] dy = {0, 1, 1};

    public static List<List<Block>> maps = new ArrayList<>();

    static class Block {

        public char ch;
        public boolean isDeleted;

        public Block(char ch) {
            this.ch = ch;
        }

        @Override
        public String toString() {
            return ch + " ";
        }
    }

    public static int solution(int m, int n, String[] board) {

        for (int i = 0; i < n; i++) {
            maps.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                maps.get(i).add(new Block(board[j].charAt(i)));
            }
        }
        int answer = 0;
        while (check()) {
            answer += count();
        }
        return answer;
    }

    public static int count() {
        int count = 0;
        for (int i = 0; i < maps.size(); i++) {
            for (int j = 0; j < maps.get(0).size(); j++) {
                if(maps.get(i).get(j).ch == '*')
                    break;

                if (maps.get(i).get(j).isDeleted) {
                    count++;

                    Block block = maps.get(i).get(j);
                    maps.get(i).remove(block);
                    block.ch = '*';
                    maps.get(i).add(block);
                    --j;
                }
            }
        }

        return count;
    }

    public static boolean check() {

        boolean flag = false;
        for (int i = 0; i < maps.size() - 1; i++) {
            for (int j = 0; j < maps.get(0).size() - 1; j++) {

                char start = maps.get(i).get(j).ch;

                if(start == '*')
                    continue;

                if (start == maps.get(i).get(j + 1).ch && start == maps.get(i + 1).get(j).ch && start == maps.get(i + 1).get(j + 1).ch) {
                    maps.get(i).get(j).isDeleted = true;
                    maps.get(i).get(j + 1).isDeleted = true;
                    maps.get(i + 1).get(j).isDeleted = true;
                    maps.get(i + 1).get(j + 1).isDeleted = true;
                    flag = true;
                }
            }
        }
        return flag;
    }

}
