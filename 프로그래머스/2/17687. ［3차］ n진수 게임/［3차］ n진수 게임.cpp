#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

map<int, char> m = {{0, '0'}, {1, '1'}, {2, '2'}, {3, '3'}, {4, '4'}, {5, '5'}, {6, '6'}, 
                   {7, '7'}, {8, '8'}, {9, '9'}, {10, 'A'}, {11, 'B'}, {12, 'C'}, {13, 'D'}, 
                   {14, 'E'}, {15, 'F'}};

string Convert(int num, int n)
{
    if (num == 0)
        return "0";
    
    string answer = "";
    
    while(num > 0)
    {
        answer = m[(num % n)] + answer;
        num /= n;
    }
    
    return answer;
}
string solution(int n, int t, int m, int p) {
    string answer = "";
    string s = "";
    int num = 0;
    while(s.length() < t * m)
    {
        s += Convert(num++, n);
    }
    
    int idx = p - 1;
    while(answer.length() < t)
    {
        answer += s[idx];
        idx += m;
    }
    
    return answer;
}