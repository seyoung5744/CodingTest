#include <string>
#include <vector>
#include <cmath>
using namespace std;

int answer = 2100000000;

vector<int> mem (1000001, 210000000);
void recursive(int cur, int target, int n, int count)
{
    mem[cur] = count;
    
    if(cur <= 0) 
        return;
    
    if (count >= answer || cur < target)
        return;
    
    if (cur == target)
    {
        answer = min(answer, count);
        return;
    }
    
    if (cur % 2 == 0)
    {
        if (mem[cur/2] > count + 1)
            recursive(cur / 2, target, n, count + 1);
            
    }
    
    if (cur % 3 == 0)
    {
        if (mem[cur/3] > count + 1)
            recursive(cur / 3, target, n, count + 1);
    }
    
    if (cur - n >= target)
        if (mem[cur - n] > count + 1)
            recursive(cur - n, target, n, count + 1);
}

int solution(int x, int y, int n) {
    recursive(y, x, n, 0);
    
    if (answer == 2100000000)
        answer = -1;
    
    return answer;
}