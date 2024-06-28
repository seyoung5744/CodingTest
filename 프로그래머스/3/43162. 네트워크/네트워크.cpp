#include <bits/stdc++.h>

using namespace std;


vector<int> parents;

int Find(int x){
    if (x == parents[x])
        return x;
    
    return parents[x] = Find(parents[x]);
}

void Union(int a, int b){
    a = Find(a);
    b = Find(b);
    
    if (a < b)
    {
        parents[b] = a;
    } else {
        parents[a] = b;
    }
}



int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    
    parents = vector<int> (n);
    
    for(int i = 0; i < n; ++i){
        parents[i] = i;
    }
    

    for(int i = 0; i < computers.size(); ++i) {
        for(int j = 0; j < computers[i].size(); ++j){
            if (computers[i][j] == 1)
                Union(i, j);
        }
    }
    
    set<int> s;
    
    for(int i = 0; i < n; ++i) {
        s.insert(Find(i));
    }
    
    answer = s.size();
    
    return answer;
}