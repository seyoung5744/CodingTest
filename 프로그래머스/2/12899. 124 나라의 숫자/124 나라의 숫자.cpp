#include <string>
#include <vector>
#include <map>

using namespace std;

map<int, char> m = {{0, '1'}, {1, '2'}, {2, '4'}};

string solution(int n) {
    string answer = "";
    
    while(n > 0)
    {
        --n;
        answer = m[n % 3] + answer;
        n /= 3;
    }
    return answer;
}