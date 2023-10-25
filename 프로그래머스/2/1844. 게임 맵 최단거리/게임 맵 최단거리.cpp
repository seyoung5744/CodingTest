#include<vector>
#include<queue>

const int MAX = 100000;

using namespace std;

int solution(vector<vector<int> > maps)
{
    int row = maps.size();
    int col = maps[0].size();
    bool Done = false;

    vector<vector<int>> dist(row);
    for (int i = 0; i < row; i++) 
        for(int j = 0; j < col; j++)
            dist[i].push_back(MAX);

    queue<pair<int, int>> q;
    dist[0][0] = 1;
    q.push(make_pair(0, 0));

    int count = 0;
    while (!q.empty() && count < row * col) {
        int r = q.front().first;
        int c = q.front().second;
        q.pop();

        if (r == row - 1 && c == col - 1) {
            Done = true;
        }

        if (r < row-1 && maps[r+1][c] == 1) 
            if (dist[r+1][c] > dist[r][c] + 1) {
                dist[r+1][c] = dist[r][c] + 1;
                q.push(make_pair(r+1, c));
            }

        if (c < col-1 && maps[r][c+1] == 1)
            if (dist[r][c+1] > dist[r][c] + 1) {
                dist[r][c+1] = dist[r][c] + 1;
                q.push(make_pair(r, c+1));
            }

        if (r > 0 && maps[r-1][c] == 1)
            if (dist[r-1][c] > dist[r][c] + 1) {
                dist[r-1][c] = dist[r][c] + 1;
                q.push(make_pair(r-1, c));
            }

        if (c > 0 && maps[r][c-1] == 1) 
            if (dist[r][c-1] > dist[r][c] + 1) {
                dist[r][c-1] = dist[r][c] + 1;
                q.push(make_pair(r, c-1));
            }
        count++;
    }

    if (Done)
        return dist[row-1][col-1];
    return -1;
}