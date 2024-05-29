#include <string>
#include <vector>

using namespace std;

int answer = 0;

void dfs(int left, int right)
{
    if (left == 0 && right == 0)
    {
        ++answer;
    }

    if (left > 0)
        dfs(left - 1, right);
    
    if (left < right)
    {
        dfs(left, right - 1);
    }
}

int solution(int n) {
    dfs(n, n);
    return answer;
}
