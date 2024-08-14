#include <string>
#include <vector>

using namespace std;

int answer = 0;

bool check(vector<int> m, int depth)
{
    for (int i = 0; i < depth; ++i)
    {
        if (m[i] == m[depth])
            return false;

        if (abs(m[i] - m[depth]) == abs(i - depth))
            return false;
    }

    return true;
}

void dfs(vector<int> m, int depth, int n)
{
    if (depth >= n)
    {
        ++answer;
        return;
    }

    for (int i = 0; i < n; ++i)
    {
        m[depth] = i;

        if (check(m, depth) == true)
        {
            dfs(m, depth + 1, n);
        }
    }
}


int solution(int n) {

    dfs(vector<int>(n), 0, n);

    return answer;
}