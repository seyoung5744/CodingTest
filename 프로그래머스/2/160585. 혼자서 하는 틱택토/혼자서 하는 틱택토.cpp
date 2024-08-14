#include <string>
#include <vector>

using namespace std;

int Count(const vector<string>& board, const char& target)
{
    int count = 0;
    
    for(int i = 0; i < board.size(); ++i)
    {
        for(int j = 0; j < board.size(); ++j)
        {
            if (board[i][j] == target)
            {
                ++count;
            }
        }
    }
    
    return count;
}

bool CheckIsEnd(const vector<string>& board, const char& target)
{
    for(int i = 0; i < board.size(); ++i)
    {
        if (board[i][0] == target)
        {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2])
                return true;
        }

        if (board[0][i] == target)
        {
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i])
                return true;
        }
    }
    
    if (board[0][0] == target && board[0][0] == board[1][1] && board[0][0] == board[2][2])
        return true;
    
    if (board[0][2] == target && board[0][2] == board[1][1] && board[0][2] == board[2][0])
        return true;
    
    return false;
}

int solution(vector<string> board) {
    int answer = -1;
    
    int OCount = Count(board, 'O');
    int XCount = Count(board, 'X');
    
    if (XCount > OCount || OCount - XCount > 1)
    {
        return 0;
    }
    
    if (OCount == XCount)
    {
        if (CheckIsEnd(board, 'O') == true)
            return 0;
        return 1;
    }
    
    if (OCount - XCount == 1)
    {
        if (CheckIsEnd(board, 'X') == true)
            return 0;
        
        return 1;
    }
    
    return 11234123;
}