#include <string>
#include <vector>
#include <cmath>
#include <iostream>

using namespace std;

long long solution(int r1, int r2) {
    long long answer = 0;

    for (long long x = 0; x <= r2; ++x)
    {
        long long inyy = (long long)r1 * r1 - x * x;
        long long outyy = (long long)r2 * r2 - x * x;

        double iny = sqrt(inyy);
        if (x > r1)
            iny = 0;


        double outy = sqrt(outyy);

        iny = ceil(iny);
        outy = floor(outy);

        if (x == 0)
        {
            answer += (outy - iny + 1) * 2;
        }
        else if (iny == 0)
        {
            answer += (outy) * 4;
            answer += 2;
        }
        else
        {
            answer += (outy - iny + 1) * 4;
        }
    }
    return answer;
}