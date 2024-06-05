#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <map>
using namespace std;

int solution(string begin, string target, vector<string> words) {
    int answer = 0;
    
    if (find(words.begin(), words.end(), target) == words.end())
        return 0;
    
    map<string, int> m1;
    map<int, string> m2;

    m1.insert(make_pair(begin, m1.size()));
    m1.insert(make_pair(target, m1.size()));

    m2.insert(make_pair(m2.size(), begin));
    m2.insert(make_pair(m2.size(), target));

    for (int i = 0; i < words.size(); ++i)
    {
        if (m1.find(words[i]) == m1.end())
        {
            m1.insert(make_pair(words[i], m1.size()));
            m2.insert(make_pair(m2.size(), words[i]));
        }
    }

    vector<vector<bool>> graph(m1.size(), vector<bool>(m1.size(), false));

    for (int i = 0; i < graph.size(); ++i)
    {
        for (int j = i + 1; j < graph.size(); ++j)
        {
            string word1 = m2[i];
            string word2 = m2[j];

            int count = 0;
            for (int idx = 0; idx < word1.length(); ++idx)
            {
                if (word1[idx] != word2[idx])
                    ++count;

                if (count > 1)
                    break;
            }

            if (count == 1)
            {
                graph[i][j] = true;
                graph[j][i] = true;
            }
        }
    }

    vector<int> visited(m1.size(), 100);

    queue<int> q;
    q.push(m1[begin]);

    visited[m1[begin]] = 0;

    while (!q.empty())
    {
        int curIdx = q.front();
        q.pop();

        for (int i = 0; i < graph[curIdx].size(); ++i)
        {
            if (graph[curIdx][i] == false)
                continue;


            if (visited[i] <= visited[curIdx] + 1)
                continue;

            visited[i] = visited[curIdx] + 1;
            q.push(i);
        }
    }

    return answer == 100 ? 0 : visited[m1[target]];
}