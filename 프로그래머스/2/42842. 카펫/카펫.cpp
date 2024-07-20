#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    
    int total = brown + yellow;
    
    for(int row = 3; row <= total/3; ++row) {
        int col = total / row;
        if (col * row == total && (row - 2) * (col - 2) == yellow) {
            answer.push_back(row);
            answer.push_back(col);
            break;
        }
    }
    
    sort(answer.rbegin(), answer.rend());
    
    return answer;
}