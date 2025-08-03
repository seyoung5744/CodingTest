#include <string>
#include <vector>

using namespace std;

int CountNode(int curNode, vector<vector<bool>>& graph, vector<bool>& visited)
{
    int nodeCount = 1;
    for(int i = 1; i < graph.size(); ++i)
    {
        if (graph[curNode][i] == false)
            continue;
        
        if (visited[i])
            continue;
        
        visited[i] = true;
        nodeCount += CountNode(i, graph, visited);
    }
    
    return nodeCount;
}

int solution(int n, vector<vector<int>> wires) {
    int answer = n;
    
    vector<vector<bool>> graph (n + 1, vector<bool>(n + 1, false));
    
    for(int i = 0; i < wires.size(); ++i)
    {
        int n1 = wires[i][0];
        int n2 = wires[i][1];
        
        graph[n1][n2] = true;
        graph[n2][n1] = true;
    }
    
    for(int i = 0; i < wires.size(); ++i)
    {
        int n1 = wires[i][0];
        int n2 = wires[i][1];
        
        graph[n1][n2] = false;
        graph[n2][n1] = false;
        
        vector<bool> visited (n+1, false);
        visited[n1] = true;
        int nodeCount = CountNode(n1, graph, visited);
        
        answer = min(answer, abs(n - nodeCount - nodeCount));
        
        graph[n1][n2] = true;
        graph[n2][n1] = true;
    }
    
    return answer;
}