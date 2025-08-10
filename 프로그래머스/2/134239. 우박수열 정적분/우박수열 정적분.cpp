#include <string>
#include <vector>

using namespace std;

vector<double> solution(int k, vector<vector<int>> ranges) {
    vector<int> Collatz;
    int count = 0;
    while(true)
    {
        Collatz.push_back(k);
        
        if (k == 1)
            break;
        
        if (k % 2 == 0)
        {
            k /= 2;
        }
        else
        {
            k = k * 3 + 1;
        }
        
        ++count;
    }
    
    vector<double> areas;
    for(int i = 0; i < Collatz.size() - 1; ++i)
    {
        int upperWidth = Collatz[i];
        int lowerWidth = Collatz[i + 1];

        areas.push_back((upperWidth + lowerWidth) / 2.f);
    }
    
    vector<double> answer;
    
    for(int i = 0; i < ranges.size(); ++i)
    {
        int start = ranges[i][0];
        int end = count + ranges[i][1];
        
        double area = 0.f;
        
        if (end < start)
            area = -1.f;
        else if (start < end)
        {
            for(int j = start; j < end; ++j)
            {
                area += areas[j];
            }
        }
        
        answer.push_back(area);
    }
    
    return answer;
}