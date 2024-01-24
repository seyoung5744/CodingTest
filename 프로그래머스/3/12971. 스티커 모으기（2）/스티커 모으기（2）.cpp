#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int solution(vector<int> sticker)
{
    
    if (sticker.size() == 1)
    {
        return sticker[0];
    }
    else if (sticker.size() == 2)
    {
        return max(sticker[0], sticker[1]);
    }
        
    int answer = 0;
    vector<int> dp1 (sticker.size(), 0);
    vector<int> dp2 (sticker.size(), 0);
    
    dp1[0] = sticker[0];
    dp1[1] = max(sticker[0], sticker[1]);
    dp2[1] = sticker[1];
    dp2[2] = max(sticker[1], sticker[2]);
    for(int i = 2; i < sticker.size() - 1; ++i)
    {
        dp1[i] = max(dp1[i-1], dp1[i - 2] + sticker[i]);
    }
    dp1.pop_back();
    
    for(int i = 3; i < sticker.size(); ++i)
    {
        dp2[i] = max(dp2[i-1], dp2[i - 2] + sticker[i]);
    }
    
    answer = max(dp1.back(), dp2.back());

    return answer;
}