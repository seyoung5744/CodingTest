#include <string>
#include <vector>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <map>
#include <queue>
using namespace std;

struct Tile
{
    char c;
    bool isDeleted;

    Tile(char c, bool id) : c(c) , isDeleted(id) {};
};

int solution(int m, int n, vector<string> board) {
    int answer = 0;

    vector<vector<Tile*>> b(n, vector<Tile*>(m));

    for (int i = 0; i < n; ++i)
    {
        for (int j = m-1; j >= 0; --j)
        {
            b[i][m - 1 - j] = new Tile(board[j][i], false);
        }
    }

    while (true)
    {
        int beforeAnswer = answer;
        for (int i = 0; i < n -1; ++i)
        {
            for (int j = 0; j < m - 1; ++j)
            {
                if (b[i][j] == nullptr || b[i][j + 1] == nullptr ||
                    b[i + 1][j] == nullptr || b[i + 1][j + 1] == nullptr)
                    continue;

                if (b[i][j]->c == b[i][j + 1]->c && b[i][j]->c == b[i + 1][j]->c &&
                    b[i][j]->c == b[i + 1][j + 1]->c)
                {
                    b[i][j]->isDeleted = true;
                    b[i][j+1]->isDeleted = true;
                    b[i+1][j]->isDeleted = true;
                    b[i+1][j+1]->isDeleted = true;
                }
            }
        }

        for (int i = 0; i < n; ++i)
        {
            int dCount = 0;
            for (int j = 0; j < m; ++j)
            {
                if (b[i][j] == nullptr)
                    break;

                if (b[i][j]->isDeleted)
                {
                    dCount += 1;
                    b[i][j] = nullptr;
                }
                else
                {
                    swap(b[i][j], b[i][j - dCount]);
                }
            }

            answer += dCount;
        }

        if (answer == beforeAnswer)
            break;
    }

    return answer;
}