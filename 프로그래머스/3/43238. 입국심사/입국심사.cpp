#include <string>
#include <vector>
#include <algorithm>
using namespace std;

long long solution(int n, vector<int> times) {
    long long answer = 0;
    
    long long max = ((long long)n) * *max_element(times.begin(), times.end());
    
    long long min = 0;
    long long mid;
    
    while(min < max)
    {
        mid = (max + min) / 2;
        
        long long total = 0;
        for(int i = 0; i < times.size(); ++i)
        {
            total += mid / times[i];
        }
        
        if (total >= n)
        {
            max = mid;
            answer = mid;
        }
        else
        {
            min = mid+1;
        }
    }
    
    
    return answer;
}