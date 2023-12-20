#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, long long k) {
    vector<int> nums;
    vector<int> answer;
    long long count = 1;
    for(int i = 1; i <= n; ++i)
    {
        nums.push_back(i);
        count *= i;
    }
    count /= n;
    --n;
    --k;
    while(true)
    {
        long long target = (k / count);
        answer.push_back(nums[target]);
        nums.erase(nums.begin() + target);
        k = k % count;
        
        if (n < 1)
            break;
        
        count /= n--; 
    }
    
    return answer;
}