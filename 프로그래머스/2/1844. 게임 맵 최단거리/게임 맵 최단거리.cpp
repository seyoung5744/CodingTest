#include <vector>
#include <queue>

using namespace std;

#define INF 100001

struct Step
{
    int x;
    int y;
    int moveCount;
    
    Step(int x, int y, int mc) : x(x), y(y), moveCount(mc){}
};


int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

int solution(vector<vector<int> > maps)
{
    int answer = -1;
    int endX = maps[0].size()-1;
    int endY = maps.size()-1;
    int maxX = maps[0].size();
    int maxY = maps.size();
    
    //vector<vector<int>> visited (maps.size(), vector<int> (maps[1].size(), INF));
    
    queue<Step*> q;
    q.push(new Step(0, 0, 1));
    maps[0][0] = 0;
    
    while(!q.empty())
    {
        Step* cur = q.front();
        q.pop();
        
        for(int i = 0; i < 4; ++i)
        {
            int newX = cur->x + dx[i];
            int newY = cur->y + dy[i];
            
            if (newX >= 0 && newX < maxX && newY >= 0 && newY < maxY)
            {
                if (maps[newY][newX] != 0)
                {   
                    if (newY == endY && newX == endX)
                        return cur->moveCount + 1;
                    maps[newY][newX] = 0;
                    
                    q.push(new Step(newX, newY, cur->moveCount + 1));
                    
                }
            }
        }
    }
    
    
    return answer;
}