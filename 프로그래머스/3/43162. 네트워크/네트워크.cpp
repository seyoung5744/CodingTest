#include <string>
#include <vector>

using namespace std;

vector<bool> visited;

void dfs(vector<vector<int>>& computers, int current)
{
    for(int i = 0; i < visited.size(); ++i)
    {
        if (i == current || computers[current][i] == 0 || visited[i])
            continue;
        
        visited[i] = true;
        
        dfs(computers, i);
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    
    visited = vector<bool> (n, false);
    
    for(int i = 0; i < n; ++i)
    {
        if (visited[i])
            continue;
        
        visited[i] = true;
        dfs(computers, i);
        ++answer;
    }
    
    return answer;
}