#include <string>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    map<string, int> m;
    for(int i = 0; i < clothes.size(); ++i)
    {
        ++m[clothes[i][1]];
    }
    
    for(auto count : m)
    {
        answer *= (count.second + 1);
    }
    
    answer -= 1;
    
    return answer;
}