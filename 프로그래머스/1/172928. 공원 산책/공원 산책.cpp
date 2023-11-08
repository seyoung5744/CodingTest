#include <string>
#include <vector>
#include <map>
using namespace std;

map<char, pair<int, int>> Cmd = {{'E', {0, 1}}, 
                                {'W', {0, -1}},
                                {'N', {-1, 0}},
                                {'S', {1, 0}}};

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    
    int curX, curY;
    
    for(int i = 0; i < park.size(); ++i)
    {
        for(int j = 0; j < park[i].length(); ++j)
        {
            if (park[i][j] == 'S')
            {
                curX = j;
                curY = i;
                break;
            }
        }
    }
    
    for(int i = 0; i < routes.size(); ++i)
    {
        auto [dy, dx] = Cmd[routes[i][0]];
        int dis = stoi(routes[i].substr(2, 4));
        
        int tempX = curX;
        int tempY = curY;
        bool flag = true;
        for(int j = 0; j < dis; ++j)
        {
            tempX += dx;
            tempY += dy;
            
            if (tempX < 0 || tempX >= park[0].length() ||  
               tempY < 0 || tempY >= park.size() || park[tempY][tempX] == 'X')
            {
                flag = false;
                break;
            }
        }
        
        if (flag)
        {
            curX = tempX;
            curY = tempY;
        }
    }
    
    answer = {curY, curX};
    return answer;
}