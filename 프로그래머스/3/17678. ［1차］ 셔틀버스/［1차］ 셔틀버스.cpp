#include <string>
#include <vector>
#include <algorithm>
#include <queue>
#include <iostream>
using namespace std;


string solution(int n, int t, int m, vector<string> timetable) {
    string answer = "";
    int ans = 0;
    
    vector<int> tt(timetable.size());
    priority_queue<int, vector<int>, greater<int>> pq;
    
    for(int i = 0; i < timetable.size(); ++i)
    {
        int hour = stoi(timetable[i].substr(0, 2));
        int minute = stoi(timetable[i].substr(3));
        pq.push(hour * 60 + minute);
    }
    
    cout << pq.top() << endl;
    
    int currentTime = 9 * 60;
    
    for(int i = 0; i < n; ++i)
    {
        int pCount = 0;

        while(pCount < m && !pq.empty())
        {
            if (pq.top() <= currentTime)
            {
                ans = pq.top();
                pq.pop();
                ++pCount;
            }
            else
            {
                break;
            }
        }
        
        if (i == n-1)
        {
            if (pCount == m)
                --ans;
            else
                ans = currentTime;
        }
        
        currentTime += t;
    }
    
    string hour = "";
    hour += to_string(ans/60);
    if (hour.length() == 1)
        hour = "0" + hour;
    
    string minute = "";
    minute += to_string(ans%60);
    if (minute.length() == 1)
        minute = "0" + minute;
    
    answer = hour + ":" + minute;
    
    
    return answer;
}