#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    
    int left = 0;
    int right = 0;
    
    int sum = left;
    while(right <= n)
    {
        if (sum <= n)
        {
            if (sum == n)
                ++answer;
            
            if (right >= n)
                break;
            
            sum += ++right;
        }
        else if (sum > n)
        {
            sum -= left;
            ++left;
        }
    }
    return answer;
}