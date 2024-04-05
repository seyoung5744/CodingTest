#include <string>
#include <vector>
#include <set>
#include <iostream>
using namespace std;

int solution(vector<int> elements) {
    int answer = 0;
    set<int> record;
    
    for(int startIdx = 0; startIdx < elements.size(); ++startIdx)
    {
        int sum = 0;
        int idx = startIdx;
        int length = 0;
        while(length < elements.size())
        {
            sum += elements[idx % elements.size()];
            
            record.insert(sum);
            ++length;
            ++idx;
        }
    }
    
    answer = record.size();
    return answer;
}