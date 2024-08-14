#include <string>
#include <vector>
#include <cmath>

using namespace std;

int m = 10000000;

vector<int> solution(long long begin, long long end) {
    vector<int> answer (end - begin + 1, 0);

    for (int i = begin; i <= end; ++i)
    {
        if (i == 1)
        {
            answer[i - begin] = 0;
            continue;
        }

        for (int j = sqrt(i); j > 0; --j)
        {
            if (i % j == 0)
            {
                if (j == 1)
                {
                    answer[i - begin] = max(answer[i-begin], 1);
                    break;
                }
                if (i / j > m)
                {
                    answer[i - begin] = max(answer[i - begin], j);
                    continue;
                }

                answer[i - begin] = i / j;
            }
        }

    }

    return answer;
}