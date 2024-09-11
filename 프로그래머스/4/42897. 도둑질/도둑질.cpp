#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> money) {
    int answer = 0;
    
    vector<int> dp1 (money.size()-1, 0);
    vector<int> dp2 (money.size(), 0);
    
    dp1[0] = money[0];
    dp1[1] = dp1[0];
    
    for(int i = 2; i < dp1.size(); ++i)
    {
        dp1[i] = max(dp1[i-2] + money[i], dp1[i-1]);
    }
    
    dp2[0] = 0;
    dp2[1] = money[1];
    
    for(int i = 2; i < money.size(); ++i)
    {
        dp2[i] = max(dp2[i - 2] + money[i], dp2[i-1]);
    }
    
    answer = max(dp1.back(), dp2.back());
    
    return answer;
}