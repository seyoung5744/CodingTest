#include <string>
#include <vector>
#include <cmath>
using namespace std;

int solution(vector<int> a) {
    if(a.size() == 1)
        return 1;
    
    int answer = 2;
    vector<int> leftMin (a.size(), 1000000001);
    vector<int> rightMin (a.size(), 1000000001);
    leftMin[0] = a[0];
    rightMin[a.size() - 1] = a.back(); 
        
    for(int i = 1; i < a.size(); ++i)
    {
        leftMin[i] = min(leftMin[i-1], a[i-1]);
        
        rightMin[rightMin.size() - 1 - i] = min(rightMin[rightMin.size() - i], a[rightMin.size() - i]);
    }
    
    for(int i = 1 ; i < a.size() - 1; ++i)
    {
        if (a[i] > leftMin[i] && a[i] > rightMin[i])
            continue;
        
        ++answer;
    }
    
    return answer;
}