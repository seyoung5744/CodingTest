#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

vector<int> solution(int rows, int columns, vector<vector<int>> queries) {
    vector<int> answer;
    
    vector<vector<int>> map(rows + 1, vector<int> (columns + 1));
    
    int count = 1;
    for(int i = 1; i < rows + 1; ++i)
    {
        for(int j = 1; j < columns + 1; ++j)
        {
            map[i][j] = count;
            ++count;
        }
    }
    
    for(int i = 0; i < queries.size(); ++i)
    {
        int topLeftI = queries[i][0];
        int topLeftJ = queries[i][1];
        int bottomI = queries[i][2];
        int bottomJ = queries[i][3];
        
        int curI = topLeftI;
        int curJ = topLeftJ;
        
        int before = map[curI][curJ];
        int minimum = before;
        
        while(true)
        {
            int dir;
            if (curI == topLeftI && curJ != bottomJ)
            {
                dir = 0;
            }
            else if (curJ == bottomJ && curI != bottomI)
            {
                dir = 1;
            }
            else if (curI == bottomI && curJ != topLeftJ)
            {
                dir = 2;
            }
            else
            {
                dir = 3;
            }
            
            int nextI = curI + dy[dir];
            int nextJ = curJ + dx[dir];
            
            int temp = map[nextI][nextJ];
            map[nextI][nextJ] = before;
            before = temp;
            curI = nextI;
            curJ = nextJ;
            
            minimum = min(temp, minimum);
            
            if (curI == topLeftI && curJ == topLeftJ)
                break;
        }
        
        answer.push_back(minimum);
    }
    return answer;
}