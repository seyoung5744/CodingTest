#include <string>
#include <vector>

using namespace std;

pair<int, int> GetIndex(int n, long long idx)
{
    return make_pair(idx / n, idx % n);
}

vector<int> solution(int n, long long left, long long right) {
    vector<int> answer;
    
    for(long long i = left; i <= right; ++i)
    {
        pair<int, int> pos = GetIndex(n, i);
        
        int num;
        if (pos.second > pos.first)
        {
            num = pos.second + 1;
        }
        else
        {
            num = pos.first + 1;
        }
        
        answer.emplace_back(num);
    }
    
    return answer;
}