#include <string>
#include <vector>
#include <map>
using namespace std;

long long solution(vector<int> weights) {
    long long answer = 0;
    map<int, long long> m;
    
    for(int i = 0; i < weights.size(); ++i)
    {
        m[weights[i]]++;
    }
    
    for(auto t : m)
    {
        int weight = t.first;
        long long count = t.second;
        answer += (count * (count - 1)) / 2;
        
        int targetWeight = weight * 3;
        
        if (targetWeight % 2 == 0)
        {
            if (m.find(targetWeight / 2) != m.end())
            {
                answer += count * m[targetWeight / 2];
            }
        }
        
        targetWeight = weight * 4;
        if (targetWeight % 2 == 0)
        {
            if (m.find(targetWeight / 2) != m.end())
            {
                answer += count * m[targetWeight/2];
            }
        }
        
        if (targetWeight % 3 == 0)
        {
            if (m.find(targetWeight / 3) != m.end())
            {
                answer += count * m[targetWeight/3];
            }
        }
    }
    
    return answer;
}