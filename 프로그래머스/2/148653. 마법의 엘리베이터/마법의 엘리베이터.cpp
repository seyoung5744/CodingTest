#include <string>
#include <vector>
#include <cmath>
#include <iostream>
using namespace std;

int answer = 100000000;

void dfs(vector<int> num, int idx, int count, bool isUpper)
{
    if (idx >= num.size())
    {
        if (isUpper)
            count++;
        
        answer = min(answer, count);
        return;
    }
    
    if (isUpper)
    {
        num[idx]+=1;
    }
    
    dfs(num, idx + 1, count + num[idx], false);
    dfs(num, idx + 1, count + 10 - num[idx], true);
    
}

int solution(int storey) {
    vector<int> nums;
    
    while(storey > 0)
    {
        nums.push_back(storey % 10);
        storey /= 10;
    }

    
    dfs(nums, 0, 0, false);
    
    return answer;
}