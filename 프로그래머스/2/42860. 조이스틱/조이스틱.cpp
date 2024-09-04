#include <string>
#include <vector>

using namespace std;



int GetCount(char ch)
{
    return min(ch  - 65, abs(ch - 91));
}

int solution(string name) {
    int answer = 100000000;

    int result = 0;
    
    vector<int> count(name.length(), 0);
    

    for (int i = 0; i < name.length(); ++i)
    {
        result += GetCount(name[i]);
    }

    if(result == 0)
        return 0;
    
    answer = result + name.length() - 1;

    for (int i = 0; i < name.length(); ++i)
    {
        if (name[i] == 'A')
        {
            int end = i;

            while (end < name.length() && name[end] == 'A')
            {
                ++end;
            }

            answer = min(answer, max((i - 1), 0) * 2 + (int)name.length() - end + result);
            answer = min(answer, ((int)name.length() - end) * 2 + (max(0, i - 1) + result));
            i = end - 1;
        }
    }


    return answer;
}