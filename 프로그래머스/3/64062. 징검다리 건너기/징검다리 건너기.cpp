#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> stones, int k) {
    int answer = 0;
    
    int max = *max_element(stones.begin(), stones.end());
    int min = 1;
    
    while(min <= max)
    {
        int mid = (min + max) / 2;
        
        int count = 1;
        for(int i = 0; i < stones.size(); ++i)
        {
            if (stones[i] - mid < 0)
            {
                ++count;
            }
            else
            {
                count = 1;
            }
            
            if (count > k)
            {
                break;
            }
        }
        
        if (count > k)
        {
            max = mid -1;
        }
        else
        {
            answer = mid;
            min = mid + 1;
        }
    }
    
    
    return answer;
}