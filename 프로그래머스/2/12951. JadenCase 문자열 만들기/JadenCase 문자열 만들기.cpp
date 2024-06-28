#include <string>
#include <vector>
#include <cctype>
using namespace std;

string solution(string s) {
    string answer = "";
    bool bIsFirst = true;

    for (int i = 0; i < s.length(); ++i) {
        char ch = s[i];
        if (bIsFirst) {
            if (ch == ' ')
                bIsFirst = true;
            else
                bIsFirst = false;
            
            ch = toupper(ch);
        } else {
            if (ch == ' ')
                bIsFirst = true;

            ch = tolower(ch);
        }
        answer += ch;
    }
    return answer;
}