#include <string>
#include <vector>
#include <queue>
#include <numeric>
using namespace std;

int solution(vector<int> queue1, vector<int> queue2) {
    int answer = 0;
   
    queue<int> q1, q2;
    
    long long sum1 = 0;
    long long sum2 = 0;
    
    for(int i = 0; i < queue1.size(); ++i)
    {
        q1.push(queue1[i]);
        sum1 += (long long)queue1[i];
        q2.push(queue2[i]);
        sum2 += (long long)queue2[i];
    }
    
    while(sum1 != sum2)
    {
        if (sum1 > sum2)
        {
            sum2 += (long long)q1.front();
            q2.push(q1.front());
            sum1 -= (long long)q1.front();
            q1.pop();
                    
        }
        else
        {
            sum1 += q2.front();
            q1.push(q2.front());
            sum2 -= q2.front();
            q2.pop();
        }
                    
        ++answer;
        
        if (answer > queue1.size() * 5)
            return -1;
    }
    
    
    return answer;
}