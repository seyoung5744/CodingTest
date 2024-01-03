public class Solution {

    public static int solution(String[] board) {
        int answer = -1;

        int oCount = 0;
        int xCount = 0;
        for(int i = 0; i < 3; ++i)
        {
            for(int j = 0; j < 3; ++j)
            {
                if (board[i].charAt(j) == 'O')
                {
                    ++oCount;
                }
                else if (board[i].charAt(j) == 'X')
                {
                    ++xCount;
                }
            }
        }
        
                
        if(oCount - xCount > 1)
            return 0;

        if (oCount == xCount) {
            if (check(board, 'O'))
                answer = 0;
            else
                answer = 1;
        } else if(oCount > xCount)
        {
            if (check(board,'X'))
                answer = 0;
            else
                answer = 1;
        }
        else
            answer = 0;

        return answer;

    }

    public static boolean check(String[] board, char ch)
    {
        for(int i = 0; i < 3; ++i)
        {
            boolean flag = true;
            boolean flag2 = true;

            for(int j = 0; j < 3; ++j)
            {
                if (board[i].charAt(j) != ch)
                {
                    flag = false;
                }

                if (board[j].charAt(i) != ch)
                {
                    flag2 = false;
                }
            }


            if (flag || flag2)
            {
                return true;
            }
        }

        if (board[0].charAt(0) == ch && 
            board[1].charAt(1) == ch && 
            board[2].charAt(2) == ch)
            return true;

        if (board[0].charAt(2) == ch && 
            board[1].charAt(1) == ch && 
            board[2].charAt(0) == ch)
            return true;

        return false;
    }
}
