#include <string>
#include <vector>

using namespace std;

int answer = 0;

void dfs(int currentPoint, vector<vector<int>>& d, vector<bool> visited, int dCount)
{
    if (dCount > answer)
        answer = dCount;
    
    for(int i = 0; i < d.size(); ++i)
    {
        if (!visited[i] && d[i][0] <= currentPoint)
        {
            visited[i] = true;
            dfs(currentPoint - d[i][1], d, visited, dCount + 1);
            visited[i] = false;
        }
    }
}

int solution(int k, vector<vector<int>> dungeons) {
    
    dfs(k, dungeons, vector<bool> (dungeons.size(), false), 0);
    
    return answer;
}

