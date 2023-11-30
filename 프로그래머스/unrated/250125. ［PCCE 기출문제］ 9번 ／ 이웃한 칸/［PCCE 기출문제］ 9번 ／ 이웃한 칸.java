class Solution {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];
        
        for(int i = 0; i < 4; i++) {
            int nx = dx[i] + w;
            int ny = dy[i] + h;
            
            if(nx < 0 || nx >= board[0].length || ny < 0 || ny >= board.length) continue;
            
            if(board[ny][nx].equals(color)) answer += 1;
        }
        return answer;
    }
}