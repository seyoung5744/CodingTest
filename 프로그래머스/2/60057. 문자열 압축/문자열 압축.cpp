#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = s.length();
    int maxLength = s.length() / 2;

    for (int length = 1; length <= maxLength; ++length)
    {
        string str = s;
        string result = "";
        string last = "";
        int count = 0;
        for (int i = 0; i < s.length(); i += length)
        {
            string cut = str.substr(i, length);

            if (last == cut)
            {
                ++count;
            }
            else
            {

                if (count > 1)
                    result += to_string(count) + last;
                else if (count == 1)
                    result += last;

                last = cut;
                count = 1;
            }
        }

        if (count > 1)
            result += to_string(count) + last;
        else if (count == 1)
            result += last;

        if (result.length() < answer)
        {
            answer = result.length();
        }
    }

    return answer;
}