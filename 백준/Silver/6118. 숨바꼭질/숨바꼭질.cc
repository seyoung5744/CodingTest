#include <iostream>
#include <queue>

using namespace std;

int main(void)
{
    int N, M;

    cin >> N >> M;

    vector<int> visited(N + 1, M + 1);
    vector<vector<int>> graph(N + 1, vector<int>());
    for (int i = 0; i < M; ++i)
    {
        int node1;
        int node2;

        cin >> node1 >> node2;

        graph[node1].push_back(node2);
        graph[node2].push_back(node1);
    }

    int minIdx = 1;
    int maxDis = 0;
    int nCount = 0;

    queue<int> q;
    q.push(1);
    visited[1] = 0;

    while (!q.empty())
    {
        int cur = q.front();
        q.pop();

        if (visited[cur] > maxDis)
        {
            maxDis = visited[cur];
            minIdx = cur;
            nCount = 1;
        }
        else if (visited[cur] == maxDis)
        {
            ++nCount;
            minIdx = min(minIdx, cur);
        }

        for (int i = 0; i < graph[cur].size(); ++i)
        {
            int next = graph[cur][i];

            if (visited[cur] + 1 >= visited[next])
                continue;

            visited[next] = visited[cur] + 1;
            q.push(next);
        }
    }

    cout << minIdx << " " << maxDis << " " << nCount << endl;

    return 0;
}