#include <string>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

int solution(vector<vector<int>> targets) {
    int answer = 0;
    
    sort(targets.begin(), targets.end(), [](vector<int> a, vector<int> b){
        if (a[0] == b[0])
            return a[1] < b[1];
        
        return a[0] < b[0];
    });
    
    int start = -1;
    int end = -1;
    for(int i = 0; i < targets.size(); ++i)
    {
        if (targets[i][0] >= end)
        {
            start = targets[i][0];
            end = targets[i][1];
            ++answer;
            continue;
        }
        else
        {
            end = min(targets[i][1], end);
        }
    }
    
    return answer;
}