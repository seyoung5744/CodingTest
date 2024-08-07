#include <string>
#include <vector>
#include <map>
#include <cmath>

using namespace std;
map<string, int> m = { {"diamond", 0}, {"iron", 1},{"stone", 2} };
int answer = 1000000;

void Work(vector<int> picks, vector<string> minerals, int depth, int tired, int count, int currentPick, int total)
{
    if (depth >= minerals.size() || (count == 0 && total == 0))
    {
        answer = min(tired, answer);
        return;
    }

    string currentMineral = minerals[depth];

    if (count > 0)
    {
        int t = pow(5, max(currentPick - m[currentMineral], 0));
        Work(picks, minerals, depth + 1, tired + t, count - 1, currentPick, total);
    }
    else
    {
        for (int i = 0; i < picks.size(); ++i)
        {
            if (picks[i] <= 0)
                continue;

            currentPick = i;
            --picks[i];
            count = 5;
            int t = pow(5, max(currentPick - m[currentMineral], 0));
            Work(picks, minerals, depth + 1, tired + t, count - 1, currentPick, total - 1);
            ++picks[i];
        }
    }
}

int solution(vector<int> picks, vector<string> minerals) {

    int total = 0;
    
    for(int i = 0; i < picks.size(); ++i)
    {
        total += picks[i];
    }
    
    Work(picks, minerals, 0, 0, 0, 0, total);

    return answer;
}