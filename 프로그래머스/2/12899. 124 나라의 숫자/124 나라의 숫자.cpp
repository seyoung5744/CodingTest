#include <string>
#include <vector>
#include <map>

using namespace std;

map<int, int> m = {{0, 1}, {1, 2}, {2, 4}};
string solution(int n) {
    string answer = "";
    
    
    while(n > 0)
    {
        --n;
        int rest = n % 3;
        
        answer = to_string(m[rest]) + answer;
        
        n /= 3;
    }
    
    return answer;
}