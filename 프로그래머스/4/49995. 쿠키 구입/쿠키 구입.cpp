#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> cookie) {
    int answer = 0;
    if (cookie.size() < 2)
        return 0;
    
    vector<int> sum (cookie.size(), 0);
    
    sum[0] = cookie[0];
    
    for(int i = 1; i < sum.size(); ++i)
    {
        sum[i] += sum[i-1] + cookie[i];
    }
    
    for(int m = 0; m < cookie.size() - 1; ++m)
    {
        int l = m;
        int r = m + 1;
        int rightSum = cookie[r];
        int leftSum = cookie[l];
        
        while(l >= 0 && r < cookie.size())
        {
            if (rightSum < leftSum)
            {
                if (r + 1 >= cookie.size())
                    break;
                rightSum += cookie[++r];
            }
            else
            {
                if (leftSum == rightSum)
                {
                    answer = max(answer, leftSum);
                }
                if (l - 1 < 0)
                {
                    break;
                }
                
                leftSum += cookie[--l];
            }
        }
    }
    
    return answer;
}