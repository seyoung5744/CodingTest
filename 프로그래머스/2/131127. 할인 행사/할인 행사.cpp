#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

map<string, int> m;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    int days = 0;
    
    for(int i = 0; i < want.size(); ++i) {
        m.insert(make_pair(want[i], i));
    }
    
    for(int i = 0; i < discount.size(); ++i) {
        if (m.find(discount[i]) != m.end())
            --number[m[discount[i]]];
        
        if (i - 10 >= 0) {
            if (m.find(discount[i-10]) != m.end())
                ++number[m[discount[i-10]]];
        }
        
        bool flag = true;
        for(int j = 0; j < number.size() && flag; ++j) {
            if (number[j] != 0)
                flag = false;
        }
        
        if (flag) {
            cout << i + 1 << endl;
            ++answer;
        }
        
    }
    
    return answer;
}