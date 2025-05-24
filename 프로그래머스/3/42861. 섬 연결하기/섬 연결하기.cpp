#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int find(vector<int>& parent, int node)
{
    if (parent[node] == node)
        return node;

    return parent[node] = find(parent, parent[node]);
}


void fUnion(vector<int>& parent, int node1, int node2)
{
    node1 = find(parent, node1);
    node2 = find(parent, node2);

    if (node1 == node2)
        return;

    if (node1 < node2)
    {
        parent[node2] = node1;
    }
    else
    {
        parent[node1] = node2;
    }


}

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;

    vector<int> parent(n);
    for (int i = 0; i < n; ++i)
    {
        parent[i] = i;
    }


    sort(costs.begin(), costs.end(), [](vector<int> a, vector<int> b) {
        return a[2] < b[2];
        });

    vector<bool> visited(n, false);

    for (int i = 0; i < costs.size(); ++i)
    {
        int node1 = costs[i][0];
        int node2 = costs[i][1];
        int cost = costs[i][2];

        if (find(parent, node1) == find(parent, node2)) continue;

        answer += cost;
        fUnion(parent, node1, node2);
    }

    return answer;
}
