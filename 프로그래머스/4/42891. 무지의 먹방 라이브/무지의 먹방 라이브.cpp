#include <string>
#include <vector>
#include <map>
using namespace std;

int solution(vector<int> food_times, long long k) {
    int answer = 0;
    map<int, int> count;

    for (int i = 0; i < food_times.size(); ++i) {
        count[food_times[i]]++;
    }

    long long curTime = 0;
    long long totalFood = food_times.size();

    int target = 0;
    int cycle = 0;
    int totalCycle = 0;
    for (auto item : count){
        int min = item.first;
        int minCount = item.second;
        
        while (cycle < min) {
            if (curTime + totalFood > k)
                break;

            curTime += totalFood;
            ++cycle;
        }

        if (cycle == min)
            totalFood -= minCount;
        else {
            target = min;
            break;
        }
    }

    if (totalFood == 0)
        return -1;
    
    for (int i = 0; i < food_times.size(); i++) {
        if (food_times[i] < target) continue;

        if (curTime == k)
            return i + 1;

        curTime++;
    }

    return -1;
}