#include <string>
#include <vector>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <map>
#include <queue>

using namespace std;

int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    map<string, int> cache;
    queue<string> q;

    for (int i = 0; i < cities.size(); ++i) {
        string c = cities[i];
        transform(c.begin(), c.end(), c.begin(), [](auto c){return std::tolower(c);});
        q.push(c);

        if (cache[c] == 0) {
            answer += 5;
        } else {
            answer += 1;
        }

        ++cache[c];

        while (cache.size() > cacheSize) {
            string r = q.front();
            q.pop();

            --cache[r];

            if (cache[r] == 0) {
                cache.erase(r);
            }
        }
    }
    return answer;
}