#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    
    int total = brown + yellow;
    int row = 3;
    
    for(; row <= total/3; ++row)
    {
        if (total % row == 0 && (row - 2) * ((total/row) - 2) == yellow)
        {
            answer.push_back(row);
            answer.push_back(total / row);
            break;
        }
    }
    
    sort(answer.rbegin(), answer.rend());
    
    return answer;
}