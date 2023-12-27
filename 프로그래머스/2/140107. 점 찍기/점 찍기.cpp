#include <string>
#include <vector>
#include <cmath>
#include <iostream>

using namespace std;

long long solution(int k, int d) {
    long long answer = 0;
    long long dd = (long long)d * d;
    
    for(long long y = 0; y <= d; y += k)
    {
        long long x = sqrt(dd - y*y);
        answer += (x / k) + 1;
    }
    return answer;
}