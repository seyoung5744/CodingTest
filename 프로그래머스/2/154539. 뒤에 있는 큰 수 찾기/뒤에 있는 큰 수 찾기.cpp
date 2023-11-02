#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer(numbers.size());
    vector<int> parent (numbers.size(), -1);
    answer[numbers.size() - 1] = -1;
    
    
    for(int i = numbers.size() - 2; i >= 0; --i)
    {
        if (numbers[i] < numbers[i + 1])
        {
            answer[i] = numbers[i+1];
            parent[i] = i + 1;
        }
        else if (numbers[i] == numbers[i + 1])
        {
            answer[i] = answer[i+1];
            parent[i] = parent[i+1];
        }
        else
        {
            int p = parent[i+1];
            answer[i] = -1;
            
            while(p != -1)
            {
                if (numbers[p] > numbers[i])
                {
                    answer[i] = numbers[p];
                    parent[i] = p;
                    break;
                }
                p = parent[p];
            }
        }
    }
    
    return answer;
}