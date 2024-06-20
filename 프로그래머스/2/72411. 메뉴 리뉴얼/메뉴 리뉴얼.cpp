#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <iostream>
using namespace std;

map<string, int> m;
vector<int> maxCount (11, 0);
vector<bool> check(11, false);

void Make(string& s, int idx, string course) {
    if (check[course.length()]) {
        ++m[course];
        
        if (maxCount[course.length()] < m[course])
            maxCount[course.length()] = m[course];
    }
    
    if (idx >= s.length()) {
        return;
    }
    
    for(int i = idx; i < s.length(); ++i) {
        Make(s, i + 1, course + s[i]);
    }
}

void MakeComb(string s) {
    Make(s, 0, "");
}


vector<string> solution(vector<string> orders, vector<int> course) {
    vector<string> answer;

    
    for(int i = 0; i < course.size(); ++i) {
        check[course[i]] = true;
    }
    
    for(int i = 0; i < orders.size(); ++i) {
        string menu = orders[i];
        sort(menu.begin(), menu.end());
        MakeComb(menu);
    }
    
    for(const auto item : m) {
        string menu = item.first;
        int count = item.second;
        
        if (count == maxCount[menu.length()] && count >= 2) {
            answer.push_back(menu);
        }
    }
    
    sort(answer.begin(), answer.end());
    return answer;
}