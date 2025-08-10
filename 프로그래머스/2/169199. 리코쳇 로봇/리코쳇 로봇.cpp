#include <string>
#include <vector>
#include <queue>
using namespace std;

vector<int> dx = {1, -1, 0, 0};
vector<int> dy = {0, 0, 1, -1};


struct Step
{
    int X;
    int Y;
    
    int StepCount;
    
    Step(int x, int y, int sc) : X(x), Y(y), StepCount(sc){};
};

pair<int, int> GetPoint(vector<string>& board, char target)
{
    for(int i = 0; i < board.size(); ++i)
    {
        for(int j = 0; j < board[i].size(); ++j)
        {
            if (board[i][j] == target)
                return {j, i};
        }
    }
    
    return {-1, -1};
}

int solution(vector<string> board) {
    int answer = 0;
    
    auto [StartX, StartY] = GetPoint(board, 'R');
    auto [EndX, EndY] = GetPoint(board, 'G');
    
    vector<vector<int>> visited(board.size(), vector<int>(board[0].size(), -1));
    visited[StartY][StartX] = 0;
    
    queue<Step*> q;
    q.push(new Step(StartX, StartY, 0));
    
    while(!q.empty())
    {
        Step* cur = q.front();
        q.pop();
        
        if (cur->X == EndX && cur->Y == EndY)
            break;
        
        for(int dir = 0; dir < 4; ++dir)
        {
            int nx = cur->X;
            int ny = cur->Y;
            
            while(nx + dx[dir] >= 0 && nx + dx[dir] < board[0].size() &&
                  ny + dy[dir] >= 0 && ny + dy[dir] < board.size() &&
                  board[ny + dy[dir]][nx + dx[dir]] != 'D')
            {
                nx = nx + dx[dir];
                ny = ny + dy[dir];
            }
            
            if (visited[ny][nx] == -1 || visited[ny][nx] > cur->StepCount + 1)
            {
                visited[ny][nx] = cur->StepCount + 1;
                q.push(new Step(nx, ny, cur->StepCount + 1));
            }
        }
    }
    
    
    return visited[EndY][EndX];
}