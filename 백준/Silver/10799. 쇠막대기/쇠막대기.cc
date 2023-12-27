#include <iostream>
#include <stack>

using namespace std;

int main()
{
    int answer = 0;
    int st = 0;
    
    string stick;
    cin >> stick;
    
    for(int i = 0; i < stick.length(); ++i)
    {
        if (stick[i] == '(')
            ++st;
        else
        {
            --st;
            if (stick[i-1] == '(')
                answer += st;
            else
                ++answer;
        }
    }
    
    cout << answer << endl;
    
    return 0;
}