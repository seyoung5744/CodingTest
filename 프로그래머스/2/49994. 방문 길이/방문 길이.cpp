#include <string>
#include <vector>
#include <set>
#include <iostream>
using namespace std;

int solution(string dirs) {
    int answer = 0;
    
    vector<vector<int>> map (11, vector<int> (11, 0));
    set<pair<pair<int, int>, pair<int ,int>>> check;
    int curX = 5;
    int curY = 5;
    
    for(int i = 0; i < dirs.length(); ++i)
    {
        char dir = dirs[i];
        int newX = curX;
        int newY = curY;
        
        if (dir == 'U')
        {
            --newY;
        }
        else if (dir == 'D')
        {
            ++newY;
        }
        else if (dir == 'R')
        {
            ++newX;
        }
        else if (dir == 'L')
        {
            --newX;
        }
        
        if (newX < 0 || newX > 10 || newY < 0 || newY > 10)
            continue;
        
        check.insert({{newY, newX}, {curY, curX}});
        check.insert({{curY, curX}, {newY, newX}});
        curX = newX;
        curY = newY;
    }
    
    answer = check.size() / 2;
    
    return answer;
}