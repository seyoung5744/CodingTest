#include<vector>
#include <queue>
using namespace std;

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

int solution(vector<vector<int> > maps){
    int answer = 0;
    int endY = maps.size() - 1;
    int endX = maps[0].size() - 1;
    
    vector<vector<int>> visited (maps.size(), vector<int> (maps[0].size(), 1000001));
    queue<pair<int, int>> q;
    q.push({0, 0});
    visited[0][0] = 1;
    
    while(!q.empty()){
        auto& [curX, curY] = q.front();
        q.pop();
        
        if (curX == endX && curY == endY)
            break;
        
        for(int i = 0; i < 4; ++i){
            int nx = curX + dx[i];
            int ny = curY + dy[i];
            
            if (nx < 0 || nx > endX || ny < 0 || ny > endY || maps[ny][nx] == 0)
                continue;
            
            if (visited[ny][nx] <= visited[curY][curX] + 1)
                continue;
            
            visited[ny][nx] = visited[curY][curX] + 1;
            q.push({nx, ny});
        }
    }
    
    return visited[endY][endX] == 1000001 ? -1 : visited[endY][endX];
}