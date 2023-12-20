#include <string>
#include <vector>
#include <map>
#include <set>
#include <algorithm>
#include <iostream>
using namespace std;

long long solution(vector<int> weights) {
    long long answer = 0;
    sort(weights.begin(), weights.end());
    
    map<int, long long> m;
    vector<int> s;
    
    for(int i = 0; i < weights.size(); ++i)
    {
        ++m[weights[i]];
        if (s.empty() || s.back() != weights[i])
            s.push_back(weights[i]);
    }
    
    for(int i = 0; i < s.size(); ++i)
    {
        int w1 = s[i];
        for(int j = i+1; j < s.size(); ++j)
        {
            int w2 = s[j];
            
            if (w1 * 4 < w2)
                break;
            
            if (w1 * 3 == w2 * 2 || w1 * 4 == w2 * 2 || w1 * 4 == w2 * 3)
            {
                answer += m[w1] * m[w2];
            }
        }
        
        answer += m[w1] * (m[w1] - 1) / 2;
    }
    
    return answer;
}