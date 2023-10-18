#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> sequence, int k) {
    vector<int> answer(2);
    
    int min = 1000001;
    
    int left = 0;
    int right = 0;
    int sum = sequence[0];
    
    while(right < sequence.size() || left < right)
    {
        if (sum < k)
        {
            if (right + 1 >= sequence.size())
                break;
            
            sum += sequence[++right];
        }
        else if(sum == k)
        {
            if (right - left < min)
            {
                answer[0] = left;
                answer[1] = right;
                min = right - left;
            }
            sum -= sequence[left];
            ++left;
        }
        else
        {
            sum -= sequence[left];
            ++left;
        }
    }
    
    return answer;
}