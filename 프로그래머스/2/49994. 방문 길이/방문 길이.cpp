#include <string>
#include <set>
#include <map>
#include <cmath>
#include <iostream>
using namespace std;

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

map<char, int> m = {{'L', 3}, {'R', 2}, {'U', 1}, {'D', 0}};
int solution(string dirs) {
    int answer = 0;
    
    int curX = 5;
    int curY = 5;
    
    int x = 10;
    int x2 = 11;
    
    set<int> r;
    
    for(int i = 0; i < dirs.length(); ++i){
        int dir = m[dirs[i]];
        
        int nx = curX + dx[dir];
        int ny = curY + dy[dir];
        
        if (nx < 0 || nx > 10 || ny < 0 || ny > 10)
            continue;
        
        int num = 0;
        if (nx == curX){
            num = max(ny, curY) * (x + x2) - (x2 - nx);
        }else{
            num = curY * (x + x2) + min(nx, curX);
        }
        r.insert(num);
    
        curX = nx;
        curY = ny;
    }
    
    answer = r.size();
    return answer;
}