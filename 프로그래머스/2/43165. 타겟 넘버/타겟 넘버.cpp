#include <string>
#include <vector>

using namespace std;

int answer = 0;

void dfs(vector<int>& numbers, int target, int curSum, int curIdx)
{
    if (curIdx == numbers.size())
    {
        if (target == curSum)
            ++answer;
        return;
    }
    
    dfs(numbers, target, curSum + numbers[curIdx], curIdx + 1);
    dfs(numbers, target, curSum - numbers[curIdx], curIdx + 1);
}
int solution(vector<int> numbers, int target) {
    
    dfs(numbers, target, 0, 0);
    
    return answer;
}