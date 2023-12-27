#include <cmath>

using namespace std;

int GetGCD(int a, int b){
    if(a % b == 0){
        return b;
    }
    return GetGCD(b, a % b);
}

long long solution(int w,int h) {
    long long answer = 1;
    
    int gcd = GetGCD(w, h);
    
    long long minW = (long long)w / gcd;
    long long minH = (long long)h / gcd;
    
    int deleted = minW * minH - (minW - 1) * (minH - 1);
    
    return (long long)w * h - (deleted * gcd);
    return answer;
}