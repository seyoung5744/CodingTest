import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
       int answer = 0;
        Stack<Integer> basket = new Stack<>();
        basket.push(0);
        Stack<Integer>[] boxs = new Stack[board.length];

        for (int i = 0; i < board.length; i++) {
            boxs[i] = new Stack<>();
            for (int j = 0; j < board[0].length; j++) {
                if(board[board[0].length-j-1][i] != 0)
                    boxs[i].push(board[board[0].length-j-1][i]);
            }
        }
        
        int moveItem;
        for(int move : moves){
            if(!boxs[move-1].isEmpty()) {
                moveItem = boxs[move - 1].pop();
                if ((basket.peek() != moveItem)) {
                    basket.push(moveItem);
                } else {
                    basket.pop();
                    answer++;
                }
            }

        }

        return answer*2;
    }
}