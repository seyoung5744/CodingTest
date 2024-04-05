#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    sort(citations.rbegin(), citations.rend());
    
    int max = citations.front();
    for (int i = max; i >= 0; --i)
    {
        
        bool flag = true;
        
        for(int j = 0; j < citations.size(); ++j)
        {
            if (citations[j] < i)
            {
                if (j >= i)
                    return i;
                else
                    break;
            }
            
            if (j == citations.size() - 1 && j+1 >= i)
                return i;
        }
    }
    
    
    return answer;
}