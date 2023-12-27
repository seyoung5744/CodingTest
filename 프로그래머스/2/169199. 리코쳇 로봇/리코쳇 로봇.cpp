#include <string>
#include <vector>
#include <queue>
using namespace std;

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

struct Step
{
    int x;
    int y;
    
    Step(int x, int y) : x(x), y(y){}
};

int solution(vector<string> board) {
    int answer = 0;
    
    int startX, startY;
    int endX, endY;
    vector<vector<int>> visited (board.size(), vector<int>(board[0].length(), 10000000));
    
    for(int i = 0; i < board.size(); ++i)
    {
        for(int j = 0; j < board[i].length(); ++j)
        {
            if (board[i][j] == 'R')
            {
                startX = j;
                startY = i;
            }
            else if (board[i][j] == 'G')
            {
                endX = j;
                endY = i;
            }
        }
    }
    
    queue<Step*> q;
    q.push(new Step(startX, startY));
    visited[startY][startX] = 0;
    
    while(!q.empty())
    {
        Step* cur = q.front();
        q.pop();
        
        if(cur->x == endX && cur->y == endY)
        {
            break;
        }
        
        for(int i = 0; i < 4; ++i)
        {
            int nx = cur->x;
            int ny = cur->y;
            
            while(true)
            {
                if (nx + dx[i] < 0 || nx + dx[i] >= board[i].length() ||
                   ny + dy[i] < 0 || ny + dy[i] >= board.size())
                    break;
                
                if (board[ny + dy[i]][nx + dx[i]] == 'D')
                    break;
                
                nx += dx[i];
                ny += dy[i];
            }
            
            if(visited[ny][nx] <= visited[cur->y][cur->x] + 1)
                continue;
            
            visited[ny][nx] = visited[cur->y][cur->x] + 1;
            q.push(new Step(nx, ny));
        }
    }
    
    answer = visited[endY][endX];
    
    return answer == 10000000 ? -1 : answer;
}