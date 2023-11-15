#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(vector<int> stones, int k) {
    int answer = 0;
    
    int left = 0;
    int right = 200000000;
    
    while(left <= right)
    {
        int mid = (left + right) / 2;
        int count  = 1;
        
        for(int i = 0; i < stones.size(); ++i)
        {
            if (stones[i] - mid < 0)
                ++count;
            else
                count = 1;
            
            if (count > k)
                break;
        }
    
        
        if (count > k)
        {
            right = mid-1;
        }
        else
        {
            left = mid + 1;
            answer = mid;
        }
    }
    
    return answer;
}