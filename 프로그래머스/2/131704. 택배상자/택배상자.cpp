#include <string>
#include <vector>
#include <stack>
using namespace std;

int solution(vector<int> order) {
    int answer = 0;
    vector<int> mainBelt (order.size());
    for(int i = 0; i < order.size(); ++i)
    {
        mainBelt[order[i]-1] = i;
    }
    
    stack<int> subBelt;
    
    int target = 0;
    for(int i = 0; i < mainBelt.size(); ++i)
    {
        subBelt.push(mainBelt[i]);
        
        while(!subBelt.empty() && subBelt.top() == target)
        {
            subBelt.pop();
            ++target;
            ++answer;
        }
    }
    
    
    return answer;
}