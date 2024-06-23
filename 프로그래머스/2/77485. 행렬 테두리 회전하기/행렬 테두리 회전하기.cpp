#include <string>
#include <vector>

using namespace std;

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

vector<int> solution(int rows, int columns, vector<vector<int>> queries) {
    vector<int> answer;

    vector<vector<int>> maps(rows, vector<int>(columns, 1));

    int num = 1;
    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < columns; ++j){
            maps[i][j] = num++;
        }
    }

    for (int i = 0; i < queries.size(); ++i){
        int topLeftY = queries[i][0] - 1;
        int topLeftX = queries[i][1] - 1;
        int bottomY = queries[i][2] - 1;
        int bottomX = queries[i][3] - 1;

        int minimum = 1000001;

        int curDir = 0;

        int curX = topLeftX;
        int curY = topLeftY;
        int saved = maps[topLeftY][topLeftX];
        int temp;
        while (true){
            int nx = curX + dx[curDir];
            int ny = curY + dy[curDir];

            if (nx > bottomX || nx < topLeftX || ny > bottomY || ny < topLeftY) {
                ++curDir;
                continue;
            }

            temp = maps[ny][nx];
            maps[ny][nx] = saved;
            saved = temp;
            curX = nx;
            curY = ny;

            minimum = min(minimum, saved);

            if (curX == topLeftX && curY == topLeftY)
                break;
        }


        answer.push_back(minimum);
    }
    return answer;
}