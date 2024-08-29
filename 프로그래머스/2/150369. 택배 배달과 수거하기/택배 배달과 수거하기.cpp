#include <string>
#include <vector>
#include <queue>

using namespace std;

long long solution(int cap, int n, vector<int> deliveries, vector<int> pickups) {
    long long answer = 0;
    priority_queue<int, vector<int>, less<int>> d;
    priority_queue<int, vector<int>, less<int>> p;

    for (int i = 0; i < n; ++i)
    {
        if (deliveries[i] > 0)
        {
            d.push(i);
        }

        if (pickups[i] > 0)
        {
            p.push(i);
        }
    }

    
    while (!p.empty() || !d.empty())
    {
        int MaxDistance = 0;
        int pCount = cap;
        while (!p.empty())
        {
            int houseIndex = p.top();

            MaxDistance = max(MaxDistance, houseIndex + 1);

            p.pop();

            pCount -= pickups[houseIndex];


            if (pCount <= 0)
            {
                if (pCount < 0)
                {
                    pickups[houseIndex] = abs(pCount);
                    p.push(houseIndex);
                }
                break;
            }
        }

        int dCount = cap;
        while (!d.empty())
        {
            int houseIndex = d.top();
            MaxDistance = max(MaxDistance, houseIndex + 1);
            d.pop();

            dCount -= deliveries[houseIndex];

            if (dCount <= 0)
            {
                if (dCount < 0)
                {
                    deliveries[houseIndex] = abs(dCount);
                    d.push(houseIndex);
                }
                break;
            }
        }

        answer += MaxDistance * 2;
    }


    return answer;
}