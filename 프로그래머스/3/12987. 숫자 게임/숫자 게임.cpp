#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> A, vector<int> B) {
    int answer = 0;
    sort(A.rbegin(), A.rend());
    sort(B.rbegin(), B.rend());
    
    int start = 0;
    for(int i = 0; i < B.size(); ++i)
    {
        while(start < A.size())
        {
            if (A[start] >= B[i])
                ++start;
            else
                break;
        }
        
        if (start < A.size())
        {
            ++answer;
            ++start;
        }
    }
    
    return answer;
}