#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> A, vector<int> B) {
    int answer = 0;
    sort(A.rbegin(), A.rend());
    sort(B.rbegin(), B.rend());
    
    int Aidx = 0;
    int Bidx = 0;
    
    while(Aidx < A.size())
    {
        if (B[Bidx] > A[Aidx])
        {
            ++answer;
            ++Bidx;
        }
       
        ++Aidx;
    }
    
    return answer;
}